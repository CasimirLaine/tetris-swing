package com.laine.casimir.tetris.swing.view.component;

import java.awt.*;

public final class JTetrisGrid extends AbstractTetrisComponent {

    private static final int LINE_WIDTH = 1;

    private final Stroke stroke = new BasicStroke(LINE_WIDTH);

    private final int colCount;
    private final int rowCount;

    public JTetrisGrid(int colCount, int rowCount) {
        this.colCount = colCount;
        this.rowCount = rowCount;
    }

    @Override
    protected void paintComponent(Graphics2D g2d) {
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(getForeground());
        g2d.setStroke(stroke);
        final int gridSize = getGridSize();
        final int surplusWidthStart = (int) ((getWidth() - colCount * gridSize) * 0.5F);
        final int surplusHeightStart = (int) ((getHeight() - rowCount * gridSize) * 0.5F);
        for (int xIndex = 0, x = 0; xIndex < colCount; xIndex++, x += gridSize) {
            for (int yIndex = 0, y = 0; yIndex < rowCount; yIndex++, y += gridSize) {
                g2d.drawRect(surplusWidthStart + x, surplusHeightStart + y,
                        gridSize, gridSize);
            }
        }
    }

    public int getColCount() {
        return colCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    private int getGridSize() {
        final int gridWidth = getWidth() / colCount;
        final int gridHeight = getHeight() / rowCount;
        return Math.min(gridWidth, gridHeight);
    }
}
