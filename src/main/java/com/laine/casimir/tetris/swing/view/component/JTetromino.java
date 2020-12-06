package com.laine.casimir.tetris.swing.view.component;

import com.laine.casimir.tetris.base.model.Position;
import com.laine.casimir.tetris.base.model.Tetromino;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.view.layout.TetrisGridLayout;

import javax.swing.*;
import java.awt.*;

public final class JTetromino extends JPanel {

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        for (Component component : getComponents()) {
            component.setBackground(bg);
        }
    }

    public void setTetromino(Tetromino tetromino) {
        removeAll();
        if (tetromino == null) {
            return;
        }
        setLayout(new TetrisGridLayout(tetromino.getDimension(), tetromino.getDimension(), SwingTetrisConstants.TETROMINO_CELL_SIZE));
        for (final Position position : tetromino.getSquarePositions()) {
            final JTetrisSquare square = new JTetrisSquare();
            square.setBackground(Color.decode(tetromino.getColorHex()));
            add(square, new Point(position.getX(), position.getY()));
        }
        setFocusable(false);
    }
}
