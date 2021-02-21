package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.base.api.model.BaseTetromino;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.TetrominoView;
import com.laine.casimir.tetris.swing.view.component.TitleLabel;

import java.awt.BorderLayout;

public final class HoldBoxFragment extends Fragment {

    private final TetrominoView heldTetromino = new TetrominoView();

    public HoldBoxFragment() {
        init();
    }

    private void init() {
        add(new TitleLabel(TetrisSwingStrings.TITLE_HOLD), BorderLayout.NORTH);
        heldTetromino.setBackground(SwingTetrisConstants.COLOR_FRAGMENT_CONTENT_BACKGROUND);
        add(heldTetromino, BorderLayout.CENTER);
    }

    public void setTetromino(BaseTetromino tetromino) {
        heldTetromino.setTetromino(tetromino);
    }

    public void setCellSize(int cellSize) {
        heldTetromino.setCellSize(cellSize);
    }
}
