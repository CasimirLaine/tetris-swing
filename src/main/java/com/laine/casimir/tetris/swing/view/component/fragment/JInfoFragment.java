package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.JTitleLabel;

import javax.swing.*;
import java.awt.*;

public final class JInfoFragment extends JFragment {

    private static final float FONT_SIZE_TEXT_FIELD = 42F;

    private final JTextField scoreText = new JTextField("-");
    private final JTextField levelText = new JTextField("-");
    private final JTextField linesText = new JTextField("-");

    public JInfoFragment() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        configureTextField(scoreText);
        configureTextField(levelText);
        configureTextField(linesText);
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

    private void configureTextField(JTextField textField) {
        textField.setEnabled(false);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        Font scoreFont = textField.getFont();
        scoreFont = scoreFont.deriveFont(FONT_SIZE_TEXT_FIELD);
        textField.setFont(scoreFont);
    }
}
