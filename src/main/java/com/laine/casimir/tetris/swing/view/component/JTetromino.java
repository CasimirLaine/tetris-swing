package com.laine.casimir.tetris.swing.view.component;

import com.laine.casimir.tetris.base.model.Position;
import com.laine.casimir.tetris.base.model.Tetromino;
import com.laine.casimir.tetris.swing.view.layout.TetrisGridLayout;

import javax.swing.*;
import java.awt.*;

public final class JTetromino extends JPanel {

    private TetrisGridLayout layout;

    private int cellSize;

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        for (Component component : getComponents()) {
            component.setBackground(bg);
        }
    }

    public void setTetromino(Tetromino tetromino) {
        layout = null;
        removeAll();
        if (tetromino == null) {
            return;
        }
        layout = new TetrisGridLayout(tetromino.getDimension(), tetromino.getDimension(), cellSize);
        setLayout(layout);
        for (final Position position : tetromino.getSquarePositions()) {
            final JTetrisSquare square = new JTetrisSquare();
            square.setBackground(Color.decode(tetromino.getColorHex()));
            add(square, new Point(position.getX(), position.getY()));
        }
        setFocusable(false);
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
        if (layout != null) {
            layout.setLockedCellSize(cellSize);
            revalidate();
        }
    }
}
