package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.base.api.model.BaseTetromino;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTetromino;
import com.laine.casimir.tetris.swing.view.component.JTitleLabel;

import java.awt.BorderLayout;

public final class JHoldBoxFragment extends JFragment {

    private final JTetromino heldTetromino = new JTetromino();

    public JHoldBoxFragment() {
        init();
    }

    private void init() {
        add(new JTitleLabel(TetrisSwingStrings.TITLE_HOLD), BorderLayout.NORTH);
        heldTetromino.setBackground(SwingTetrisConstants.COLOR_BACKGROUND);
        add(heldTetromino, BorderLayout.CENTER);
    }

    public void setTetromino(BaseTetromino tetromino) {
        heldTetromino.setTetromino(tetromino);
    }

    public void setCellSize(int cellSize) {
        heldTetromino.setCellSize(cellSize);
    }
}
