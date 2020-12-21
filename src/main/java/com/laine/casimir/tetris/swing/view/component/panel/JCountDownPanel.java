package com.laine.casimir.tetris.swing.view.component.panel;

import com.laine.casimir.tetris.swing.SwingTetrisConstants;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCountDownPanel extends JPanel {

    private static final float FONT_SIZE = 64F;

    private final JLabel label = new JLabel();

    private final int from;

    private int value;
    private final Timer timer = new Timer(0, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(String.valueOf(value));
            if (value > 0) {
                value--;
            } else {
                timer.stop();
            }
        }
    });

    public JCountDownPanel(int from) {
        this.from = from;
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        timer.setRepeats(true);
        timer.setDelay(1_000);
        label.setForeground(SwingTetrisConstants.COLOR_COUNTDOWN);
        label.setText(String.valueOf(from));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        Font font = label.getFont();
        font = font.deriveFont(FONT_SIZE);
        label.setFont(font);
        add(label, BorderLayout.CENTER);
    }

    public void start(Runnable onReady) {
        value = from;
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (value <= 0) {
                    timer.removeActionListener(this);
                    if (onReady != null) {
                        onReady.run();
                    }
                }
            }
        });
        timer.restart();
    }
}
