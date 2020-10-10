package org.academiadecodigo.bitjs.amazeing.simplegfx;

import org.academiadecodigo.bitjs.amazeing.grid.Grid;
import org.academiadecodigo.bitjs.amazeing.grid.position.GridColor;
import org.academiadecodigo.bitjs.amazeing.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;
    private int cols;
    private int rows;
    private static final int CELL_SIZE = 30;
    private Rectangle rectangle;

    public SimpleGfxGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    @Override
    public void init(){
        this.rectangle = new Rectangle(PADDING,PADDING,cols*CELL_SIZE,rows*CELL_SIZE);
        rectangle.draw();
    }

    @Override
    public int getCols(){
        return this.cols;
    }

    @Override
    public int getRows(){
        return this.rows;
    }

    public int getWidth(){
        return rectangle.getWidth();
    }

    public int getHeight(){
        return rectangle.getHeight();
    }

    public int getX(){
        return rectangle.getX();
    }

    public int getY(){
        return rectangle.getY();
    }

    public static int getCellSize() {
        return CELL_SIZE;
    }

    @Override
    public GridPosition makeGridPosition(int col, int row, GridColor gridColor){
        return new SimpleGfxGridPosition(col, row, this, gridColor);
    }

    public int rowToyY(int row){
        return PADDING + row*CELL_SIZE;
    }

    public int columnToX(int column){
        return PADDING + column*CELL_SIZE;
    }
}
