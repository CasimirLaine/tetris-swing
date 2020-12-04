package com.laine.casimir.tetris.swing.view.component;

import java.awt.*;

public class JTetrisGrid extends AbstactTetrisComponent {

    private static final int LINE_WIDTH = 1;

    private final Stroke stroke = new BasicStroke(LINE_WIDTH);

    private final int colCount;
    private final int rowCount;

    public JTetrisGrid(int colCount, int rowCount) {
        this.colCount = colCount;
        this.rowCount = rowCount;
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
        for (int xIndex = 0, x = 0; xIndex < colCount; xIndex++, x += getGridWidth()) {
            for (int yIndex = 0, y = 0; yIndex < rowCount; yIndex++, y += getGridHeight()) {
                g2d.drawRect(x, y, getGridWidth(), getGridHeight());
            }
        }
    }

    private int getGridWidth() {
        return getWidth() / colCount;
    }

    private int getGridHeight() {
        return getHeight() / rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public int getRowCount() {
        return rowCount;
    }
}
