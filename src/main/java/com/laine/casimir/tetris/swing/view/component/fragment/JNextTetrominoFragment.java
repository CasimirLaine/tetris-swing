package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.base.model.tetromino.AbstractTetromino;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTetromino;

import java.awt.*;

public class JNextTetrominoFragment extends JFragment {

    private final JTetromino nextTetrominoComponent = new JTetromino();

    public JNextTetrominoFragment() {
        init();
    }

    private void init() {
        setTitle(TetrisSwingStrings.TITLE_NEXT);
        add(nextTetrominoComponent, BorderLayout.CENTER);
    }

    public void setNextTetrominoComponent(AbstractTetromino tetromino) {
        nextTetrominoComponent.setTetromino(tetromino);
    }
}
