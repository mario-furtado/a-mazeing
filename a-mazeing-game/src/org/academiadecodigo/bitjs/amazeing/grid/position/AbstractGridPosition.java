package org.academiadecodigo.bitjs.amazeing.grid.position;

import org.academiadecodigo.bitjs.amazeing.grid.Grid;
import org.academiadecodigo.bitjs.amazeing.grid.GridDirection;

public abstract class AbstractGridPosition implements GridPosition {

    //private int col;
    //private int row;
    private GridColor color;
    private Grid grid;

    public AbstractGridPosition(/*int col, int row,*/ Grid grid){
        //this.col = col;
       // this.row = row;
        this.grid = grid;
        this.color = GridColor.NOCOLOR;
    }

    public Grid getGrid(){
        return this.grid;
    }

   /* @Override
    public int getCol(){
        return col;
    }

    @Override
    public int getRow(){
        return row;
    }*/

    //public GridColor getColor();

    public void setColor(GridColor color){
        this.color = color;
        show();
    }

    @Override
    public void moveInDirection(GridDirection direction, int distance){

    }
}
