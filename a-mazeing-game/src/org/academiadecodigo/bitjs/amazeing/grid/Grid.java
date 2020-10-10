package org.academiadecodigo.bitjs.amazeing.grid;

import org.academiadecodigo.bitjs.amazeing.grid.position.GridColor;
import org.academiadecodigo.bitjs.amazeing.grid.position.GridPosition;

public interface Grid {

    public void init();

    public int getCols();

    public int getRows();

    public GridPosition makeGridPosition(int col, int row, GridColor gridColor);

}
