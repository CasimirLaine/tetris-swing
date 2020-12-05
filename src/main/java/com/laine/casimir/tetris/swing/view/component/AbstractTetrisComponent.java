package com.laine.casimir.tetris.swing.view.component;

import com.laine.casimir.tetris.swing.view.GraphicUtils;

import javax.swing.*;
import java.awt.*;

abstract class AbstractTetrisComponent extends JComponent {

    protected AbstractTetrisComponent() {
        super();
        init();
    }

    private void init() {
        setDoubleBuffered(true);
        setOpaque(false);
    }

    @Override
    protected final void paintComponent(Graphics g) {
        final Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(GraphicUtils.getGraphicsConfig());
        super.paintComponent(g2d);
        paintComponent(g2d);
    }

    protected void paintComponent(Graphics2D g2d) {}
}
