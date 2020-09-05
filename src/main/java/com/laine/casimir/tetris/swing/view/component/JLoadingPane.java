package com.laine.casimir.tetris.swing.view.component;

import com.laine.casimir.tetris.swing.view.GraphicUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JLoadingPane extends AbstactTetrisComponent {

    private static final int ANIMATION_TIMER_DELAY = 10;
    private static final int CIRCLE_COUNT = 20;

    private static final Color COLOR = new Color(100, 100, 100, 200);

    private double firstCirclePosition;

    private double radius;
    private boolean increasingRadius = true;

    private final List<Color> colors = new ArrayList<>();
    private final Timer loadingAnimator = new Timer(0, e -> {
        firstCirclePosition += firstCirclePosition < 360 ? 10 : 0;
        if (increasingRadius) {
            radius++;
            if (radius >= getShorterDimension() * 0.2) {
                increasingRadius = false;
            }
        } else {
            radius--;
            if (radius <= 0) {
                increasingRadius = true;
            }
        }
        repaint();
    });

    public JLoadingPane() {
        super();
        init();
    }

    private void init() {
        loadingAnimator.setRepeats(true);
        loadingAnimator.setDelay(ANIMATION_TIMER_DELAY);
        generateColors();
    }

    @Override
    protected void paintComponent(Graphics2D g2d) {
        final int shorterDimension = getShorterDimension();
        final int circleSize = (int) (shorterDimension * 0.05);
        final double spaceBetween = 360.0 / CIRCLE_COUNT;
        final Point centerPoint = getCenterPoint();
        g2d.setColor(COLOR);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        double position = firstCirclePosition;
        for (int index = 0; index < CIRCLE_COUNT; index++, position += spaceBetween) {
            final int width = (int) (centerPoint.x + radius * Math.cos(Math.toRadians(position))) - (circleSize / 2);
            final int height = (int) (centerPoint.y + radius * Math.sin(Math.toRadians(position))) - (circleSize / 2);
            g2d.setColor(colors.get(index));
            g2d.fillOval(width, height, circleSize, circleSize);
        }
    }

    public void generateColors() {
        colors.clear();
        for (int index = 0; index < CIRCLE_COUNT; index++) {
            colors.add(GraphicUtils.generateRandomColorRGB());
        }
    }

    public void setAnimationEnabled(boolean animationEnabled) {
        if (animationEnabled) {
            loadingAnimator.start();
        } else {
            loadingAnimator.stop();
        }
    }
}
