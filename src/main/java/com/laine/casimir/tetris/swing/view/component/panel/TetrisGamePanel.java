package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.base.api.TetrisConstants;
import com.laine.casimir.tetris.base.api.TetrisController;
import com.laine.casimir.tetris.base.api.model.BaseTetromino;
import com.laine.casimir.tetris.base.api.model.ClearData;
import com.laine.casimir.tetris.base.api.model.TetrisCell;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.SwingTetrisSettings;
import com.laine.casimir.tetris.swing.control.SwingKeyControls;
import com.laine.casimir.tetris.swing.view.component.MinoView;
import com.laine.casimir.tetris.swing.view.component.TetrisGrid;
import com.laine.casimir.tetris.swing.view.component.fragment.HoldBoxFragment;
import com.laine.casimir.tetris.swing.view.component.fragment.InfoFragment;
import com.laine.casimir.tetris.swing.view.component.fragment.NextTetrominoFragment;
import com.laine.casimir.tetris.swing.view.layout.TetrisGridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.Timer;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public final class TetrisGamePanel extends JLayeredPane {

    private final Color transparent = new Color(0, 0, 0, 0);
    private final SwingTetrisSettings settings = new SwingTetrisSettings();

    private final SwingKeyControls gameControls = new SwingKeyControls(this);
    private final Timer gameLoopTimer;

    private final Timer clearAnimationTimer;

    private final JFrame frame;
    private final PauseMenuPanel pauseMenuPanel;

    private final CountDownPanel countDownPanel = new CountDownPanel(TetrisConstants.COUNT_DOWN);

    private final List<MinoView> minoViews = new ArrayList<>();
    private final TetrisGrid tetrisGrid = new TetrisGrid(TetrisConstants.WIDTH, TetrisConstants.VISIBLE_HEIGHT);
    private final HoldBoxFragment holdBoxFragment = new HoldBoxFragment();
    private final NextTetrominoFragment nextTetrominoFragment = new NextTetrominoFragment();
    private final InfoFragment infoFragment = new InfoFragment();
    private final GameOverPanel gameOverPanel;

    private final TetrisController tetrisController;

    private ClearData clearData;

    private long clearAnimationStarted;
    private boolean clearInvisible;

    public TetrisGamePanel(JFrame frame) {
        this.frame = frame;
        this.pauseMenuPanel = new PauseMenuPanel(frame, this);
        this.gameOverPanel = new GameOverPanel(frame, this);
        this.tetrisController = new TetrisController();
        gameLoopTimer = new Timer(0, e -> update());
        gameLoopTimer.setDelay(0);
        gameLoopTimer.setRepeats(true);
        clearAnimationTimer = new Timer(0, e -> animateClear());
        clearAnimationTimer.setDelay(SwingTetrisConstants.CLEAR_BLINK_INTERVAL);
        clearAnimationTimer.setRepeats(true);
        init();
    }

    private void init() {
        addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                if (event.getAncestor() == TetrisGamePanel.this) {
                    gameControls.setTetrisController(tetrisController);
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(gameControls);
                }
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                if (event.getAncestor() == TetrisGamePanel.this) {
                    gameControls.setTetrisController(null);
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(gameControls);
                }
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }
        });
        final JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(holdBoxFragment);
        leftPanel.add(infoFragment);
        tetrisGrid.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                final int cellSize = tetrisGrid.getCellSize();
                holdBoxFragment.setCellSize(cellSize);
                nextTetrominoFragment.setCellSize(cellSize);
                leftPanel.setPreferredSize(new Dimension(cellSize * 5, getHeight()));
                nextTetrominoFragment.setPreferredSize(new Dimension(cellSize * 5, getHeight()));
            }
        });
        tetrisGrid.setBackground(SwingTetrisConstants.COLOR_GRID_BACKGROUND);
        tetrisGrid.setForeground(SwingTetrisConstants.COLOR_GRID_FOREGROUND);
        tetrisGrid.setLayout(new TetrisGridLayout(tetrisGrid.getColCount(), tetrisGrid.getRowCount()));
        for (int y = 0; y < tetrisGrid.getRowCount(); y++) {
            for (int x = 0; x < tetrisGrid.getColCount(); x++) {
                final MinoView minoView = new MinoView();
                minoView.setBackground(transparent);
                minoView.setForeground(transparent);
                tetrisGrid.add(minoView, new Point(x, y));
                minoViews.add(minoView);
            }
        }
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(tetrisGrid, BorderLayout.CENTER);
        panel.add(nextTetrominoFragment, BorderLayout.EAST);
        setLayout(new OverlayLayout(this));
        add(panel, Integer.valueOf(0));
        add(countDownPanel, Integer.valueOf(1));
        add(gameOverPanel, Integer.valueOf(2));
        tetrisController.start();
        resume();
    }

    public void pause() {
        if (!tetrisController.isGameOver()) {
            countDownPanel.stop();
            countDownPanel.setVisible(false);
            gameLoopTimer.stop();
            frame.setContentPane(pauseMenuPanel);
            tetrisController.pause();
        }
    }

    public void resume() {
        frame.setContentPane(TetrisGamePanel.this);
        countDownPanel.setVisible(true);
        countDownPanel.start(() -> {
            countDownPanel.setVisible(false);
            tetrisController.resume();
            gameLoopTimer.start();
        });
    }

    private void update() {
        clearData = tetrisController.collectClearData();
        if (clearData != null) {
            clearAnimationStarted = System.currentTimeMillis();
            clearAnimationTimer.start();
            gameLoopTimer.stop();
            return;
        }
        tetrisController.update();
        if (tetrisController.isPaused()) {
            countDownPanel.stop();
            gameLoopTimer.stop();
            frame.setContentPane(pauseMenuPanel);
        }
        if (tetrisController.isGameOver()) {
            gameLoopTimer.stop();
            gameOverPanel.setVisible(true);
        }
        render();
    }

    private void render() {
        renderGrid();
        holdBoxFragment.setTetromino(tetrisController.getHeldTetromino());
        nextTetrominoFragment.clear();
        final BaseTetromino[] previewTetrominos = tetrisController.getPreviewTetrominos(settings.getNextQueueCount());
        for (final BaseTetromino tetromino : previewTetrominos) {
            nextTetrominoFragment.addTetromino(tetromino);
        }
        infoFragment.setScore(tetrisController.getScore());
        infoFragment.setLevel(tetrisController.getLevel());
        infoFragment.setLines(tetrisController.getClearedRows());
    }

    private void renderGrid() {
        for (int index = 0; index < minoViews.size(); index++) {
            minoViews.get(index).setBackground(transparent);
            minoViews.get(index).setForeground(transparent);
        }
        final List<TetrisCell> ghostCells = tetrisController.getGhostCells();
        renderCells(ghostCells, true, null);
        final List<TetrisCell> allCells = tetrisController.getAllCells();
        renderCells(allCells, false, null);
        tetrisGrid.revalidate();
        tetrisGrid.repaint();
    }

    private void renderCells(List<TetrisCell> cells, boolean ghost, Color color) {
        for (int index = 0; index < cells.size(); index++) {
            final TetrisCell tetrisCell = cells.get(index);
            if (tetrisCell != null) {
                final int uiMinoIndex = tetrisGrid.getColCount() * tetrisCell.getY() + tetrisCell.getX();
                if (uiMinoIndex >= 0 && uiMinoIndex < minoViews.size()) {
                    minoViews.get(uiMinoIndex).setBackground(color == null ? Color.decode(tetrisCell.getColorHex()) : color);
                    minoViews.get(uiMinoIndex).setForeground(SwingTetrisConstants.COLOR_TETROMINO_BORDER);
                    minoViews.get(uiMinoIndex).setGhostMode(ghost);
                }
            }
        }
    }

    private void animateClear() {
        if (clearData == null || System.currentTimeMillis() - clearAnimationStarted >= SwingTetrisConstants.CLEAR_BLINK_TOTAL) {
            clearData = null;
            clearAnimationTimer.stop();
            gameLoopTimer.start();
            return;
        }
        renderCells(clearData.getClearedTetrisCells(), false, clearInvisible ? transparent : SwingTetrisConstants.CLEAR_BLINK_COLOR);
        clearInvisible = !clearInvisible;
        tetrisGrid.revalidate();
        tetrisGrid.repaint();
    }
}
