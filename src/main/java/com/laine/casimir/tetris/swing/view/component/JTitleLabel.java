package com.laine.casimir.tetris.swing.view.component;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;

import javax.swing.*;

public final class JTitleLabel extends JLabel {

    public JTitleLabel(String text) {
        super(text);
        init();
    }

    private void init() {
        setBorder(
                BorderFactory.createEmptyBorder(SwingTetrisConstants.PADDING_FRAGMENT_TITLE, SwingTetrisConstants.PADDING_FRAGMENT_TITLE,
                        SwingTetrisConstants.PADDING_FRAGMENT_TITLE, SwingTetrisConstants.PADDING_FRAGMENT_TITLE));
        setHorizontalAlignment(SwingConstants.CENTER);
        setForeground(SwingTetrisConstants.COLOR_FRAGMENT_TEXT);
    }
}
