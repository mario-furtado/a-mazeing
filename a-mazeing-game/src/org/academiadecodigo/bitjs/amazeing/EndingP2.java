package org.academiadecodigo.bitjs.amazeing;

import org.academiadecodigo.bitjs.amazeing.setup.Player2;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EndingP2 {

    private Picture picture = new Picture(10,10,"resources/BigWinnerGirl.jpg");

    public EndingP2(){}

    public void init(Player2 player2){
        player2.getSprite().delete();
        picture.draw();
    }
}
