package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;

class Fragment extends JPanel {

    public Fragment() {
        init();
    }

    private void init() {
        setBackground(SwingTetrisConstants.COLOR_FRAGMENT_BACKGROUND);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(SwingTetrisConstants.PADDING_FRAGMENT, SwingTetrisConstants.PADDING_FRAGMENT,
                SwingTetrisConstants.PADDING_FRAGMENT, SwingTetrisConstants.PADDING_FRAGMENT));
    }
}
