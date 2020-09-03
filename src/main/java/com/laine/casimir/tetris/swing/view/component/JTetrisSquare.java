package com.laine.casimir.tetris.swing.view.component;

import java.awt.*;

public class JTetrisSquare extends AbstactTetrisComponent {

    private static final float STROKE_WIDTH_MULTIPLIER = 0.02F;

    private final Rectangle rectangle = new Rectangle(0, 0, getWidth(), getHeight());

    public JTetrisSquare() {
        super();
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
        g2d.setColor(getBackground());
        g2d.fill(rectangle);
        g2d.setColor(Color.BLACK);
        final float strokeWidth;
        if (getWidth() < getHeight()) {
            strokeWidth = getWidth() * STROKE_WIDTH_MULTIPLIER;
        } else {
            strokeWidth = getHeight() * STROKE_WIDTH_MULTIPLIER;
        }
        g2d.setStroke(new BasicStroke(strokeWidth));
        g2d.draw(rectangle);
    }
}
