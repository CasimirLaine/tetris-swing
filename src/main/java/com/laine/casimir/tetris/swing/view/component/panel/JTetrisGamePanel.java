package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.base.api.TetrisConstants;
import com.laine.casimir.tetris.base.api.TetrisController;
import com.laine.casimir.tetris.base.api.model.BaseTetromino;
import com.laine.casimir.tetris.base.api.model.ClearData;
import com.laine.casimir.tetris.base.api.model.TetrisCell;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.SwingTetrisSettings;
import com.laine.casimir.tetris.swing.control.SwingKeyControls;
import com.laine.casimir.tetris.swing.view.component.JMino;
import com.laine.casimir.tetris.swing.view.component.JTetrisGrid;
import com.laine.casimir.tetris.swing.view.component.fragment.GameOverFragment;
import com.laine.casimir.tetris.swing.view.component.fragment.JHoldBoxFragment;
import com.laine.casimir.tetris.swing.view.component.fragment.JInfoFragment;
import com.laine.casimir.tetris.swing.view.component.fragment.JNextTetrominoFragment;
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

public final class JTetrisGamePanel extends JLayeredPane {

    private final Color transparent = new Color(0, 0, 0, 0);
    private final SwingTetrisSettings settings = new SwingTetrisSettings();

    private final SwingKeyControls gameControls = new SwingKeyControls();
    private final Timer gameLoopTimer;

    private final Timer clearAnimationTimer;

    private final JFrame frame;
    private final JPauseMenuPanel pauseMenuPanel;

    private final JCountDownPanel countDownPanel = new JCountDownPanel(TetrisConstants.COUNT_DOWN);

    private final List<JMino> tetrisSquares = new ArrayList<>();
    private final JTetrisGrid tetrisGrid = new JTetrisGrid(TetrisConstants.WIDTH, TetrisConstants.VISIBLE_HEIGHT);
    private final JHoldBoxFragment holdBoxFragment = new JHoldBoxFragment();
    private final JNextTetrominoFragment nextTetrominoFragment = new JNextTetrominoFragment();
    private final JInfoFragment infoFragment = new JInfoFragment();
    private final GameOverFragment gameOverFragment;

    private final TetrisController tetrisController;

    private ClearData clearData;

    private long clearAnimationStarted;
    private boolean clearInvisible;

    public JTetrisGamePanel(JFrame frame) {
        this.frame = frame;
        this.pauseMenuPanel = new JPauseMenuPanel(frame, this);
        this.gameOverFragment = new GameOverFragment(frame, this);
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
                if (event.getAncestor() == JTetrisGamePanel.this) {
                    gameControls.setTetrisController(tetrisController);
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(gameControls);
                }
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                if (event.getAncestor() == JTetrisGamePanel.this) {
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
        tetrisGrid.setBackground(SwingTetrisConstants.COLOR_BACKGROUND);
        tetrisGrid.setForeground(SwingTetrisConstants.COLOR_COLOR);
        tetrisGrid.setLayout(new TetrisGridLayout(tetrisGrid.getColCount(), tetrisGrid.getRowCount()));
        for (int y = 0; y < tetrisGrid.getRowCount(); y++) {
            for (int x = 0; x < tetrisGrid.getColCount(); x++) {
                final JMino tetrisSquare = new JMino();
                tetrisSquare.setBackground(new Color(0, 0, 0, 0));
                tetrisSquare.setForeground(SwingTetrisConstants.COLOR_BACKGROUND);
                tetrisGrid.add(tetrisSquare, new Point(x, y));
                tetrisSquares.add(tetrisSquare);
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
        add(gameOverFragment, Integer.valueOf(2));
        tetrisController.start();
        resume();
    }

    public void resume() {
        frame.setContentPane(JTetrisGamePanel.this);
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
            gameLoopTimer.stop();
            frame.setContentPane(pauseMenuPanel);
        }
        if (tetrisController.isGameOver()) {
            gameLoopTimer.stop();
            gameOverFragment.setVisible(true);
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
        for (int index = 0; index < tetrisSquares.size(); index++) {
            tetrisSquares.get(index).setBackground(transparent);
        }
        final List<TetrisCell> ghostCells = tetrisController.getGhostCells();
        renderCells(ghostCells, true, null);
        final List<TetrisCell> allSquares = tetrisController.getAlLCells();
        renderCells(allSquares, false, null);
        tetrisGrid.revalidate();
        tetrisGrid.repaint();
    }

    private void renderCells(List<TetrisCell> cells, boolean ghost, Color color) {
        for (int index = 0; index < cells.size(); index++) {
            final TetrisCell tetrisCell = cells.get(index);
            if (tetrisCell != null) {
                final int uiSquareIndex = tetrisGrid.getColCount() * tetrisCell.getY() + tetrisCell.getX();
                if (uiSquareIndex >= 0 && uiSquareIndex < tetrisSquares.size()) {
                    tetrisSquares.get(uiSquareIndex).setBackground(color == null ? Color.decode(tetrisCell.getColorHex()) : color);
                    tetrisSquares.get(uiSquareIndex).setGhostMode(ghost);
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
