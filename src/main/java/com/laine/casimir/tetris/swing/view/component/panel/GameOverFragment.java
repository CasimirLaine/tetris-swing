package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTitleLabel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;

public final class GameOverFragment extends JMenuPanel {

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
        quitButton.setAlignmentX(CENTER_ALIGNMENT);
        quitButton.setMaximumSize(new Dimension(SwingTetrisConstants.BUTTON_WIDTH, SwingTetrisConstants.BUTTON_HEIGHT));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JTitleLabel(TetrisSwingStrings.TITLE_GAME_OVER));
        add(quitButton);
    }
}
