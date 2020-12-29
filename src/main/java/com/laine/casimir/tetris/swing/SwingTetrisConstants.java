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

    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_HEIGHT = (int) (BUTTON_WIDTH * 0.4);

    public static final Color COLOR_PANEL_BACKGROUND = Color.BLACK;
    public static final Color COLOR_PANEL_TEXT = Color.WHITE;
    public static final Color COLOR_GRID_BACKGROUND = Color.BLACK;
    public static final Color COLOR_GRID_FOREGROUND = Color.WHITE;
    public static final Color COLOR_TETROMINO_BORDER = Color.BLACK;
    public static final Color COLOR_FRAGMENT_BACKGROUND = Color.RED;
    public static final Color COLOR_FRAGMENT_CONTENT_BACKGROUND = Color.BLACK;
    public static final Color COLOR_FRAGMENT_TEXT = Color.WHITE;
    public static final Color COLOR_COUNTDOWN = Color.WHITE;

    public static final int CLEAR_BLINK_INTERVAL = 100;
    public static final int CLEAR_BLINK_TOTAL = 500;
    public static final Color CLEAR_BLINK_COLOR = Color.WHITE;

    private SwingTetrisConstants() {}
}
