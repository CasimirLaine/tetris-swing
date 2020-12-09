package com.laine.casimir.tetris.swing.view.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

public final class JMino extends AbstractTetrisComponent {

    private static final int STROKE_WIDTH = 1;
    private static final int STROKE_WIDTH_GHOST = 5;

    private final Color transparent = new Color(0, 0, 0, 0);
    private final Stroke stroke = new BasicStroke(STROKE_WIDTH);
    private final Stroke ghostStroke = new BasicStroke(STROKE_WIDTH_GHOST);
    private final Rectangle rectangle = new Rectangle(0, 0, getWidth(), getHeight());

    private boolean ghostMode;

    public JMino() {
        init();
    }

    private void init() {
        setFocusable(false);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics2D g2d) {
        rectangle.width = getWidth();
        rectangle.height = getHeight();
        g2d.setColor(ghostMode ? transparent : getBackground());
        g2d.fill(rectangle);
        g2d.setColor(ghostMode ? getBackground() : getForeground());
        if (ghostMode) {
            g2d.setStroke(ghostStroke);
        } else {
            g2d.setStroke(stroke);
        }
        g2d.draw(rectangle);
    }

    public void setGhostMode(boolean ghostMode) {
        this.ghostMode = ghostMode;
    }
}
