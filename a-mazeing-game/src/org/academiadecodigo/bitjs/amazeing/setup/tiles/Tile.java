package org.academiadecodigo.bitjs.amazeing.setup.tiles;

import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

abstract public class Tile {
    private SimpleGfxGrid grid;
    private int row;
    private int col;

     public Tile(int row, int col, SimpleGfxGrid grid){
         this.col = col;
         this.row = row;
         this.grid = grid;
     };
}
