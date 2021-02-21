package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.base.api.model.BaseTetromino;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.TetrominoView;
import com.laine.casimir.tetris.swing.view.component.TitleLabel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

public final class NextTetrominoFragment extends Fragment {

    private final JPanel tetrominoPanel = new JPanel();

    private int cellSize;

    public NextTetrominoFragment() {
        init();
    }

    private void init() {
        tetrominoPanel.setBackground(SwingTetrisConstants.COLOR_FRAGMENT_CONTENT_BACKGROUND);
        tetrominoPanel.setLayout(new BoxLayout(tetrominoPanel, BoxLayout.Y_AXIS));
        add(new TitleLabel(TetrisSwingStrings.TITLE_NEXT), BorderLayout.NORTH);
        add(tetrominoPanel, BorderLayout.CENTER);
    }

    public void addTetromino(BaseTetromino tetromino) {
        final TetrominoView tetrominoView = new TetrominoView();
        tetrominoView.setBackground(SwingTetrisConstants.COLOR_FRAGMENT_CONTENT_BACKGROUND);
        tetrominoView.setTetromino(tetromino);
        tetrominoView.setCellSize(cellSize);
        tetrominoPanel.add(tetrominoView);
    }

    public void clear() {
        tetrominoPanel.removeAll();
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
        for (final Component component : tetrominoPanel.getComponents()) {
            if (component instanceof TetrominoView) {
                ((TetrominoView) component).setCellSize(cellSize);
            }
        }
    }
}
