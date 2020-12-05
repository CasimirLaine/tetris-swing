package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.base.model.Tetromino;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTetromino;
import com.laine.casimir.tetris.swing.view.component.JTitleLabel;

import java.awt.*;

public final class JHoldBoxFragment extends JFragment {

    private final JTetromino heldTetromino = new JTetromino();

    public JHoldBoxFragment() {
        init();
    }

    private void init() {
        add(new JTitleLabel(TetrisSwingStrings.TITLE_HOLD), BorderLayout.NORTH);
        add(heldTetromino, BorderLayout.CENTER);
    }

    public void setTetromino(Tetromino tetromino) {
        heldTetromino.setTetromino(tetromino);
    }
}
