package com.laine.casimir.tetris.swing.view.layout;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public final class TetrisGridLayout implements LayoutManager2 {

    private final int colCount;
    private final int rowCount;
    private final Map<Component, Point> components = new HashMap<>();

    public TetrisGridLayout(int colCount, int rowCount) {
        this.colCount = colCount;
        this.rowCount = rowCount;
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
            final int parentGridSize = getGridSize(parent);
            return new Dimension(parentGridSize * colCount, parentGridSize * rowCount);
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
        final int gridSize = getGridSize(target);
        final int surplusWidthStart = (int) ((target.getWidth() - colCount * gridSize) * 0.5F);
        final int surplusHeightStart = (int) ((target.getHeight() - rowCount * gridSize) * 0.5F);
        for (final Map.Entry<Component, Point> entry : components.entrySet()) {
            final Component component = entry.getKey();
            final Point point = entry.getValue();
            component.setSize(gridSize, gridSize);
            component.setLocation(surplusWidthStart + point.x * gridSize, surplusHeightStart + point.y * gridSize);
        }
    }

    private int getGridSize(Container target) {
        final int gridWidth = target.getWidth() / colCount;
        final int gridHeight = target.getHeight() / rowCount;
        return Math.min(gridWidth, gridHeight);
    }
}
