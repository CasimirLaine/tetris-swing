package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

final class JPauseMenuPanel extends JMenuPanel {

    private final JFrame frame;
    private final JTetrisGamePanel tetrisGamePanel;
    private final JButton resumeButton = new JButton(TetrisSwingStrings.PAUSE_MENU_RESUME);
    private final JButton quitButton = new JButton(TetrisSwingStrings.PAUSE_MENU_QUIT);

    public JPauseMenuPanel(JFrame frame, JTetrisGamePanel tetrisGamePanel) {
        this.frame = frame;
        this.tetrisGamePanel = tetrisGamePanel;
        init();
    }

    private void init() {
        setTitle(TetrisSwingStrings.PAUSE_MENU_TITLE);
        resumeButton.addActionListener(e -> tetrisGamePanel.resume());
        quitButton.addActionListener(e -> frame.setContentPane(new JMainMenuPanel(frame)));
        resumeButton.setAlignmentX(CENTER_ALIGNMENT);
        quitButton.setAlignmentX(CENTER_ALIGNMENT);
        resumeButton.setMaximumSize(new Dimension(SwingTetrisConstants.BUTTON_WIDTH, SwingTetrisConstants.BUTTON_HEIGHT));
        quitButton.setMaximumSize(new Dimension(SwingTetrisConstants.BUTTON_WIDTH, SwingTetrisConstants.BUTTON_HEIGHT));
        final JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(SwingTetrisConstants.COLOR_PANEL_BACKGROUND);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.add(resumeButton);
        buttonsPanel.add(quitButton);
        add(buttonsPanel, BorderLayout.CENTER);
    }
}
