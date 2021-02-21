package com.laine.casimir.tetris.swing.view.component;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public final class TitleLabel extends JLabel {

    public TitleLabel(String text) {
        super(text);
        init();
    }

    private void init() {
        setBorder(
                BorderFactory.createEmptyBorder(SwingTetrisConstants.PADDING_FRAGMENT_TITLE, SwingTetrisConstants.PADDING_FRAGMENT_TITLE,
                        SwingTetrisConstants.PADDING_FRAGMENT_TITLE, SwingTetrisConstants.PADDING_FRAGMENT_TITLE));
        setHorizontalAlignment(SwingConstants.CENTER);
        setAlignmentX(CENTER_ALIGNMENT);
        setForeground(SwingTetrisConstants.COLOR_FRAGMENT_TEXT);
    }
}
