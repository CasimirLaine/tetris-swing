package com.laine.casimir.tetris.swing.view.component;

import com.laine.casimir.tetris.base.api.model.BaseTetromino;
import com.laine.casimir.tetris.base.api.model.TetrisCell;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.view.layout.TetrisGridLayout;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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

    public void setTetromino(BaseTetromino tetromino) {
        layout = null;
        removeAll();
        if (tetromino == null) {
            return;
        }
        layout = new TetrisGridLayout(tetromino.getDimension(), tetromino.getDimension(), cellSize);
        setLayout(layout);
        final List<TetrisCell> tetrisCellList = tetromino.getTetrisCells();
        for (int index = 0; index < tetrisCellList.size(); index++) {
            final TetrisCell tetrisCell = tetrisCellList.get(index);
            final JMino jMino = new JMino();
            jMino.setBackground(Color.decode(tetrisCell.getColorHex()));
            jMino.setForeground(SwingTetrisConstants.BACKGROUND_COLOR);
            add(jMino, new Point(tetrisCell.getX(), tetrisCell.getY()));
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
