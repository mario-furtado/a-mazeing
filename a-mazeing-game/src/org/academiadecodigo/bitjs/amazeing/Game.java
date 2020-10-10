package org.academiadecodigo.bitjs.amazeing;

import org.academiadecodigo.bitjs.amazeing.grid.position.GridColor;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;

public class Game {

    public SimpleGfxGrid maze = new SimpleGfxGrid(60,28);
    public SimpleGfxGridPosition position = new SimpleGfxGridPosition(0,0, maze, GridColor.GREEN);

    SimpleGfxGridPosition [] newPosition = new SimpleGfxGridPosition[10];
    for (int i = 0; i< newPosition.length; i++){

    }

    public Game(){
        maze.init();
    }



}
