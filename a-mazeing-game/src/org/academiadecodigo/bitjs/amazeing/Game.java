package org.academiadecodigo.bitjs.amazeing;

//import org.academiadecodigo.bitjs.amazeing.grid.FieldElements;
import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.setup.Player1;
import org.academiadecodigo.bitjs.amazeing.setup.Player2;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    private SimpleGfxGrid simpleGfxGrid;
    //public SimpleGfxGridPosition position = new SimpleGfxGridPosition(0,0, maze, GridColor.GREEN);

    /*private FieldElements fieldElements;*/

    private Player1 player1;
    private Player2 player2;
    private Maze maze;
    private InicialMenu menu;

    //PLAYERS MOVEMENT:
    private KeyboardEvent right;
    private KeyboardEvent left;
    private KeyboardEvent up;
    private KeyboardEvent down;
    private KeyboardEvent right2;
    private KeyboardEvent left2;
    private KeyboardEvent up2;
    private KeyboardEvent down2;

    //MENU:
    /*private KeyboardEvent startMenu;*/
    /*private KeyboardEvent quitMenu;*/

    //RENDER:
    /*private Render render = Render.MENU;*/


    /*public void renderType(){*/
    /*    if(render == Render.MENU){*/
    /*        menu.initMenu();*/
    /*    }*/
    /*    if(render == Render.GAME){*/
    /*        this.start();*/
    /*    }*/
    /*}*/


    public Game(SimpleGfxGrid simpleGfxGrid/*FieldElements fieldElements, Maze maze*/){
        this.simpleGfxGrid = simpleGfxGrid;       /*= new SimpleGfxGrid(60,28)*/;
       /* this.fieldElements = fieldElements; */     /*= new BoarderLine(maze)*/;
        this.maze = new Maze();
        this.player1 = new Player1(maze,simpleGfxGrid);
        this.player2 = new Player2(maze,simpleGfxGrid);
        //this.menu = new InicialMenu(simpleGfxGrid);
        //this.renderType();
        //bootstrapMenu();
    }

    public void start(){
        simpleGfxGrid.init();
        maze.paintMaze(simpleGfxGrid);
        /*fieldElements.bushesFactory();
        fieldElements.middleLineFactory();*/
        player1.init();
       // System.out.println("ESTAAAA " + (player1.getSimpleGfxGridPosition().getCol() + " " + (player1.getSimpleGfxGridPosition().getRow())));
        player2.init();
        initP();
    }

    //--------------PLAYERS MOVEMENT--------------

    public void initP(){
        bootstrapP1();
        bootstrapP2();
    }

    private void bootstrapP1(){

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

    //-------menu bootstrap--------//

   /* private void bootstrapMenu(){
        Keyboard keyboard3 = new Keyboard(this);

        startMenu = new KeyboardEvent();
        startMenu.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        startMenu.setKey(KeyboardEvent.KEY_SPACE);
        keyboard3.addEventListener(startMenu);

        quitMenu = new KeyboardEvent();
        quitMenu.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        quitMenu.setKey(KeyboardEvent.KEY_E);
        keyboard3.addEventListener(quitMenu);

    }*/


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == right.getKey()){
           /* if( player1.getPosition().getCol() == field.getWidth() ){

            }*/
            player1.getSprite().delete();
            player1.moveRight();
            player1.getSprite().draw();
        }

        if (keyboardEvent.getKey() == left.getKey()){
            //if( player1.getPosition().getCol() == field.g)
            player1.getSprite().delete();
            player1.moveLeft();
            player1.getSprite().draw();
        }

        if(keyboardEvent.getKey() == up.getKey()){
            player1.getSprite().delete();
            player1.moveUp();
            player1.getSprite().draw();
        }

        if(keyboardEvent.getKey() == down.getKey()){
            player1.getSprite().delete();
            player1.moveDown();
            player1.getSprite().draw();
        }
// --------- Player2 ------------------------//

        if (keyboardEvent.getKey() == right2.getKey()){
           /* if( player2.getPosition().getCol() == field.getWidth() ) {

            }*/
            player2.getSprite().delete();
            player2.moveRight();
           player2.getSprite().draw();
        }

        if (keyboardEvent.getKey() == left2.getKey()){
            player2.getSprite().delete();
            player2.moveLeft();
           player2.getSprite().draw();
        }

        if(keyboardEvent.getKey() == up2.getKey()){
            player2.getSprite().delete();
            player2.moveUp();
            player2.getSprite().draw();
        }

        if(keyboardEvent.getKey() == down2.getKey()){
            player2.getSprite().delete();
            player2.moveDown();
            //player2.getSprite().draw();
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
}

