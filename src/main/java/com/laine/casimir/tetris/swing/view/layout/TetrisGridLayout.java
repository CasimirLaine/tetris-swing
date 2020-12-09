package com.laine.casimir.tetris.swing.view.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.Map;

public final class TetrisGridLayout implements LayoutManager2 {

    private final int colCount;
    private final int rowCount;
    private final Map<Component, Point> components = new HashMap<>();

    private Integer lockedCellSize;

    private boolean initialResizeDispached;

    public TetrisGridLayout(int colCount, int rowCount) {
        this(colCount, rowCount, null);
    }

    public TetrisGridLayout(int colCount, int rowCount, Integer lockedCellSize) {
        this.colCount = colCount;
        this.rowCount = rowCount;
        this.lockedCellSize = lockedCellSize;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        addLayoutComponent(comp, name);
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        if (constraints instanceof Point) {
            final Point point = (Point) constraints;
            components.put(comp, point);
        } else {
            components.put(comp, new Point(0, 0));
        }
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0;
    }

    @Override
    public void invalidateLayout(Container target) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        components.remove(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container target) {
        final Container parent = target.getParent();
        if (parent != null) {
            final int parentCellSize = lockedCellSize != null ? lockedCellSize : getCellSize(parent);
            return new Dimension(parentCellSize * colCount, parentCellSize * rowCount);
        } else {
            return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container target) {
        return new Dimension(colCount, rowCount);
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        final Container parent = target.getParent();
        if (parent != null) {
            return new Dimension(parent.getWidth(), parent.getHeight());
        } else {
            return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
    }

    @Override
    public void layoutContainer(Container target) {
        final int cellSize = lockedCellSize != null ? lockedCellSize : getCellSize(target);
        final int surplusWidthStart = (int) ((target.getWidth() - colCount * cellSize) * 0.5F);
        final int surplusHeightStart = (int) ((target.getHeight() - rowCount * cellSize) * 0.5F);
        for (final Map.Entry<Component, Point> entry : components.entrySet()) {
            final Component component = entry.getKey();
            final Point point = entry.getValue();
            component.setSize(cellSize, cellSize);
            component.setLocation(surplusWidthStart + point.x * cellSize, surplusHeightStart + point.y * cellSize);
        }
        if (!initialResizeDispached && cellSize > 0) {
            initialResizeDispached = true;
            target.dispatchEvent(new ComponentEvent(target, ComponentEvent.COMPONENT_RESIZED));
        }
    }

    private int getCellSize(Container target) {
        final int cellWidth = target.getWidth() / colCount;
        final int cellHeight = target.getHeight() / rowCount;
        return Math.min(cellWidth, cellHeight);
    }

    public void setLockedCellSize(Integer lockedCellSize) {
        this.lockedCellSize = lockedCellSize;
    }
}
