package org.academiadecodigo.bitjs.amazeing.setup;

import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player {
   /*private Picture sprite;
   private SimpleGfxGridPosition simpleGfxGridPosition;*/
   private Maze maze;
   private SimpleGfxGrid grid;

   public Player (/*SimpleGfxGridPosition simpleGfxGridPosition,*/ Maze maze/*, Picture sprite*/, SimpleGfxGrid grid){
      /* this.sprite = sprite;
       this.simpleGfxGridPosition = simpleGfxGridPosition;*/
       this.maze = maze;
       this.grid = grid;
   }

   public abstract void moveRight();

   public abstract void moveLeft();

   public abstract void moveUp();

   public abstract void moveDown();

   /*public Picture getSprite(){
       return sprite;
   }*/

    public Maze getMaze() {
        return maze;
    }

    public SimpleGfxGrid getGrid() {
        return grid;
    }
}
