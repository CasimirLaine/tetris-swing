package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTitleLabel;
import com.laine.casimir.tetris.swing.view.component.panel.JMainMenuPanel;
import com.laine.casimir.tetris.swing.view.component.panel.JTetrisGamePanel;

import javax.swing.*;
import java.awt.*;

public class GameOverFragment extends JFragment {

    private final JFrame frame;
    private final JTetrisGamePanel tetrisGamePanel;
    private final JButton quitButton = new JButton(TetrisSwingStrings.PAUSE_MENU_QUIT);

    public GameOverFragment(JFrame frame, JTetrisGamePanel tetrisGamePanel) {
        this.frame = frame;
        this.tetrisGamePanel = tetrisGamePanel;
        init();
    }

    private void init() {
        setVisible(false);
        quitButton.addActionListener(e -> frame.setContentPane(new JMainMenuPanel(frame)));
        add(new JTitleLabel(TetrisSwingStrings.TITLE_GAME_OVER), BorderLayout.NORTH);
        add(quitButton, BorderLayout.CENTER);
    }
}
