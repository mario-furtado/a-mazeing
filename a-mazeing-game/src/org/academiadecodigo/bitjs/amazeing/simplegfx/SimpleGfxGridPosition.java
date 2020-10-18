package org.academiadecodigo.bitjs.amazeing.simplegfx;

import org.academiadecodigo.bitjs.amazeing.grid.GridDirection;
import org.academiadecodigo.bitjs.amazeing.grid.position.AbstractGridPosition;
import org.academiadecodigo.bitjs.amazeing.grid.position.GridColor;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;
    private int col;
    private int row;
    private int x;
    private int y;

    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid, GridColor colour) {
        super(grid);

        this.col = col;
        this.row = row;

        simpleGfxGrid = grid;

        this.x = grid.columnToX(col);
        this.y = grid.rowToY(row);

        this.rectangle = new Rectangle(x, y, grid.getCellSize(), grid.getCellSize());
        setColor(colour);
        show();
    }

    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid) {
        super(grid);

        simpleGfxGrid = grid;

        this.x = grid.columnToX(col);
        this.y = grid.rowToY(row);
        this.col = col;
        this.row = row;
        this.rectangle = new Rectangle(x, y, grid.getCellSize(), grid.getCellSize());
    }

    @Override
    public void show() {
        this.rectangle.draw();
    }

    @Override
    public void hide() {
        this.rectangle.delete();
    }

    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPos(int col, int row) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setColor(GridColor color) {
        this.rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        super.setColor(color);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
        this.x = simpleGfxGrid.columnToX(col);
    }

    public void setRow(int row) {
        this.row = row;
        this.y = simpleGfxGrid.rowToY(row);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
