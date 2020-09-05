package com.laine.casimir.tetris.swing.view;

import com.laine.casimir.tetris.base.model.Playfield;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.view.component.JLoadingPane;
import com.laine.casimir.tetris.swing.view.component.JTetrisGrid;
import com.laine.casimir.tetris.swing.view.layout.TetrisGridLayout;

import javax.swing.*;
import java.awt.*;

public class SwingManager {

    private final JFrame frame = new JFrame(SwingTetrisConstants.APP_NAME);
    private final JLoadingPane loadingPane = new JLoadingPane();
    private final JTetrisGrid tetrisGrid = new JTetrisGrid();
    private final TetrisGridLayout tetrisGridLayout = new TetrisGridLayout(Playfield.WIDTH, Playfield.VISIBLE_HEIGHT);

    public SwingManager() {
        init();
    }

    private void init() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(SwingTetrisConstants.DEFAULT_WIDTH, SwingTetrisConstants.DEFAULT_HEIGHT));
        frame.setMinimumSize(new Dimension(SwingTetrisConstants.MIN_WIDTH, SwingTetrisConstants.MIN_HEIGHT));
        frame.setGlassPane(loadingPane);
        loadingPane.setAnimationEnabled(true);
        loadingPane.setVisible(true);
        tetrisGrid.setBackground(Color.decode(Playfield.BACKGROUND_COLOR));
        tetrisGrid.setForeground(Color.decode(Playfield.GRID_COLOR));
        tetrisGrid.setLayout(tetrisGridLayout);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(tetrisGrid, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
