package com.laine.casimir.tetris.swing.view;

import com.laine.casimir.tetris.base.model.Playfield;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.view.layout.TetrisGridLayout;

import javax.swing.*;
import java.awt.*;

public class SwingManager {

    private final JFrame jFrame = new JFrame(SwingTetrisConstants.APP_NAME);
    private final TetrisGridLayout layout = new TetrisGridLayout(Playfield.WIDTH, Playfield.VISIBLE_HEIGHT);

    public SwingManager() {
        init();
    }

    private void init() {
        jFrame.setPreferredSize(new Dimension(SwingTetrisConstants.DEFAULT_WIDTH, SwingTetrisConstants.DEFAULT_HEIGHT));
        jFrame.setMinimumSize(new Dimension(SwingTetrisConstants.MIN_WIDTH, SwingTetrisConstants.MIN_HEIGHT));
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
