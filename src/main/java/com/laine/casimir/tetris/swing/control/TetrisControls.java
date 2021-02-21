package com.laine.casimir.tetris.swing.control;

import java.awt.event.KeyEvent;

public final class TetrisControls {

    public static final Control PAUSE = new Control(new int[]{
            KeyEvent.VK_ESCAPE, KeyEvent.VK_F1
    }, "Pause");
    public static final Control SHIFT_LEFT = new Control(new int[]{
            KeyEvent.VK_LEFT, KeyEvent.VK_NUMPAD4
    }, "Shift left");
    public static final Control SHIFT_RIGHT = new Control(new int[]{
            KeyEvent.VK_RIGHT, KeyEvent.VK_NUMPAD6
    }, "Shift right");
    public static final Control ROTATE_CLOCKWISE = new Control(new int[]{
            KeyEvent.VK_UP, KeyEvent.VK_X, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD5, KeyEvent.VK_NUMPAD9
    }, "Rotate clockwise");
    public static final Control ROTATE_COUNTERCLOCKWISE = new Control(new int[]{
            KeyEvent.VK_CONTROL, KeyEvent.VK_Z, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD7
    }, "Rotate counterclockwise");
    public static final Control HARD_DROP = new Control(new int[]{
            KeyEvent.VK_SPACE, KeyEvent.VK_NUMPAD8
    }, "Hard drop");
    public static final Control SOFT_DROP = new Control(new int[]{
            KeyEvent.VK_DOWN, KeyEvent.VK_NUMPAD2
    }, "Soft drop");
    public static final Control HOLD = new Control(new int[]{
            KeyEvent.VK_SHIFT, KeyEvent.VK_C, KeyEvent.VK_NUMPAD0
    }, "Hold");

    public static final class Control {

        public final int[] keyCodes;
        public final String description;

        public Control(int[] keyCodes, String description) {
            this.keyCodes = keyCodes;
            this.description = description;
        }
    }

    private TetrisControls() {}
}
