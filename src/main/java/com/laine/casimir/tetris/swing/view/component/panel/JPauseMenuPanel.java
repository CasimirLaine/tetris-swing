package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.TetrisSwingStrings;

import javax.swing.*;
import java.awt.*;

class JPauseMenuPanel extends JMenuPanel {

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
        final JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 1));
        buttonsPanel.add(resumeButton);
        buttonsPanel.add(quitButton);
        add(buttonsPanel, BorderLayout.CENTER);
    }
}
