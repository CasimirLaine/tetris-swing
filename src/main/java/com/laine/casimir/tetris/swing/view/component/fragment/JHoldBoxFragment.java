package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.base.model.tetromino.AbstractTetromino;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTetromino;
import com.laine.casimir.tetris.swing.view.component.JTitleLabel;

import java.awt.*;

public class JHoldBoxFragment extends JFragment {

    private final JTetromino heldTetromino = new JTetromino();

    public JHoldBoxFragment() {
        init();
    }

    private void init() {
        add(new JTitleLabel(TetrisSwingStrings.TITLE_HOLD), BorderLayout.NORTH);
        add(heldTetromino, BorderLayout.CENTER);
    }

    public void setTetromino(AbstractTetromino tetromino) {
        heldTetromino.setTetromino(tetromino);
    }
}
