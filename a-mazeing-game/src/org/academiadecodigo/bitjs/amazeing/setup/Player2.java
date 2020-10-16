package org.academiadecodigo.bitjs.amazeing.setup;


import org.academiadecodigo.bitjs.amazeing.CollisionDetector;
import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player2 extends Player {

    private Picture sprite;
    private SimpleGfxGridPosition initialPosition;
    private SimpleGfxGridPosition simpleGfxGridPosition;
    private CollisionDetector collisionDetector;
    private static final int CELL_SIZE = 40;
    private static final int INITIAL_COL = 44;
    private static final int INITIAL_ROW = 10;


    public Player2(Maze maze, SimpleGfxGrid grid) {
        super(maze, grid);
        this.initialPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        this.simpleGfxGridPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        sprite = new Picture(simpleGfxGridPosition.getX(), simpleGfxGridPosition.getY(), "resources/bushbush.png");
        this.collisionDetector = new CollisionDetector(getMaze());
    }

    /*private SimpleGfxGridPosition initialPosition(){
        Maze maze = super.getMaze();

        for (int row = 0; row < maze.getScheme().length; row++) {        // maze.length retorna o numero de rows
            for (int col = 0; col < maze.getScheme()[0].length; col++) {  // maze[0].length retorna o numero de cols

                if (maze.getScheme()[row][col] == 5) {
                    this.simpleGfxGridPosition = new SimpleGfxGridPosition(col, row, super.getGrid());
                    return simpleGfxGridPosition;
                }
            }
        }
        return null;
    }*/

    public void init() {
        sprite.draw();
    }

    @Override
    public void moveRight() {
        simpleGfxGridPosition.setCol(simpleGfxGridPosition.getCol() + 1);
        if (collisionDetector.canWalkPlayer2(this)) {
            System.out.println("Consigo andar!");
            sprite.translate(CELL_SIZE, 0);  // x e y
            //currentPosition.setCol(currentPosition.getCol() +40);
        } else {
            //currentPosition.setCol(currentPosition.getCol() -40);
            //this.simpleGfxGridPosition = initialPosition;
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite.delete();
            sprite = new Picture(initialPosition.getX(), initialPosition.getY(), "resources/bushbush.png");
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
        }
    }

    @Override
    public void moveLeft() {
        simpleGfxGridPosition.setCol((simpleGfxGridPosition.getCol() - 1));
        if (collisionDetector.canWalkPlayer2(this)) {
            sprite.translate(-CELL_SIZE, 0);
            //simpleGfxGridPosition.setCol(simpleGfxGridPosition.getCol() - 40);
        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite.delete();
            sprite = new Picture(initialPosition.getX(), initialPosition.getY(), "resources/bushbush.png");
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
        }
    }

    @Override
    public void moveUp() {
        simpleGfxGridPosition.setRow((simpleGfxGridPosition.getRow() - 1));
        if (collisionDetector.canWalkPlayer2(this)) {
            sprite.translate(0, -CELL_SIZE);
            //simpleGfxGridPosition.setRow(simpleGfxGridPosition.getRow() - 40);
        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite.delete();
            sprite = new Picture(initialPosition.getX(), initialPosition.getY(), "resources/bushbush.png");
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
        }
    }

    @Override
    public void moveDown() {
        simpleGfxGridPosition.setRow((simpleGfxGridPosition.getRow() + 1));
        if (collisionDetector.canWalkPlayer2(this)) {
            sprite.translate(0, CELL_SIZE);
            //simpleGfxGridPosition.setRow(simpleGfxGridPosition.getRow() + 40);
        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite.delete();
            sprite = new Picture(initialPosition.getX(), initialPosition.getY(), "resources/bushbush.png");
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
        }
    }


    public Picture getSprite() {
        return sprite;
    }

    public SimpleGfxGridPosition getSimpleGfxGridPosition() {
        return simpleGfxGridPosition;
    }
}
