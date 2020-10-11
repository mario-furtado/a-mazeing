package org.academiadecodigo.bitjs.amazeing;

import org.academiadecodigo.bitjs.amazeing.grid.FieldElements;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;

public class Game {

    private SimpleGfxGrid simpleGfxGrid;
    //public SimpleGfxGridPosition position = new SimpleGfxGridPosition(0,0, maze, GridColor.GREEN);

    private FieldElements fieldElements;


    public Game(SimpleGfxGrid simpleGfxGrid, FieldElements fieldElements){
        this.simpleGfxGrid = simpleGfxGrid;       /*= new SimpleGfxGrid(60,28)*/;
        this.fieldElements = fieldElements;      /*= new BoarderLine(maze)*/;

    }


    public void start(){
        simpleGfxGrid.init();
        fieldElements.bushesFactory();
        fieldElements.middleLineFactory();
    }



}
