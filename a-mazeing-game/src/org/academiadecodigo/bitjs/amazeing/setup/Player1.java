package org.academiadecodigo.bitjs.amazeing.setup;

import org.academiadecodigo.bitjs.amazeing.CollisionDetector;
import org.academiadecodigo.bitjs.amazeing.Game;
import org.academiadecodigo.bitjs.amazeing.Sound;
import org.academiadecodigo.bitjs.amazeing.grid.Maze;
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
    private String lastPosition;
    private boolean canPlay;
    private Player2 player2;
    private Game game;
    private Sound boySound = new Sound("/resources/sound/NoSoundPlayer1.wav");
    private Picture heart1boy = new Picture(12, 360, "resources/newHeart.png");
    private Picture heart2boy = new Picture(12, 390, "resources/newHeart.png");
    private Picture heart3boy = new Picture(12, 420, "resources/newHeart.png");
    private int life;


    public Player1(Maze maze, SimpleGfxGrid grid, Player2 player2, Game game) {
        super(maze, grid);
        this.initialPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        this.simpleGfxGridPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Fboy1.png");
        this.collisionDetector = new CollisionDetector(getMaze());
        this.player2 = player2;
        this.game = game;
        this.life = 3;
        this.canPlay = true;
        this.lastPosition = "front";
    }

    public void init() {
        sprite.draw();
        heart1boy.draw();
        heart2boy.draw();
        heart3boy.draw();
    }

    @Override
    public void moveRight() {
        if (canPlay) {
            simpleGfxGridPosition.setCol(simpleGfxGridPosition.getCol() + 1);
            if (collisionDetector.canWalkPlayer1(this)) {

                if (!(lastPosition.equals("right"))) {
                    sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Rboy.png");
                    lastPosition = "right";

                } else {
                    sprite.translate(CELL_SIZE, 0);  // x e y
                    System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());

                }
                getSprite().draw();

            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                boySound.play(true);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fboy1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();
            }

            if (collisionDetector.winPlayer1(this, player2)) {
                sprite.delete();
                player2.getSprite().delete();
                game.endingP1();
            }
        }
    }

    @Override
    public void moveLeft() {
        if (canPlay) {
            simpleGfxGridPosition.setCol((simpleGfxGridPosition.getCol() - 1));
            if (collisionDetector.canWalkPlayer1(this)) {
                if (!(lastPosition.equals("left"))) {
                    System.out.println(simpleGfxGridPosition.getX() + " " + simpleGfxGridPosition.getY());
                    sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Lboy.png");
                    lastPosition = "left";
                } else {
                    sprite.translate(-CELL_SIZE, 0);
                    System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                }
                getSprite().draw();
            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                boySound.play(true);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fboy1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();
            }
            if (collisionDetector.winPlayer1(this, player2)) {
                sprite.delete();
                player2.getSprite().delete();
                game.endingP1();
            }
        }
    }

    @Override
    public void moveUp() {
        if (canPlay) {
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
                getSprite().draw();
            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                boySound.play(true);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fboy1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();
            }
            if (collisionDetector.winPlayer1(this, player2)) {
                sprite.delete();
                player2.getSprite().delete();
                game.endingP1();
            }
        }
    }

    @Override
    public void moveDown() {
        if (canPlay) {
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
                getSprite().draw();
            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                boySound.play(true);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fboy1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();
            }
            if (collisionDetector.winPlayer1(this, player2)) {
                sprite.delete();
                player2.getSprite().delete();
                game.endingP1();
            }
        }
    }

    public Picture getSprite() {
        return sprite;
    }

    public SimpleGfxGridPosition getSimpleGfxGridPosition() {
        return simpleGfxGridPosition;
    }

    public void setCanPlay(boolean play) {
        this.canPlay = play;
    }

    public int isDead() {
        this.life = life - 1;
        if (life == 2) {
            heart3boy.delete();
        } else if (life == 1) {
            heart2boy.delete();
        } else if (life == 0) {
            heart1boy.delete();
            sprite.delete();
            player2.getSprite().delete();
            game.endingP2();
        }
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
