package com.laine.casimir.tetris.swing.view.component;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;

public final class TetrisGrid extends AbstractTetrisComponent {

    private static final int LINE_WIDTH = 1;

    private final Stroke stroke = new BasicStroke(LINE_WIDTH);

    private final int colCount;
    private final int rowCount;

    public TetrisGrid(int colCount, int rowCount) {
        this.colCount = colCount;
        this.rowCount = rowCount;
    }

    @Override
    protected void paintComponent(Graphics2D g2d) {
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(getForeground());
        g2d.setStroke(stroke);
        final int cellSize = getCellSize();
        final int surplusWidthStart = (int) ((getWidth() - colCount * cellSize) * 0.5F);
        final int surplusHeightStart = (int) ((getHeight() - rowCount * cellSize) * 0.5F);
        for (int xIndex = 0, x = 0; xIndex < colCount; xIndex++, x += cellSize) {
            for (int yIndex = 0, y = 0; yIndex < rowCount; yIndex++, y += cellSize) {
                g2d.drawRect(surplusWidthStart + x, surplusHeightStart + y,
                        cellSize, cellSize);
            }
        }
    }

    public int getColCount() {
        return colCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getCellSize() {
        final int cellWidth = getWidth() / colCount;
        final int cellHeight = getHeight() / rowCount;
        return Math.min(cellWidth, cellHeight);
    }
}
