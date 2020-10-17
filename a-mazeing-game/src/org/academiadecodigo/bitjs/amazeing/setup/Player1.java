package org.academiadecodigo.bitjs.amazeing.setup;

import org.academiadecodigo.bitjs.amazeing.CollisionDetector;
import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.grid.position.GridColor;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player1 extends Player {

    private Picture sprite;
    private SimpleGfxGridPosition initialPosition;
    private SimpleGfxGridPosition simpleGfxGridPosition;
    private CollisionDetector collisionDetector;
    private static final int CELL_SIZE = 40;
    private static final int INITIAL_COL = 0;  //0
    private static final int INITIAL_ROW = 10;  //10
    private String lastPosition = "front";


    public Player1(Maze maze, SimpleGfxGrid grid) {
        super(maze, grid);
        this.initialPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        this.simpleGfxGridPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        sprite = new Picture(simpleGfxGridPosition.getX(), simpleGfxGridPosition.getY(), "resources/frontboy1.png");
        this.collisionDetector = new CollisionDetector(getMaze());
    }

    public void init() {
        sprite.draw();
    }

    @Override
    public void moveRight() {

        simpleGfxGridPosition.setCol(simpleGfxGridPosition.getCol() + 1);
        if (collisionDetector.canWalkPlayer1(this)) {
            System.out.println("Consigo andar!");

            if (!(lastPosition.equals("right"))) {
                sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/rightboy.png");
                lastPosition = "right";

            } else {
                sprite.translate(CELL_SIZE, 0);  // x e y
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());

            }
        } else {

            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite.delete();
            sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/frontboy1.png");
            lastPosition = "front";
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
        }
    }

    @Override
    public void moveLeft() {
        simpleGfxGridPosition.setCol((simpleGfxGridPosition.getCol() - 1));
        if (collisionDetector.canWalkPlayer1(this)) {
            System.out.println("Consigo andar!");
            if (!(lastPosition.equals("left"))) {
                System.out.println(simpleGfxGridPosition.getX() + " " + simpleGfxGridPosition.getY());
                sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/leftboy.png");
                lastPosition = "left";
            } else {
                sprite.translate(-CELL_SIZE, 0);
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
            }
        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite.delete();
            sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/frontboy1.png");
            lastPosition = "front";
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
        }
    }

    @Override
    public void moveUp() {
        simpleGfxGridPosition.setRow((simpleGfxGridPosition.getRow() - 1));
        if (collisionDetector.canWalkPlayer1(this)) {
            if (!(lastPosition.equals("back"))) {
                System.out.println(simpleGfxGridPosition.getX() + " " + simpleGfxGridPosition.getY());
                sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/backboy.png");
                lastPosition = "back";
            } else {
                sprite.translate(0, -CELL_SIZE);
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
            }
        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite = new Picture(initialPosition.getX(), initialPosition.getY(), "resources/frontboy1.png");
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
        }
    }

    @Override
    public void moveDown() {
        simpleGfxGridPosition.setRow((simpleGfxGridPosition.getRow() + 1));
        if (collisionDetector.canWalkPlayer1(this)) {
            if (!(lastPosition.equals("front"))) {
                System.out.println(simpleGfxGridPosition.getX() + " " + simpleGfxGridPosition.getY());
                sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/frontboy2.png");
                lastPosition = "front";
            } else {
                sprite.translate(0, CELL_SIZE);
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
            }

        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite = new Picture(initialPosition.getX(), initialPosition.getY(), "resources/frontboy1.png");
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
