package org.academiadecodigo.bitjs.amazeing.setup;

import org.academiadecodigo.bitjs.amazeing.CollisionDetector;
import org.academiadecodigo.bitjs.amazeing.Game;
import org.academiadecodigo.bitjs.amazeing.Sound;
import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player2 extends Player {

    private Picture sprite;
    private SimpleGfxGridPosition initialPosition;
    private SimpleGfxGridPosition simpleGfxGridPosition;
    private CollisionDetector collisionDetector;
    private static final int CELL_SIZE = 30;
    private static final int INITIAL_COL = 45;
    private static final int INITIAL_ROW = 11;
    private String lastPosition;
    private boolean canPlay;
    private Player1 player1;
    private Game game;
    private Sound girlSound = new Sound("/resources/sound/NoSoundPlayer2.wav");
    private Picture heart1girl = new Picture(1398,300,"resources/newHeart.png");
    private Picture heart2girl = new Picture(1398,270,"resources/newHeart.png");
    private Picture heart3girl = new Picture(1398,240,"resources/newHeart.png");
    private int life;


    public Player2(Maze maze, SimpleGfxGrid grid, Player1 player1, Game game) {
        super(maze, grid);
        this.initialPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        this.simpleGfxGridPosition = new SimpleGfxGridPosition(INITIAL_COL, INITIAL_ROW, grid);
        sprite = new Picture(getGrid().columnToX(simpleGfxGridPosition.getCol()), getGrid().rowToY((simpleGfxGridPosition.getRow())), "resources/Fgirl1.png");
        this.collisionDetector = new CollisionDetector(getMaze());
        this.player1 = player1;
        this.game = game;
        this.life = 3;
        this.canPlay = true;
        this.lastPosition = "front";
    }

    public void init() {
        sprite.draw();
        heart1girl.draw();
        heart2girl.draw();
        heart3girl.draw();
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
                getSprite().draw();
            } else {

                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                girlSound.play(true);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY(initialPosition.getRow()), "resources/Fgirl1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();

            }
            if (collisionDetector.winPlayer2(this,player1)) {
                sprite.delete();
                player1.getSprite().delete();
                game.endingP2();
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
                getSprite().draw();
            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                girlSound.play(true);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY(initialPosition.getRow()), "resources/Fgirl1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();
            }
            if (collisionDetector.winPlayer2(this,player1)) {
                sprite.delete();
                player1.getSprite().delete();
                game.endingP2();
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
                getSprite().draw();
            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                girlSound.play(true);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fgirl1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());
                isDead();
            }
            if (collisionDetector.winPlayer2(this,player1)) {
                sprite.delete();
                player1.getSprite().delete();
                game.endingP2();
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
                getSprite().draw();
            } else {
                this.simpleGfxGridPosition.setCol(INITIAL_COL);
                this.simpleGfxGridPosition.setRow(INITIAL_ROW);
                girlSound.play(true);
                sprite = new Picture(getGrid().columnToX(initialPosition.getCol()), getGrid().rowToY((initialPosition.getRow())), "resources/Fgirl1.png");
                lastPosition = "front";
                sprite.draw();
                System.out.println("col " + simpleGfxGridPosition.getCol() + " " + "row " + simpleGfxGridPosition.getRow());

                isDead();
            }
            if (collisionDetector.winPlayer2(this,player1)) {
                sprite.delete();
                player1.getSprite().delete();
                game.endingP2();
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
        if (life == 2) {
            heart3girl.delete();
        } else if (life == 1) {
            heart2girl.delete();
        } else if (life == 0) {
            heart1girl.delete();
            System.out.println("testP2DEAD");
            sprite.delete();
            player1.getSprite().delete();
            game.endingP1();
        }
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
