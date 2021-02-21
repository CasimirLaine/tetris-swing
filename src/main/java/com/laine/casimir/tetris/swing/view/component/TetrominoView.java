package com.laine.casimir.tetris.swing.view.component;

import com.laine.casimir.tetris.base.api.model.BaseTetromino;
import com.laine.casimir.tetris.base.api.model.TetrisCell;
import com.laine.casimir.tetris.swing.SwingTetrisConstants;
import com.laine.casimir.tetris.swing.view.layout.TetrisGridLayout;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Point;
import java.util.List;

public final class TetrominoView extends JPanel {

    private TetrisGridLayout layout;

    private int cellSize;

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
            final MinoView minoView = new MinoView();
            minoView.setBackground(Color.decode(tetrisCell.getColorHex()));
            minoView.setForeground(SwingTetrisConstants.COLOR_TETROMINO_BORDER);
            add(minoView, new Point(tetrisCell.getX(), tetrisCell.getY()));
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
