package org.academiadecodigo.bitjs.amazeing.setup;

import org.academiadecodigo.bitjs.amazeing.CollisionDetector;
import org.academiadecodigo.bitjs.amazeing.EndingP1;
import org.academiadecodigo.bitjs.amazeing.EndingP2;
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
    private static final int CELL_SIZE = 30;  //40
    private static final int INITIAL_COL = 1;  //0
    private static final int INITIAL_ROW = 11;  //10
    private String lastPosition = "front";

    private EndingP1 endingP1;
    private EndingP2 endingP2;

    private EndingP1 endingP1 = new EndingP1();
    private boolean canPlay = true;

    private int life = 3;
    //private boolean dead = false;

    public Player1(Maze maze, SimpleGfxGrid grid) {
        super(maze, grid);
        this.initialPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        this.simpleGfxGridPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Fboy1.png");
        this.collisionDetector = new CollisionDetector(getMaze());
        this.endingP1 = new EndingP1();
        this.endingP2 = new EndingP2();
    }

    public void init() {
        sprite.draw();
    }

    @Override
    public void moveRight() {
        if(canPlay) {

            simpleGfxGridPosition.setCol(simpleGfxGridPosition.getCol() + 1);
            if (collisionDetector.canWalkPlayer1(this)) {
                System.out.println("Consigo andar!");

                if (!(lastPosition.equals("right"))) {
                    sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Rboy.png");
                    lastPosition = "right";

                } else {
                    sprite.translate(CELL_SIZE, 0);  // x e y
                    System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());

                }
            } else {

                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fboy1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();
            }

                //endingP1.init();
            getSprite().draw();

            if (collisionDetector.winPlayer1(this)) {
                endingP1.init(this);
                sprite.delete();
            }
        }
    }

    @Override
    public void moveLeft() {
        if(canPlay) {
            simpleGfxGridPosition.setCol((simpleGfxGridPosition.getCol() - 1));
            if (collisionDetector.canWalkPlayer1(this)) {
                System.out.println("Consigo andar!");
                if (!(lastPosition.equals("left"))) {
                    System.out.println(simpleGfxGridPosition.getX() + " " + simpleGfxGridPosition.getY());
                    sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Lboy.png");
                    lastPosition = "left";
                } else {
                    sprite.translate(-CELL_SIZE, 0);
                    System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                }
            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fboy1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();
            }

            getSprite().draw();

            if (collisionDetector.winPlayer1(this)) {
                endingP1.init(this);
                sprite.delete();
            }
        }
    }

    @Override
    public void moveUp() {
        if(canPlay) {
            simpleGfxGridPosition.setRow((simpleGfxGridPosition.getRow() - 1));
            if (collisionDetector.canWalkPlayer1(this)) {
                if (!(lastPosition.equals("back"))) {
                    System.out.println(simpleGfxGridPosition.getX() + " " + simpleGfxGridPosition.getY());
                    sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Uboy.png");
                    lastPosition = "back";
                } else {
                    sprite.translate(0, -CELL_SIZE);
                    System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                }
            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fboy1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();
            }

            getSprite().draw();

            if (collisionDetector.winPlayer1(this)) {
                endingP1.init(this);
                sprite.delete();
            }
        }
    }

    @Override
    public void moveDown() {
        if(canPlay) {
            simpleGfxGridPosition.setRow((simpleGfxGridPosition.getRow() + 1));
            if (collisionDetector.canWalkPlayer1(this)) {
                if (!(lastPosition.equals("front"))) {
                    System.out.println(simpleGfxGridPosition.getX() + " " + simpleGfxGridPosition.getY());
                    sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Fboy2.png");
                    lastPosition = "front";
                } else {
                    sprite.translate(0, CELL_SIZE);
                    System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                }

            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fboy1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();
            }

            getSprite().draw();

            if (collisionDetector.winPlayer1(this)) {
                sprite.delete();
               // endingP1.init();

                //endingP1.init(this);
            }
        }
    }

    public Picture getSprite() {
        return sprite;
    }

    public SimpleGfxGridPosition getSimpleGfxGridPosition() {
        return simpleGfxGridPosition;
    }

    public void setCanPlay(boolean play){
        this.canPlay = play;
    }
    
    public int isDead(){
        this.life = life -1;
        if(life == 0){
            endingP2.init();
        }
        return life;
    }
}
