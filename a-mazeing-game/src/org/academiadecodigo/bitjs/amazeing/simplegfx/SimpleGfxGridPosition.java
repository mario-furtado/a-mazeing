package org.academiadecodigo.bitjs.amazeing.simplegfx;

import org.academiadecodigo.bitjs.amazeing.grid.GridDirection;
import org.academiadecodigo.bitjs.amazeing.grid.position.AbstractGridPosition;
import org.academiadecodigo.bitjs.amazeing.grid.position.GridColor;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    private int cols;
    private int rows;
    private GridColor Color;

    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid, GridColor colour){
        super(col, row, grid);

        simpleGfxGrid = grid;

        int x = grid.columnToX(col);
        int y = grid.rowToyY(row);

        this.rectangle = new Rectangle(x,y, grid.getCellSize(), grid.getCellSize());
        setColor(colour);
        show();
    }

   @Override
   public void show(){
        //setColor(Color);
        this.rectangle.fill();
   }

    @Override
    public void hide(){
        this.rectangle.delete();
    }

    @Override
    public void moveInDirection(GridDirection direction, int distance){
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPos(int col, int row){
        throw new UnsupportedOperationException();
    }

    @Override
    public void setColor(GridColor color){
        this.rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        super.setColor(color);
    }


}
