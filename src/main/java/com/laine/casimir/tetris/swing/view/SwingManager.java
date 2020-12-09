package com.laine.casimir.tetris.swing.view;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.view.component.JTetrisFrame;
import com.laine.casimir.tetris.swing.view.component.panel.JMainMenuPanel;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Toolkit;

public final class SwingManager {

    private final JFrame frame = new JTetrisFrame(SwingTetrisConstants.APP_NAME);

    public SwingManager() {
        init();
    }

    private void init() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int screenWidth = screenSize.width;
        final int screenHeight = screenSize.height;
        frame.setPreferredSize(new Dimension(Math.min(SwingTetrisConstants.WINDOW_DEFAULT_WIDTH, screenWidth),
                Math.min(SwingTetrisConstants.WINDOW_DEFAULT_HEIGHT, screenHeight)));
        frame.setMinimumSize(new Dimension(Math.min(SwingTetrisConstants.WINDOW_MIN_WIDTH, screenWidth),
                Math.min(SwingTetrisConstants.WINDOW_MIN_HEIGHT, screenHeight)));
        frame.setContentPane(new JMainMenuPanel(frame));
        frame.pack();
        frame.setVisible(true);
    }
}
