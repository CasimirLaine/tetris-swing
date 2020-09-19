package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.base.control.TetrisController;
import com.laine.casimir.tetris.base.event.TetrisGameListener;
import com.laine.casimir.tetris.base.model.Playfield;
import com.laine.casimir.tetris.base.model.TetrisGame;
import com.laine.casimir.tetris.swing.control.SwingKeyControls;
import com.laine.casimir.tetris.swing.view.component.JTetrisFrame;
import com.laine.casimir.tetris.swing.view.component.JTetrisGrid;
import com.laine.casimir.tetris.swing.view.component.fragment.JHoldBoxFragment;
import com.laine.casimir.tetris.swing.view.component.fragment.JNextTetrominoFragment;
import com.laine.casimir.tetris.swing.view.layout.TetrisGridLayout;

import javax.swing.*;
import java.awt.*;

class JTetrisGamePanel extends JPanel {

    private final JTetrisFrame frame;
    private final JPauseMenuPanel pauseMenuPanel;

    private final TetrisGame tetrisGame = new TetrisGame();
    private final TetrisController tetrisController;

    private final JTetrisGrid tetrisGrid = new JTetrisGrid();
    private final TetrisGridLayout tetrisGridLayout = new TetrisGridLayout(Playfield.WIDTH, Playfield.VISIBLE_HEIGHT);
    private final JHoldBoxFragment holdBoxFragment = new JHoldBoxFragment();
    private final JNextTetrominoFragment nextTetrominoFragment = new JNextTetrominoFragment();

    public JTetrisGamePanel(JTetrisFrame frame) {
        this.frame = frame;
        this.pauseMenuPanel = new JPauseMenuPanel(frame, this);
        this.tetrisController = new TetrisController(tetrisGame);
        this.tetrisGame.setTetrisGameListener(tetrisGameListener);
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new SwingKeyControls(tetrisController));
        tetrisGrid.setBackground(Color.decode(Playfield.BACKGROUND_COLOR));
        tetrisGrid.setForeground(Color.decode(Playfield.GRID_COLOR));
        tetrisGrid.setLayout(tetrisGridLayout);
        add(tetrisGrid, BorderLayout.CENTER);
        add(holdBoxFragment, BorderLayout.WEST);
        add(nextTetrominoFragment, BorderLayout.EAST);
    }

    public void resume() {
        tetrisController.resume();
    }

    private void setPausePanelVisible(boolean pausePanelVisible) {
        if (pausePanelVisible) {
            frame.setPanel(pauseMenuPanel);
        } else {
            frame.setPanel(this);
        }
    }

    private final TetrisGameListener tetrisGameListener = event -> {
        switch (event) {
            case GAME_START:
                setPausePanelVisible(false);
                break;
            case PAUSE:
                setPausePanelVisible(true);
                break;
            case RESUME:
                setPausePanelVisible(false);
                break;
            case RENDER:
                tetrisGrid.revalidate();
                tetrisGrid.repaint();
                holdBoxFragment.setTetromino(tetrisGame.getHoldBox().getTetromino());
                nextTetrominoFragment.setNextTetrominoComponent(tetrisGame.getTetrominoQueue().getPreview(0));
                break;
        }
    };
}
