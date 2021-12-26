package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.TitleLabel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public final class GameOverPanel extends MenuPanel {

    private final JFrame frame;
    private final TetrisGamePanel tetrisGamePanel;
    private final JButton quitButton = new JButton(TetrisSwingStrings.PAUSE_MENU_QUIT);

    public GameOverPanel(JFrame frame, TetrisGamePanel tetrisGamePanel) {
        this.frame = frame;
        this.tetrisGamePanel = tetrisGamePanel;
        init();
    }

    private void init() {
        setVisible(true);
        quitButton.addActionListener(e -> frame.setContentPane(new MainMenuPanel(frame)));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setTitle(TetrisSwingStrings.TITLE_GAME_OVER);
        addButtons(quitButton);
    }
}
