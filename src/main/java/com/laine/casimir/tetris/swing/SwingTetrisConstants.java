package com.laine.casimir.tetris.swing;

import com.laine.casimir.tetris.base.api.TetrisConstants;

import java.awt.Color;

public final class SwingTetrisConstants {

    public static final String APP_NAME = "Tetris Swing";
    public static final int WINDOW_DEFAULT_WIDTH = (TetrisConstants.WIDTH + 10) * 50;
    public static final int WINDOW_DEFAULT_HEIGHT = TetrisConstants.VISIBLE_HEIGHT * 50;
    public static final int WINDOW_MIN_WIDTH = (TetrisConstants.WIDTH + 10) * 40;
    public static final int WINDOW_MIN_HEIGHT = TetrisConstants.VISIBLE_HEIGHT * 40;
    public static final int PADDING_PANEL = 64;
    public static final int PADDING_PANEL_TITLE = 8;
    public static final int PADDING_FRAGMENT = 16;
    public static final int PADDING_FRAGMENT_TITLE = 8;
    public static final Color COLOR_PANEL_BACKGROUND = Color.BLACK;
    public static final Color COLOR_PANEL_TEXT = Color.WHITE;
    public static final Color COLOR_FRAGMENT_BACKGROUND = COLOR_PANEL_BACKGROUND;
    public static final Color COLOR_FRAGMENT_TEXT = COLOR_PANEL_TEXT;
    public static final Color BACKGROUND_COLOR = Color.BLACK;
    public static final Color GRID_COLOR = Color.WHITE;
    public static final int CLEAR_BLINK_INTERVAL = 100;
    public static final int CLEAR_BLINK_TOTAL = 500;
    public static final Color CLEAR_BLINK_COLOR = Color.WHITE;

    private SwingTetrisConstants() {}
}
