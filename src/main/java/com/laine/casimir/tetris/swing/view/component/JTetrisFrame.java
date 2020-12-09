package com.laine.casimir.tetris.swing.view.component;

import javax.swing.JFrame;
import java.awt.Container;

public final class JTetrisFrame extends JFrame {

    public JTetrisFrame(String title) {
        super(title);
    }

    @Override
    public void setContentPane(Container contentPane) {
        super.setContentPane(contentPane);
        revalidate();
        repaint();
    }
}
