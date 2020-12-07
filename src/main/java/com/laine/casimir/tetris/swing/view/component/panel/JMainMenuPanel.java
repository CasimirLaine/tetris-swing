package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.TetrisSwingStrings;

import javax.swing.*;
import java.awt.*;

public class JMainMenuPanel extends JMenuPanel {

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
        final JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 0));
        buttonsPanel.add(playButton);
        buttonsPanel.add(quitButton);
        add(buttonsPanel, BorderLayout.CENTER);
    }
}
