package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;

import javax.swing.*;
import java.awt.*;

class JFragment extends JPanel {

    public JFragment() {
        init();
    }

    private void init() {
        setBackground(SwingTetrisConstants.COLOR_FRAGMENT_BACKGROUND);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(SwingTetrisConstants.PADDING_FRAGMENT, SwingTetrisConstants.PADDING_FRAGMENT,
                SwingTetrisConstants.PADDING_FRAGMENT, SwingTetrisConstants.PADDING_FRAGMENT));
    }
}
