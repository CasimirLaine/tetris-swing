package com.laine.casimir.tetris.swing.view;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.view.component.JTetrisFrame;
import com.laine.casimir.tetris.swing.view.component.panel.JMainMenuPanel;

import javax.swing.*;
import java.awt.*;

public class SwingManager {

    private final JFrame frame = new JTetrisFrame(SwingTetrisConstants.APP_NAME);

    public SwingManager() {
        init();
    }

    private void init() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(SwingTetrisConstants.WINDOW_DEFAULT_WIDTH, SwingTetrisConstants.WINDOW_DEFAULT_HEIGHT));
        frame.setMinimumSize(new Dimension(SwingTetrisConstants.WINDOW_MIN_WIDTH, SwingTetrisConstants.WINDOW_MIN_HEIGHT));
        frame.setContentPane(new JMainMenuPanel(frame));
        frame.pack();
        frame.setVisible(true);
    }
}
