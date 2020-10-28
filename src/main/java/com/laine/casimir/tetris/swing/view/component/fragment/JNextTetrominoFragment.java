package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.base.model.tetromino.AbstractTetromino;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTetromino;

import javax.swing.*;
import java.awt.*;

public class JNextTetrominoFragment extends JFragment {

    private final JPanel tetrominoPanel = new JPanel();

    public JNextTetrominoFragment() {
        init();
    }

    private void init() {
        setTitle(TetrisSwingStrings.TITLE_NEXT);
        tetrominoPanel.setLayout(new BoxLayout(tetrominoPanel, BoxLayout.Y_AXIS));
        add(tetrominoPanel, BorderLayout.CENTER);
    }

    public void addTetromino(AbstractTetromino tetromino) {
        final JTetromino jTetromino = new JTetromino();
        jTetromino.setTetromino(tetromino);
        tetrominoPanel.add(jTetromino);
    }

    public void clear() {
        tetrominoPanel.removeAll();
    }
}
