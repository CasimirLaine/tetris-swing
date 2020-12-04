package com.laine.casimir.tetris.swing.view.layout;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TetrisGridLayout implements LayoutManager2 {

    private final int cols;
    private final int rows;
    private final Map<Component, Point> components = new HashMap<>();

    public TetrisGridLayout(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
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
    public Dimension preferredLayoutSize(Container parent) {
        return new Dimension();
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return new Dimension();
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return new Dimension();
    }

    @Override
    public void layoutContainer(Container parent) {
        final int gridWidth = parent.getWidth() / cols;
        final int gridHeight = parent.getHeight() / rows;
        for (final Map.Entry<Component, Point> entry : components.entrySet()) {
            final Component component = entry.getKey();
            final Point point = entry.getValue();
            component.setSize(gridWidth, gridHeight);
            component.setLocation(point.x * gridWidth, point.y * gridHeight);
        }
    }
}
