package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

final class PauseMenuPanel extends MenuPanel {

    private final JFrame frame;
    private final TetrisGamePanel tetrisGamePanel;
    private final JButton resumeButton = new JButton(TetrisSwingStrings.PAUSE_MENU_RESUME);
    private final JButton controlsButton = new JButton(TetrisSwingStrings.PAUSE_MENU_CONTROLS);
    private final JButton quitButton = new JButton(TetrisSwingStrings.PAUSE_MENU_QUIT);

    public PauseMenuPanel(JFrame frame, TetrisGamePanel tetrisGamePanel) {
        this.frame = frame;
        this.tetrisGamePanel = tetrisGamePanel;
        init();
    }

    private void init() {
        setTitle(TetrisSwingStrings.PAUSE_MENU_TITLE);
        resumeButton.addActionListener(e -> tetrisGamePanel.resume());
        controlsButton.addActionListener(e -> frame.setContentPane(new ControlsPanel(frame, this)));
        quitButton.addActionListener(e -> frame.setContentPane(new MainMenuPanel(frame)));
        resumeButton.setAlignmentX(CENTER_ALIGNMENT);
        controlsButton.setAlignmentX(CENTER_ALIGNMENT);
        quitButton.setAlignmentX(CENTER_ALIGNMENT);
        resumeButton.setMaximumSize(new Dimension(SwingTetrisConstants.BUTTON_WIDTH, SwingTetrisConstants.BUTTON_HEIGHT));
        controlsButton.setMaximumSize(new Dimension(SwingTetrisConstants.BUTTON_WIDTH, SwingTetrisConstants.BUTTON_HEIGHT));
        quitButton.setMaximumSize(new Dimension(SwingTetrisConstants.BUTTON_WIDTH, SwingTetrisConstants.BUTTON_HEIGHT));
        final JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(SwingTetrisConstants.COLOR_PANEL_BACKGROUND);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.add(resumeButton);
        buttonsPanel.add(controlsButton);
        buttonsPanel.add(quitButton);
        add(buttonsPanel, BorderLayout.CENTER);
    }
}
