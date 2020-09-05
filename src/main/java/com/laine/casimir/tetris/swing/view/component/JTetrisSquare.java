package com.laine.casimir.tetris.swing.view.component;

import java.awt.*;

public class JTetrisSquare extends AbstactTetrisComponent {

    private static final int STROKE_WIDTH = 1;

    private final Stroke stroke = new BasicStroke(STROKE_WIDTH);
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
        g2d.setStroke(stroke);
        g2d.draw(rectangle);
    }
}
