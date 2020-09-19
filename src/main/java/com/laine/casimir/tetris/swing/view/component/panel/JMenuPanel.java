package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;

import javax.swing.*;
import java.awt.*;

class JMenuPanel extends JPanel {

    private final JLabel titleLabel = new JLabel();

    public JMenuPanel() {
        init();
    }

    private void init() {
        setBackground(SwingTetrisConstants.COLOR_PANEL_BACKGROUND);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(SwingTetrisConstants.PADDING_PANEL, SwingTetrisConstants.PADDING_PANEL,
                SwingTetrisConstants.PADDING_PANEL, SwingTetrisConstants.PADDING_PANEL));
        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(SwingTetrisConstants.PADDING_PANEL_TITLE, SwingTetrisConstants.PADDING_PANEL_TITLE,
                        SwingTetrisConstants.PADDING_PANEL_TITLE, SwingTetrisConstants.PADDING_PANEL_TITLE));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(SwingTetrisConstants.COLOR_PANEL_TEXT);
        add(titleLabel, BorderLayout.NORTH);
    }

    public void setTitle(String title) {
        titleLabel.setText(title);
    }
}