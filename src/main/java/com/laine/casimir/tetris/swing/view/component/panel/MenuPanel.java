package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;

class MenuPanel extends JPanel {

    private final JLabel titleLabel = new JLabel();
    private final JPanel buttonsPanel = new JPanel();


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
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        titleLabel.setForeground(SwingTetrisConstants.COLOR_PANEL_TEXT);
        add(titleLabel, BorderLayout.NORTH);
        buttonsPanel.setBackground(SwingTetrisConstants.COLOR_PANEL_BACKGROUND);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        add(buttonsPanel, BorderLayout.CENTER);
    }

    public void addButtons(final JButton... components) {
        for (final JButton component : components) {
            component.setHorizontalAlignment(SwingConstants.CENTER);
            component.setAlignmentX(CENTER_ALIGNMENT);
            component.setMaximumSize(new Dimension(
                    SwingTetrisConstants.BUTTON_WIDTH,
                    SwingTetrisConstants.BUTTON_HEIGHT
            ));
            buttonsPanel.add(component);
        }
    }

    public void setTitle(String title) {
        titleLabel.setText(title);
    }
}
