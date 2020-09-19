package com.laine.casimir.tetris.swing.view.component;

import com.laine.casimir.tetris.swing.view.GraphicUtils;

import javax.swing.*;
import java.awt.*;

abstract class AbstactTetrisComponent extends JComponent {

    public AbstactTetrisComponent() {
        super();
        init();
    }

    private void init() {
        setDoubleBuffered(true);
        setOpaque(false);
    }

    public Point getCenterPoint() {
        return new Point(getWidth() / 2, getHeight() / 2);
    }

    public int getShorterDimension() {
        return getWidth() < getHeight() ? getWidth() : getHeight();
    }

    public int getLongerDimension() {
        return getWidth() > getHeight() ? getWidth() : getHeight();
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
