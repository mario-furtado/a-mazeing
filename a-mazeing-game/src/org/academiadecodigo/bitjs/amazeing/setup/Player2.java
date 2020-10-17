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
    private String lastPosition = "front";


    public Player2(Maze maze, SimpleGfxGrid grid) {
        super(maze, grid);
        this.initialPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        this.simpleGfxGridPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/frontgirl1.png");
        this.collisionDetector = new CollisionDetector(getMaze());
    }

    public void init() {
        sprite.draw();
    }

    @Override
    public void moveRight() {
        simpleGfxGridPosition.setCol(simpleGfxGridPosition.getCol() + 1);
        if (collisionDetector.canWalkPlayer2(this)) {
            System.out.println("Consigo andar!");

            if (!(lastPosition.equals("right"))) {
                sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/rightgirl.png");
                lastPosition = "right";

            }else {
                sprite.translate(CELL_SIZE, 0);  // x e y
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
            }

        } else {

            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY(initialPosition.getRow()), "resources/frontgirl1.png");
            lastPosition = "front";
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
        }
    }

    @Override
    public void moveLeft() {
        simpleGfxGridPosition.setCol((simpleGfxGridPosition.getCol() - 1));
        if (collisionDetector.canWalkPlayer2(this)) {
            System.out.println("Consigo andar!");

            if (!(lastPosition.equals("left"))) {
                sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/leftgirl.png");
                lastPosition = "left";

            } else {
                sprite.translate(-CELL_SIZE, 0);  // x e y
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
            }

        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY(initialPosition.getRow()), "resources/frontgirl1.png");
            lastPosition = "front";
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
        }
    }

    @Override
    public void moveUp() {
        simpleGfxGridPosition.setRow((simpleGfxGridPosition.getRow() - 1));
        if (collisionDetector.canWalkPlayer2(this)) {
            if (!(lastPosition.equals("back"))) {
                sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/backgirl.png");
                lastPosition = "back";

            } else {
            sprite.translate(0, -CELL_SIZE);
            }

        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            //sprite.delete();
            sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/frontgirl1.png");
            lastPosition = "front";
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
        }
    }

    @Override
    public void moveDown() {
        simpleGfxGridPosition.setRow((simpleGfxGridPosition.getRow() + 1));
        if (collisionDetector.canWalkPlayer2(this)) {
            if (!(lastPosition.equals("front"))) {
                sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/frontgirl2.png");
                lastPosition = "front";

            }else {
            sprite.translate(0, CELL_SIZE);
            }

        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())) , "resources/frontgirl1.png");
            lastPosition = "front";
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
