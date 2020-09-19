package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTetrisFrame;

import javax.swing.*;
import java.awt.*;

class JPauseMenuPanel extends JMenuPanel {

    private final JTetrisFrame frame;
    private final JTetrisGamePanel tetrisGamePanel;
    private final Button resumeButton = new Button(TetrisSwingStrings.PAUSE_MENU_RESUME);
    private final Button quitButton = new Button(TetrisSwingStrings.PAUSE_MENU_QUIT);

    public JPauseMenuPanel(JTetrisFrame frame, JTetrisGamePanel tetrisGamePanel) {
        this.frame = frame;
        this.tetrisGamePanel = tetrisGamePanel;
        init();
    }

    private void init() {
        setTitle(TetrisSwingStrings.PAUSE_MENU_TITLE);
        resumeButton.addActionListener(e -> tetrisGamePanel.resume());
        quitButton.addActionListener(e -> frame.setPanel(new JMainMenuPanel(frame)));
        final JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.add(resumeButton, BorderLayout.CENTER);
        buttonsPanel.add(quitButton, BorderLayout.SOUTH);
        add(buttonsPanel, BorderLayout.CENTER);
    }
}
