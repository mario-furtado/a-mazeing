package org.academiadecodigo.bitjs.amazeing;

import org.academiadecodigo.bitjs.amazeing.grid.FieldElements;
import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;

public class Main {
    public static void main(String[] args) {
        SimpleGfxGrid maze = new SimpleGfxGrid(31,18);
        FieldElements fieldElements = new FieldElements(maze);

        Game game = new Game(maze, fieldElements);

        game.start();

        Maze mazeee = new Maze();

        mazeee.paintMaze(maze);




    }
}
