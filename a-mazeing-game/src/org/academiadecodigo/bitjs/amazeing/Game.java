package org.academiadecodigo.bitjs.amazeing;

import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.setup.Player1;
import org.academiadecodigo.bitjs.amazeing.setup.Player2;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    /*public SimpleGfxGridPosition position = new SimpleGfxGridPosition(0,0, maze, GridColor.GREEN);

    private FieldElements fieldElements;*/
    private SimpleGfxGrid simpleGfxGrid;
    private Player1 player1;
    private Player2 player2;
    private Maze maze;

    //PLAYERS MOVEMENT:
    private KeyboardEvent right;
    private KeyboardEvent left;
    private KeyboardEvent up;
    private KeyboardEvent down;
    private KeyboardEvent right2;
    private KeyboardEvent left2;
    private KeyboardEvent up2;
    private KeyboardEvent down2;


    public Game(SimpleGfxGrid simpleGfxGrid, /*FieldElements fieldElements,*/ Maze maze){
        /* this.fieldElements = fieldElements; */     /*= new BoarderLine(maze)*/;
        this.simpleGfxGrid = simpleGfxGrid;       /*= new SimpleGfxGrid(60,28)*/;
        this.maze = maze;
        this.player1 = new Player1(maze,simpleGfxGrid);
        this.player2 = new Player2(maze,simpleGfxGrid);
    }

    public void start(){
        simpleGfxGrid.init();  //Desenha a grid base (retangulo grande)
        maze.paintMaze(simpleGfxGrid);  //Desenha os sprites dos bush, etc no jogo
        player1.init();  //Desenha sprite do player1
        player2.init();  //Desenha sprite do player2
        init();
         /*fieldElements.bushesFactory();
        fieldElements.middleLineFactory();*/
    }

    //--------------PLAYERS MOVEMENT--------------

    public void init(){
        bootstrapP1();
        bootstrapP2();
    }

    private void bootstrapP1(){

        Keyboard keyboard1 = new Keyboard(this);

        //move player para a direita (-> e D)
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

    private  void bootstrapP2(){
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


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == right.getKey()){
           /* if( player1.getPosition().getCol() == field.getWidth() ){

            }*/
            player1.moveRight();
        }

        if (keyboardEvent.getKey() == left.getKey()){
            //if( player1.getPosition().getCol() == field.g)
            player1.moveLeft();
        }

        if(keyboardEvent.getKey() == up.getKey()){
            player1.moveUp();
        }

        if(keyboardEvent.getKey() == down.getKey()){
            player1.moveDown();
        }
// --------- Player2 ------------------------//
        if (keyboardEvent.getKey() == right2.getKey()){
           /* if( player2.getPosition().getCol() == field.getWidth() ) {

            }*/
            player2.moveRight();
        }

        if (keyboardEvent.getKey() == left2.getKey()){
            player2.moveLeft();
        }

        if(keyboardEvent.getKey() == up2.getKey()){
            player2.moveUp();
        }

        if(keyboardEvent.getKey() == down2.getKey()){
            player2.moveDown();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

