package com.laine.casimir.tetris.swing.view.component;

import com.laine.casimir.tetris.base.model.Playfield;

import java.awt.*;

public class JTetrisGrid extends AbstactTetrisComponent {

    private static final int LINE_WIDTH = 1;

    private final Stroke stroke = new BasicStroke(LINE_WIDTH);

    public JTetrisGrid() {
        init();
    }

    private void init() {
    }

    @Override
    protected void paintComponent(Graphics2D g2d) {
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(getForeground());
        g2d.setStroke(stroke);
        for (int xIndex = 0, x = 0; xIndex < Playfield.WIDTH; xIndex++, x += getGridWidth()) {
            for (int yIndex = 0, y = 0; yIndex < Playfield.VISIBLE_HEIGHT; yIndex++, y += getGridHeight()) {
                g2d.drawRect(x, y, getGridWidth(), getGridHeight());
            }
        }
    }

    private int getGridWidth() {
        return getWidth() / Playfield.WIDTH;
    }

    private int getGridHeight() {
        return getHeight() / Playfield.VISIBLE_HEIGHT;
    }
}
