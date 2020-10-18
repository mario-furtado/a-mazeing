package org.academiadecodigo.bitjs.amazeing.setup;

import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player {
   private Maze maze;
   private SimpleGfxGrid grid;

   public Player ( Maze maze, SimpleGfxGrid grid){
       this.maze = maze;
       this.grid = grid;
   }

   public abstract void moveRight();

   public abstract void moveLeft();

   public abstract void moveUp();

   public abstract void moveDown();

    public Maze getMaze() {
        return maze;
    }

    public SimpleGfxGrid getGrid() {
        return grid;
    }
}
