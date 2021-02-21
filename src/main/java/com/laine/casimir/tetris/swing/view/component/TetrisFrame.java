package com.laine.casimir.tetris.swing.view.component;

import javax.swing.JFrame;
import java.awt.Container;

public final class TetrisFrame extends JFrame {

    public TetrisFrame(String title) {
        super(title);
    }

    @Override
    public void setContentPane(Container contentPane) {
        super.setContentPane(contentPane);
        revalidate();
        repaint();
    }
}
