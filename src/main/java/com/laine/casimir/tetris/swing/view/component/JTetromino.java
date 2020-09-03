package com.laine.casimir.tetris.swing.view.component;

import com.laine.casimir.tetris.base.model.Position;
import com.laine.casimir.tetris.base.model.tetromino.AbstractTetromino;

import java.awt.*;

public class JTetromino extends AbstactTetrisComponent {

    private final AbstractTetromino tetromino;

    public JTetromino(AbstractTetromino tetromino) {
        super();
        if (tetromino == null) {
            throw new IllegalStateException("tetromino can not be null!");
        }
        this.tetromino = tetromino;
        init(tetromino);
    }

    private void init(AbstractTetromino tetromino) {
        setBackground(Color.decode(tetromino.getColorHex()));
        final GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        for (final Position positions : tetromino.getSquarePositions()) {
            final GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.gridx = positions.getX();
            constraints.gridy = positions.getY();
            constraints.weightx = 1.0;
            constraints.weighty = 1.0;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            final JTetrisSquare square = new JTetrisSquare();
            square.setBackground(getBackground());
            add(square, constraints);
        }
        setFocusable(false);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        for (Component component : getComponents()) {
            component.setBackground(bg);
        }
    }

    public AbstractTetromino getTetromino() {
        return tetromino;
    }
}
