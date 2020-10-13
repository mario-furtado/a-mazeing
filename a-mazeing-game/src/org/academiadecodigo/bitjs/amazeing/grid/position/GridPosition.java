package org.academiadecodigo.bitjs.amazeing.grid.position;

import org.academiadecodigo.bitjs.amazeing.grid.Grid;
import org.academiadecodigo.bitjs.amazeing.grid.GridDirection;

public interface GridPosition {

  /*  public int getCol();

    public int getRow();*/

    public void setPos(int col, int row);

    //public GridColor getColor();

    //public void setColor(GridColor color);

    public void show();

    public void hide();

    public void moveInDirection(GridDirection direction, int distance);

    //Vai ser fixe para sabermos se ele esta a bater na parede ou nao:
    //public boolean equals(GridPosition position);


}
