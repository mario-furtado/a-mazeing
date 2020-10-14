package org.academiadecodigo.bitjs.amazeing;

//import org.academiadecodigo.bitjs.amazeing.grid.FieldElements;
import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;

public class Main {
    public static void main(String[] args) {
        SimpleGfxGrid simpleGfxGrid = new SimpleGfxGrid(45,21);
        /*FieldElements fieldElements = new FieldElements(simpleGfxGrid);*/
        Maze maze = new Maze();
        /*maze.paintMaze(simpleGfxGrid);*/

        Game game = new Game(simpleGfxGrid, /*fieldElements,*/ maze);

        game.start();

        /*Maze maze = new Maze();*/


    }
}
