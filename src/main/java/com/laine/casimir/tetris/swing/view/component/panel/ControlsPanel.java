package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.control.TetrisControls;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

public class ControlsPanel extends JPanel {

    private final TetrisControls.Control[] controls = {
            TetrisControls.PAUSE,
            TetrisControls.SHIFT_LEFT,
            TetrisControls.SHIFT_RIGHT,
            TetrisControls.ROTATE_CLOCKWISE,
            TetrisControls.ROTATE_COUNTERCLOCKWISE,
            TetrisControls.HARD_DROP,
            TetrisControls.SOFT_DROP,
            TetrisControls.HOLD,
    };

    private final JFrame frame;
    private final JPanel controlsListPanel = new JPanel();
    private final JButton backButton = new JButton(TetrisSwingStrings.BACK);

    public ControlsPanel(JFrame frame, JPanel parent) {
        this.frame = frame;
        setLayout(new BorderLayout());
        setBackground(SwingTetrisConstants.COLOR_PANEL_BACKGROUND);
        controlsListPanel.setBackground(SwingTetrisConstants.COLOR_PANEL_BACKGROUND);
        controlsListPanel.setLayout(new BoxLayout(controlsListPanel, BoxLayout.Y_AXIS));
        add(controlsListPanel, BorderLayout.CENTER);
        updateControls();
        backButton.addActionListener(e -> frame.setContentPane(parent));
        backButton.setAlignmentX(CENTER_ALIGNMENT);
        backButton.setMaximumSize(new Dimension(SwingTetrisConstants.BUTTON_WIDTH, SwingTetrisConstants.BUTTON_HEIGHT));
        controlsListPanel.add(backButton);
    }

    private void updateControls() {
        controlsListPanel.removeAll();
        for (final TetrisControls.Control control : controls) {
            final StringBuilder stringBuilder = new StringBuilder();
            for (int index = 0; index < control.keyCodes.length; index++) {
                stringBuilder.append(KeyEvent.getKeyText(control.keyCodes[index]));
                if (index != control.keyCodes.length - 1) {
                    stringBuilder.append(", ");
                }
            }
            final String text = String.format("%s: %s", control.description, stringBuilder.toString());
            final JLabel label = new JLabel(text);
            label.setBorder(
                    BorderFactory.createEmptyBorder(SwingTetrisConstants.PADDING_PANEL_TITLE, SwingTetrisConstants.PADDING_PANEL_TITLE,
                            SwingTetrisConstants.PADDING_PANEL_TITLE, SwingTetrisConstants.PADDING_PANEL_TITLE));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setForeground(SwingTetrisConstants.COLOR_PANEL_TEXT);
            label.setAlignmentX(CENTER_ALIGNMENT);
            controlsListPanel.add(label);
        }
    }
}
