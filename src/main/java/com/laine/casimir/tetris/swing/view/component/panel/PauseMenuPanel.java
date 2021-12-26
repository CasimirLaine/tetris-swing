package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.TetrisSwingStrings;

import javax.swing.JButton;
import javax.swing.JFrame;

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
        addButtons(resumeButton, controlsButton, quitButton);
    }
}
