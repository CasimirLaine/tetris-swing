package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.base.control.TetrisController;
import com.laine.casimir.tetris.base.event.TetrisGameListener;
import com.laine.casimir.tetris.base.model.*;
import com.laine.casimir.tetris.base.model.tetromino.AbstractTetromino;
import com.laine.casimir.tetris.swing.SwingTetrisSettings;
import com.laine.casimir.tetris.swing.control.SwingKeyControls;
import com.laine.casimir.tetris.swing.view.component.JTetrisGrid;
import com.laine.casimir.tetris.swing.view.component.JTetrisSquare;
import com.laine.casimir.tetris.swing.view.component.fragment.JHoldBoxFragment;
import com.laine.casimir.tetris.swing.view.component.fragment.JInfoFragment;
import com.laine.casimir.tetris.swing.view.component.fragment.JNextTetrominoFragment;
import com.laine.casimir.tetris.swing.view.layout.TetrisGridLayout;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class JTetrisGamePanel extends JPanel {

    private final Color transparent = new Color(0, 0, 0, 0);
    private final SwingTetrisSettings settings = new SwingTetrisSettings();

    private final SwingKeyControls gameControls = new SwingKeyControls();
    private Timer timer;

    private final JFrame frame;
    private final JPauseMenuPanel pauseMenuPanel;

    private final List<JTetrisSquare> tetrisSquares = new ArrayList<>();
    private final JTetrisGrid tetrisGrid = new JTetrisGrid(Playfield.WIDTH, Playfield.VISIBLE_HEIGHT);
    private final TetrisGridLayout tetrisGridLayout = new TetrisGridLayout(Playfield.WIDTH, Playfield.VISIBLE_HEIGHT);
    private final JHoldBoxFragment holdBoxFragment = new JHoldBoxFragment();
    private final JNextTetrominoFragment nextTetrominoFragment = new JNextTetrominoFragment();
    private final JInfoFragment infoFragment = new JInfoFragment();

    private final TetrisGame tetrisGame = new TetrisGame();
    private final TetrisController tetrisController;

    private long lastDrop;

    public JTetrisGamePanel(JFrame frame) {
        this.frame = frame;
        this.pauseMenuPanel = new JPauseMenuPanel(frame, this);
        this.tetrisController = new TetrisController(tetrisGame);
        this.tetrisController.setTetrisGameListener(tetrisGameListener);
        timer = new Timer(0, e -> {
            if (!tetrisGame.isGameOver() && System.currentTimeMillis() - lastDrop >= tetrisGame.getDropInterval()) {
                tetrisController.drop();
                lastDrop = System.currentTimeMillis();
            }
            render();
        });
        timer.setDelay(0);
        timer.setRepeats(true);
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
        setLayout(new GridBagLayout());
        tetrisGrid.setBackground(Color.decode(Playfield.BACKGROUND_COLOR));
        tetrisGrid.setForeground(Color.decode(Playfield.GRID_COLOR));
        tetrisGrid.setLayout(tetrisGridLayout);
        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.2;
        constraints.weighty = 1.0;
        final JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(holdBoxFragment);
        leftPanel.add(infoFragment);
        add(leftPanel, constraints.clone());
        constraints.weightx = 0.6;
        add(tetrisGrid, constraints.clone());
        constraints.weightx = 0.2;
        add(nextTetrominoFragment, constraints.clone());
        for (int y = 0; y < tetrisGrid.getRowCount(); y++) {
            for (int x = 0; x < tetrisGrid.getColCount(); x++) {
                final JTetrisSquare tetrisSquare = new JTetrisSquare();
                tetrisSquare.setBackground(new Color(0, 0, 0, 0));
                tetrisGrid.add(tetrisSquare, new Point(x, y));
                tetrisSquares.add(tetrisSquare);
            }
        }
        tetrisController.start();
        timer.start();
    }

    public void resume() {
        tetrisController.resume();
    }

    private void setPausePanelVisible(boolean pausePanelVisible) {
        if (pausePanelVisible) {
            frame.setContentPane(pauseMenuPanel);
        } else {
            frame.setContentPane(this);
        }
    }

    private void render() {
        for (int index = 0; index < tetrisSquares.size(); index++) {
            tetrisSquares.get(index).setBackground(transparent);
        }
        final Playfield playfield = tetrisGame.getPlayfield();
        final List<Square> landedSquares = playfield.getLandedSquares();
        for (int index = 0; index < landedSquares.size(); index++) {
            final Square square = landedSquares.get(index);
            if (square != null) {
                final Position position = square.getPosition();
                final int uiSquareIndex = tetrisGrid.getColCount() * position.getY() + position.getX();
                if (uiSquareIndex >= 0 && uiSquareIndex < tetrisSquares.size()) {
                    tetrisSquares.get(uiSquareIndex).setBackground(Color.decode(square.getColorHex()));
                }
            }
        }
        final FallingTetromino fallingTetromino = playfield.getFallingTetromino();
        if (fallingTetromino != null) {
            final AbstractTetromino tetromino = fallingTetromino.getTetromino();
            final Position[] positions = fallingTetromino.getTetromino().getSquarePositions();
            final Position offset = fallingTetromino.getPosition();
            for (Position position : positions) {
                final int uiSquareIndex = tetrisGrid.getColCount() * (position.getY() + offset.getY()) + (position.getX() + offset.getX());
                if (uiSquareIndex >= 0 && uiSquareIndex < tetrisSquares.size()) {
                    tetrisSquares.get(uiSquareIndex).setBackground(Color.decode(tetromino.getColorHex()));
                }
            }
        }
        tetrisGrid.revalidate();
        tetrisGrid.repaint();
        holdBoxFragment.setTetromino(tetrisGame.getHoldBox().getTetromino());
        nextTetrominoFragment.clear();
        for (int index = 0; index < settings.getNextQueueCount(); index++) {
            nextTetrominoFragment.addTetromino(tetrisGame.getTetrominoQueue().getPreview(index));
        }
        infoFragment.setLines(tetrisGame.getPlayfield().getClearedRows());
    }

    private final TetrisGameListener tetrisGameListener = event -> {
        switch (event) {
            case PAUSE:
                setPausePanelVisible(true);
                break;
            case RESUME:
                setPausePanelVisible(false);
                break;
        }
    };
}
