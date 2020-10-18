package org.academiadecodigo.bitjs.amazeing.setup;

import org.academiadecodigo.bitjs.amazeing.CollisionDetector;
import org.academiadecodigo.bitjs.amazeing.EndingP1;
import org.academiadecodigo.bitjs.amazeing.EndingP2;
import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player2 extends Player {


    private Picture sprite;
    private SimpleGfxGridPosition initialPosition;
    private SimpleGfxGridPosition simpleGfxGridPosition;
    private CollisionDetector collisionDetector;
    private static final int CELL_SIZE = 30;  //30
private static final int INITIAL_COL = 45; // 44
    private static final int INITIAL_ROW = 11; //10
    private String lastPosition = "front";

    private EndingP2 endingP2;
    private EndingP1 endingP1;

    private int life = 3;
    private EndingP2 endingP2 = new EndingP2();
    private boolean canPlay = true;


    public Player2(Maze maze, SimpleGfxGrid grid) {
        super(maze, grid);
        this.initialPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        this.simpleGfxGridPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Fgirl1.png");
        this.collisionDetector = new CollisionDetector(getMaze());
        this.endingP1 = new EndingP1();
        this.endingP2 = new EndingP2();
    }

    public void init() {
        simpleGfxGridPosition = initialPosition;
        sprite.draw();
    }

    @Override
    public void moveRight() {
        if (canPlay) {

            simpleGfxGridPosition.setCol(simpleGfxGridPosition.getCol() + 1);
            if (collisionDetector.canWalkPlayer2(this)) {
                System.out.println("Consigo andar!");

                if (!(lastPosition.equals("right"))) {
                    sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Rgirl.png");
                    lastPosition = "right";

                } else {
                    sprite.translate(CELL_SIZE, 0);  // x e y
                    System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                }

            } else {

                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY(initialPosition.getRow()), "resources/Fgirl1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
            }

            getSprite().draw();

            if (collisionDetector.winPlayer2(this)) {
                endingP2.init(this);
                sprite.delete();
            }
        }
    }

    @Override
    public void moveLeft() {
        if (canPlay) {
            simpleGfxGridPosition.setCol((simpleGfxGridPosition.getCol() - 1));
            if (collisionDetector.canWalkPlayer2(this)) {
                System.out.println("Consigo andar!");

                if (!(lastPosition.equals("left"))) {
                    sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Lgirl.png");
                    lastPosition = "left";

                } else {
                    sprite.translate(-CELL_SIZE, 0);  // x e y
                    System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                }

            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY(initialPosition.getRow()), "resources/Fgirl1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();
            }
            getSprite().draw();

        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY(initialPosition.getRow()), "resources/Fgirl1.png");
            lastPosition = "front";
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
            isDead();
        }
                  if (collisionDetector.winPlayer2(this)) {
                endingP2.init(this);
                sprite.delete();
            }
        }
    }

    @Override
    public void moveUp() {
        if (canPlay) {
            simpleGfxGridPosition.setRow((simpleGfxGridPosition.getRow() - 1));
            if (collisionDetector.canWalkPlayer2(this)) {
                if (!(lastPosition.equals("back"))) {
                    sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Ugirl.png");
                    lastPosition = "back";

                } else {
                    sprite.translate(0, -CELL_SIZE);
                }

            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                //sprite.delete();
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fgirl1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
            }
            getSprite().draw();

        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            //sprite.delete();
            sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fgirl1.png");
            lastPosition = "front";
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
            isDead();
        }
                if (collisionDetector.winPlayer2(this)) {
                endingP2.init(this);
                sprite.delete();
            }
        }
    }

    @Override
    public void moveDown() {
        if (canPlay) {
            simpleGfxGridPosition.setRow((simpleGfxGridPosition.getRow() + 1));
            if (collisionDetector.canWalkPlayer2(this)) {
                if (!(lastPosition.equals("front"))) {
                    sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Fgirl2.png");
                    lastPosition = "front";

                } else {
                    sprite.translate(0, CELL_SIZE);
                }

            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fgirl1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
            }
            getSprite().draw();

        } else {
            this.simpleGfxGridPosition.setCol(INITIAL_COL);
            this.simpleGfxGridPosition.setRow(INITIAL_ROW);
            sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())) , "resources/Fgirl1.png");
            lastPosition = "front";
            sprite.draw();
            System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
            isDead();
            if (collisionDetector.winPlayer2(this)) {
                sprite.delete();
                endingP2.init(this);
            }
        }
    }

    public Picture getSprite() {
        return sprite;
    }

    public SimpleGfxGridPosition getSimpleGfxGridPosition() {
        return simpleGfxGridPosition;
    }

    public int isDead(){
        this.life = life -1;
        if(life == 0){
            endingP1.init();
        }
        return life;

    public void setCanPlay(boolean play){
        this.canPlay = play;
    }
}

