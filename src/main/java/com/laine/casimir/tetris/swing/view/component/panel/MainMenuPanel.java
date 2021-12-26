package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.TetrisSwingStrings;

import javax.swing.JButton;
import javax.swing.JFrame;

public final class MainMenuPanel extends MenuPanel {

    private final JFrame frame;

    private final JButton playButton = new JButton(TetrisSwingStrings.MAIN_MENU_PLAY);
    private final JButton controlsButton = new JButton(TetrisSwingStrings.MAIN_MENU_CONTROLS);
    private final JButton quitButton = new JButton(TetrisSwingStrings.MAIN_MENU_QUIT);

    public MainMenuPanel(JFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setTitle(TetrisSwingStrings.MAIN_MENU_TITLE);
        playButton.addActionListener(e -> frame.setContentPane(new TetrisGamePanel(frame)));
        controlsButton.addActionListener(e -> frame.setContentPane(new ControlsPanel(frame, this)));
        quitButton.addActionListener(e -> frame.dispose());
        addButtons(playButton, controlsButton, quitButton);
    }
}
