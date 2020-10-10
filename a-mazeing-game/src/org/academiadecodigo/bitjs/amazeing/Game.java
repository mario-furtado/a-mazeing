package org.academiadecodigo.bitjs.amazeing;

import org.academiadecodigo.bitjs.amazeing.grid.FieldElements;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;

public class Game {

    private SimpleGfxGrid maze ;
    //public SimpleGfxGridPosition position = new SimpleGfxGridPosition(0,0, maze, GridColor.GREEN);

    private FieldElements fieldElements;


    public Game(SimpleGfxGrid maze, FieldElements fieldElements){
        this.maze = maze;       /*= new SimpleGfxGrid(60,28)*/;
        this.fieldElements = fieldElements;      /*= new BoarderLine(maze)*/;

    }


    public void start(){
        maze.init();
        fieldElements.bushesFactory();
        fieldElements.middleLineFactory();
    }



}
