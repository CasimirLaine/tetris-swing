package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTitleLabel;

import javax.swing.*;
import java.awt.*;

public class JInfoFragment extends JFragment {

    private final JTextField scoreText = new JTextField("-");
    private final JTextField levelText = new JTextField("-");
    private final JTextField linesText = new JTextField("-");

    public JInfoFragment() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        scoreText.setEnabled(false);
        levelText.setEnabled(false);
        linesText.setEnabled(false);
        scoreText.setHorizontalAlignment(SwingConstants.CENTER);
        levelText.setHorizontalAlignment(SwingConstants.CENTER);
        linesText.setHorizontalAlignment(SwingConstants.CENTER);
        final JTitleLabel scoreLabel = new JTitleLabel(TetrisSwingStrings.TITLE_SCORE);
        final JTitleLabel levelLabel = new JTitleLabel(TetrisSwingStrings.TITLE_LEVEL);
        final JTitleLabel linesLabel = new JTitleLabel(TetrisSwingStrings.TITLE_LINES);
        add(new JTitleLabel(TetrisSwingStrings.TITLE_INFO), BorderLayout.NORTH);
        final JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(scoreLabel);
        textPanel.add(scoreText);
        textPanel.add(levelLabel);
        textPanel.add(levelText);
        textPanel.add(linesLabel);
        textPanel.add(linesText);
        add(textPanel, BorderLayout.CENTER);
        setScore(0);
        setLevel(1);
        setLines(0);
    }

    public void setScore(int score) {
        scoreText.setText(String.valueOf(score));
    }

    public void setLevel(int level) {
        levelText.setText(String.valueOf(level));
    }

    public void setLines(int lines) {
        linesText.setText(String.valueOf(lines));
    }
}
