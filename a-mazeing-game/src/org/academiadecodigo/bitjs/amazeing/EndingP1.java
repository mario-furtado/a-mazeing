package org.academiadecodigo.bitjs.amazeing;
import org.academiadecodigo.bitjs.amazeing.setup.Player;
import org.academiadecodigo.bitjs.amazeing.setup.Player1;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class EndingP1 implements KeyboardHandler {

    //private Rectangle rect = new Rectangle(10,10,1410,690);
    private Picture picture = new Picture(10,10,"resources/BigBoyWinner.jpg");
    private KeyboardEvent restart;
    private InicialMenu inicialMenu;

    public EndingP1(){}

    public void init(/*Player1 player1*/){
        bootstrapEndingP1();
        //player1.getSprite().delete();
        //rect.setColor(Color.RED);
        //rect.fill();
        picture.draw();
    }

    /*public void deletePlayer1 (Player1 player1){
        SimpleGfxGridPosition position = player1.getSimpleGfxGridPosition();

        if(position.getCol() == 23 && position.getRow() == 11){
            player1.getSprite().delete();
            player1.setCanPlay(false);
        }
    }*/

    private void bootstrapEndingP1(){
        Keyboard keyboard4 = new Keyboard(this);
        restart = new KeyboardEvent();
        restart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        restart.setKey(KeyboardEvent.KEY_R);
        keyboard4.addEventListener(restart);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){
        if(keyboardEvent.getKey() == restart.getKey() /*&& canStart*/){
            picture.delete();
            inicialMenu.initMenu();
            //canStart = false;
            System.out.println("R");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){}
}

