package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public final class JMainMenuPanel extends JMenuPanel {

    private final JFrame frame;

    private final JButton playButton = new JButton(TetrisSwingStrings.MAIN_MENU_PLAY);
    private final JButton quitButton = new JButton(TetrisSwingStrings.MAIN_MENU_QUIT);

    public JMainMenuPanel(JFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setTitle(TetrisSwingStrings.MAIN_MENU_TITLE);
        playButton.addActionListener(e -> frame.setContentPane(new JTetrisGamePanel(frame)));
        quitButton.addActionListener(e -> frame.dispose());
        playButton.setAlignmentX(CENTER_ALIGNMENT);
        quitButton.setAlignmentX(CENTER_ALIGNMENT);
        playButton.setMaximumSize(new Dimension(SwingTetrisConstants.BUTTON_WIDTH, SwingTetrisConstants.BUTTON_HEIGHT));
        quitButton.setMaximumSize(new Dimension(SwingTetrisConstants.BUTTON_WIDTH, SwingTetrisConstants.BUTTON_HEIGHT));
        final JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(SwingTetrisConstants.COLOR_PANEL_BACKGROUND);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.add(playButton);
        buttonsPanel.add(quitButton);
        add(buttonsPanel, BorderLayout.CENTER);
    }
}
