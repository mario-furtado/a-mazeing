package org.academiadecodigo.bitjs.amazeing;

import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.setup.Player1;
import org.academiadecodigo.bitjs.amazeing.setup.Player2;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    private SimpleGfxGrid simpleGfxGrid;
    private Player1 player1;
    private Player2 player2;
    private Maze maze;
    private InitialMenu menu;

    //PLAYERS MOVEMENT:
    private KeyboardEvent right;
    private KeyboardEvent left;
    private KeyboardEvent up;
    private KeyboardEvent down;
    private KeyboardEvent right2;
    private KeyboardEvent left2;
    private KeyboardEvent up2;
    private KeyboardEvent down2;
    private boolean runGame;

    private Picture pictureBoy = new Picture(10,10,"resources/BigBoyWinner.jpg");
    private Picture pictureGirl = new Picture(10,10,"resources/BigWinnerGirl.jpg");
    private Sound victorySound = new Sound("/resources/sound/ChampionsEnd.wav");

    //Constructor Method
    public Game(SimpleGfxGrid simpleGfxGrid, InitialMenu menu){
        victorySound.stop();
        this.simpleGfxGrid = simpleGfxGrid;
        this.maze = new Maze();
        this.player1 = new Player1(maze,simpleGfxGrid,this.player2 = new Player2(maze,simpleGfxGrid,player1,this),this);
        this.player2 = new Player2(maze,simpleGfxGrid,this.player1,this);
        this.menu = menu;
        this.runGame = true;
    }

    public void start(){
        simpleGfxGrid.init();
        maze.paintMaze(simpleGfxGrid);
        player1.init();
        player2.init();
        initP();
    }

    //--------------PLAYERS MOVEMENT--------------
    public void initP(){
        bootstrapP2();
        bootstrapP1();
    }

    //-----------------PLAYER 1 ---------------------------------------
    private  void bootstrapP1(){
        if(runGame) {
            Keyboard keyboard2 = new Keyboard(this);

            right = new KeyboardEvent();
            right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            right.setKey(KeyboardEvent.KEY_D);
            keyboard2.addEventListener(right);

            left = new KeyboardEvent();
            left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            left.setKey(KeyboardEvent.KEY_A);
            keyboard2.addEventListener(left);

            up = new KeyboardEvent();
            up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            up.setKey(KeyboardEvent.KEY_W);
            keyboard2.addEventListener(up);

            down = new KeyboardEvent();
            down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            down.setKey(KeyboardEvent.KEY_S);
            keyboard2.addEventListener(down);
        }
    }

    //-----------------PLAYER 2 ---------------------------------------
    private void bootstrapP2(){
        if(runGame) {

            Keyboard keyboard1 = new Keyboard(this);

            //mover player para a direita (-> e D)
            right2 = new KeyboardEvent();
            right2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            right2.setKey(KeyboardEvent.KEY_RIGHT);
            keyboard1.addEventListener(right2);


            // mover player para a esquerda (<- e A)
            left2 = new KeyboardEvent();
            left2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            left2.setKey(KeyboardEvent.KEY_LEFT);
            keyboard1.addEventListener(left2);


            // mover player para cima (^ e W)
            up2 = new KeyboardEvent();
            up2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            up2.setKey(KeyboardEvent.KEY_UP);
            keyboard1.addEventListener(up2);


            //mover player para baixo (v e S)
            down2 = new KeyboardEvent();
            down2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            down2.setKey(KeyboardEvent.KEY_DOWN);
            keyboard1.addEventListener(down2);
        }

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(runGame) {
            if (keyboardEvent.getKey() == right.getKey()) {
           /* if( player1.getPosition().getCol() == field.getWidth() ){

            }*/
                player1.getSprite().delete();
                player1.moveRight();
                //player1.getSprite().draw();
            }

            if (keyboardEvent.getKey() == left.getKey()) {
                //if( player1.getPosition().getCol() == field.g)
                player1.getSprite().delete();
                player1.moveLeft();
                //player1.getSprite().draw();
            }

            if (keyboardEvent.getKey() == up.getKey()) {
                player1.getSprite().delete();
                player1.moveUp();
                //player1.getSprite().draw();
            }

            if (keyboardEvent.getKey() == down.getKey()) {
                player1.getSprite().delete();
                player1.moveDown();
                //player1.getSprite().draw();
            }
// --------- Player2 ------------------------//

            if (keyboardEvent.getKey() == right2.getKey()) {
           /* if( player2.getPosition().getCol() == field.getWidth() ) {

            }*/
                player2.getSprite().delete();
                player2.moveRight();
                //player2.getSprite().draw();
            }

            if (keyboardEvent.getKey() == left2.getKey()) {
                player2.getSprite().delete();
                player2.moveLeft();
                //player2.getSprite().draw();
            }

            if (keyboardEvent.getKey() == up2.getKey()) {
                player2.getSprite().delete();
                player2.moveUp();
                //player2.getSprite().draw();
            }

            if (keyboardEvent.getKey() == down2.getKey()) {
                player2.getSprite().delete();
                player2.moveDown();
                //player2.getSprite().draw();
            }
        }

        //-----menu-----//

        /*if(keyboardEvent.getKey() == startMenu.getKey()){
            render = Render.GAME;
            System.out.println("space");
        }

        if(keyboardEvent.getKey() == quitMenu.getKey()){
             System.exit(0);
            System.out.println("quit");

        }*/
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    //Remove Player 1
    public void endingP1(){
        runGame = false;
        player1.getSprite().delete();
        player2.getSprite().delete();
        pictureBoy.draw();
        menu.getGameSound().close();
        menu.getInitialSound().close();
        victorySound.play(true);
        player1.setLife(3);
        player2.setLife(3);
    }

    //Remove Player 2
    public void endingP2(){
        runGame = false;
        player2.getSprite().delete();
        player1.getSprite().delete();
        pictureGirl.draw();
        menu.getGameSound().close();
        menu.getInitialSound().close();
        victorySound.play(true);
        player1.setLife(3);
        player2.setLife(3);
    }

    public Sound getVictorySound() {
        return victorySound;
    }
}

