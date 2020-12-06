package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.base.model.Tetromino;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTetromino;
import com.laine.casimir.tetris.swing.view.component.JTitleLabel;

import javax.swing.*;
import java.awt.*;

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

    public void addTetromino(Tetromino tetromino) {
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
        final Component[] components = tetrominoPanel.getComponents();
        for (final Component component : components) {
            if (component instanceof JTetromino) {
                ((JTetromino) component).setCellSize(cellSize);
            }
        }
    }
}
