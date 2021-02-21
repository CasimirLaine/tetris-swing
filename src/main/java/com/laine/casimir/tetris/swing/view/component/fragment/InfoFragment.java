package com.laine.casimir.tetris.swing.view.component.fragment;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.TetrisSwingStrings;
import com.laine.casimir.tetris.swing.view.component.TitleLabel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;

public final class InfoFragment extends Fragment {

    private static final float FONT_SIZE_TEXT_FIELD = 42F;

    private final JTextField scoreText = new JTextField("-");
    private final JTextField levelText = new JTextField("-");
    private final JTextField linesText = new JTextField("-");

    public InfoFragment() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        configureTextField(scoreText);
        configureTextField(levelText);
        configureTextField(linesText);
        final TitleLabel scoreLabel = new TitleLabel(TetrisSwingStrings.TITLE_SCORE);
        final TitleLabel levelLabel = new TitleLabel(TetrisSwingStrings.TITLE_LEVEL);
        final TitleLabel linesLabel = new TitleLabel(TetrisSwingStrings.TITLE_LINES);
        add(new TitleLabel(TetrisSwingStrings.TITLE_INFO), BorderLayout.NORTH);
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
        textField.setBackground(SwingTetrisConstants.COLOR_FRAGMENT_CONTENT_BACKGROUND);
        textField.setForeground(SwingTetrisConstants.COLOR_FRAGMENT_TEXT);
        Font scoreFont = textField.getFont();
        scoreFont = scoreFont.deriveFont(FONT_SIZE_TEXT_FIELD);
        textField.setFont(scoreFont);
    }
}
