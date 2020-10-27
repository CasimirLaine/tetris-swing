package com.laine.casimir.tetris.swing;

import com.laine.casimir.tetris.base.model.Playfield;

import java.awt.*;

public final class SwingTetrisConstants {

    public static final String APP_NAME = "Tetris Swing";
    public static final int WINDOW_DEFAULT_WIDTH = Playfield.WIDTH * 50;
    public static final int WINDOW_DEFAULT_HEIGHT = Playfield.VISIBLE_HEIGHT * 50;
    public static final int WINDOW_MIN_WIDTH = Playfield.WIDTH * 30;
    public static final int WINDOW_MIN_HEIGHT = Playfield.VISIBLE_HEIGHT * 30;
    public static final int PADDING_PANEL = 64;
    public static final int PADDING_PANEL_TITLE = 8;
    public static final int PADDING_FRAGMENT = 16;
    public static final int PADDING_FRAGMENT_TITLE = 8;
    public static final Color COLOR_PANEL_BACKGROUND = Color.BLACK;
    public static final Color COLOR_PANEL_TEXT = Color.WHITE;
    public static final Color COLOR_FRAGMENT_BACKGROUND = COLOR_PANEL_BACKGROUND;
    public static final Color COLOR_FRAGMENT_TEXT = COLOR_PANEL_TEXT;

    private SwingTetrisConstants() {}
}
