package org.academiadecodigo.bitjs.amazeing;

import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.setup.Player1;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;

public class CollisionDetector {

    private Maze maze;

    public CollisionDetector(Maze maze){
        this.maze = maze;
    }

    public boolean canWalk(Player1 player){

        SimpleGfxGridPosition position = player.getCurrentPosition();
        int rowP = position.getRow();
        int colP = position.getCol();

        for (int row = 0; row < (maze.getScheme()).length; row++) {        // maze.length retorna o numero de rows
            for (int col = 0; col < (maze.getScheme()[0]).length; col++) {   // maze[0].length retorna o numero de cols
                if (((maze.getScheme())[col][row]) == 0 || ((maze.getScheme())[col][row]) == 2) {    // 0 e 2 é onde nao pode andar
                    if(colP == col && rowP == row){
                        return false;
                    }
                    return true;
                }
                return true;
            }
        }
        return true;
    }
}