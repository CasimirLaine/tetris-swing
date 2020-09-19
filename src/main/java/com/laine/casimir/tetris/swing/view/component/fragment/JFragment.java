package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;

import javax.swing.*;
import java.awt.*;

class JFragment extends JPanel {

    private final JLabel titleLabel = new JLabel();

    public JFragment() {
        init();
    }

    private void init() {
        setBackground(SwingTetrisConstants.COLOR_FRAGMENT_BACKGROUND);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(SwingTetrisConstants.PADDING_FRAGMENT, SwingTetrisConstants.PADDING_FRAGMENT,
                SwingTetrisConstants.PADDING_FRAGMENT, SwingTetrisConstants.PADDING_FRAGMENT));
        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(SwingTetrisConstants.PADDING_FRAGMENT_TITLE, SwingTetrisConstants.PADDING_FRAGMENT_TITLE,
                        SwingTetrisConstants.PADDING_FRAGMENT_TITLE, SwingTetrisConstants.PADDING_FRAGMENT_TITLE));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(SwingTetrisConstants.COLOR_FRAGMENT_TEXT);
        add(titleLabel, BorderLayout.NORTH);
    }

    public void setTitle(String title) {
        titleLabel.setText(title);
    }
}
