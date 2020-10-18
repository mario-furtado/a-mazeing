package org.academiadecodigo.bitjs.amazeing;

//import org.academiadecodigo.bitjs.amazeing.grid.FieldElements;
import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;

public class Main {
    public static void main(String[] args) {
        SimpleGfxGrid simpleGfxGrid = new SimpleGfxGrid(47,23); // 45  21
        /*Maze maze = new Maze();
        Game game = new Game(simpleGfxGrid, maze);
        game.start();
       */

       InicialMenu menu = new InicialMenu(simpleGfxGrid);

       /*Sound sound = new Sound("/Desktop/game2.0/a-amazeing/a-mazeing-game/resources/sound/GameMusic.wav");
       sound.play(true);*/
    }
}
