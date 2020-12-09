package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.base.api.model.BaseTetromino;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTetromino;
import com.laine.casimir.tetris.swing.view.component.JTitleLabel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

public final class JNextTetrominoFragment extends JFragment {

    private final JPanel tetrominoPanel = new JPanel();

    private int cellSize;

    public JNextTetrominoFragment() {
        init();
    }

    private void init() {
        tetrominoPanel.setLayout(new BoxLayout(tetrominoPanel, BoxLayout.Y_AXIS));
        add(new JTitleLabel(TetrisSwingStrings.TITLE_NEXT), BorderLayout.NORTH);
        add(tetrominoPanel, BorderLayout.CENTER);
    }

    public void addTetromino(BaseTetromino tetromino) {
        final JTetromino jTetromino = new JTetromino();
        jTetromino.setBackground(SwingTetrisConstants.BACKGROUND_COLOR);
        jTetromino.setTetromino(tetromino);
        jTetromino.setCellSize(cellSize);
        tetrominoPanel.add(jTetromino);
    }

    public void clear() {
        tetrominoPanel.removeAll();
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
        for (final Component component : tetrominoPanel.getComponents()) {
            if (component instanceof JTetromino) {
                ((JTetromino) component).setCellSize(cellSize);
            }
        }
    }
}
