package com.laine.casimir.tetris.swing.view.component;

import javax.swing.*;

public class JTetrisFrame extends JFrame {

    public JTetrisFrame(String title) {
        super(title);
    }

    public void setPanel(JComponent jComponent) {
        setContentPane(jComponent);
        revalidate();
        repaint();
    }
}
