package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

class MenuPanel extends JPanel {

    private final JLabel titleLabel = new JLabel();

    public MenuPanel() {
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
