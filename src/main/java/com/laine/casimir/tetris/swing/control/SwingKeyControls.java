package com.laine.casimir.tetris.swing.control;

import com.laine.casimir.tetris.base.api.TetrisController;
import com.laine.casimir.tetris.swing.view.component.panel.JTetrisGamePanel;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public final class SwingKeyControls implements KeyEventDispatcher {

    private static final long EVENT_INTERVAL = 25;

    private final Map<Integer, Long> keysHeld = new HashMap<>();

    private final JTetrisGamePanel tetrisGamePanel;

    private TetrisController tetrisController;

    public SwingKeyControls(JTetrisGamePanel tetrisGamePanel) {
        this.tetrisGamePanel = tetrisGamePanel;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (tetrisController == null) {
            return false;
        }
        if (e.getID() != KeyEvent.KEY_PRESSED) {
            if (e.getID() == KeyEvent.KEY_RELEASED) {
                keysHeld.remove(e.getKeyCode());
            }
            return false;
        }
        final Long lastEventTime = keysHeld.get(e.getKeyCode());
        final long now = System.currentTimeMillis();
        final long timeSinceLastEvent = lastEventTime == null ? 0 : (now - lastEventTime);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_F1:
                if (lastEventTime != null) {
                    return false;
                }
                tetrisGamePanel.pause();
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_NUMPAD4:
                if (lastEventTime != null && timeSinceLastEvent < EVENT_INTERVAL) {
                    return false;
                }
                tetrisController.shiftLeft();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_NUMPAD6:
                if (lastEventTime != null && timeSinceLastEvent < EVENT_INTERVAL) {
                    return false;
                }
                tetrisController.shiftRight();
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_X:
            case KeyEvent.VK_NUMPAD1:
            case KeyEvent.VK_NUMPAD5:
            case KeyEvent.VK_NUMPAD9:
                if (lastEventTime != null) {
                    return false;
                }
                tetrisController.rotateClockwise();
                break;
            case KeyEvent.VK_CONTROL:
            case KeyEvent.VK_Z:
            case KeyEvent.VK_NUMPAD3:
            case KeyEvent.VK_NUMPAD7:
                if (lastEventTime != null) {
                    return false;
                }
                tetrisController.rotateCounterclockwise();
                break;
            case KeyEvent.VK_SPACE:
            case KeyEvent.VK_NUMPAD8:
                if (lastEventTime != null) {
                    return false;
                }
                tetrisController.hardDrop();
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_NUMPAD2:
                if (lastEventTime != null && timeSinceLastEvent < EVENT_INTERVAL) {
                    return false;
                }
                tetrisController.softDrop();
                break;
            case KeyEvent.VK_SHIFT:
            case KeyEvent.VK_C:
            case KeyEvent.VK_NUMPAD0:
                if (lastEventTime != null) {
                    return false;
                }
                tetrisController.hold();
                break;
            default:
                return false;
        }
        keysHeld.put(e.getKeyCode(), now);
        return true;
    }

    public void setTetrisController(TetrisController tetrisController) {
        this.tetrisController = tetrisController;
        keysHeld.clear();
    }
}
