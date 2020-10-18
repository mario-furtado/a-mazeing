package org.academiadecodigo.bitjs.amazeing;

import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.setup.Player;
import org.academiadecodigo.bitjs.amazeing.setup.Player1;
import org.academiadecodigo.bitjs.amazeing.setup.Player2;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {

    private Maze maze;

    public CollisionDetector(Maze maze) {
        this.maze = maze;
    }

    public boolean winPlayer1(Player1 player1, Player2 player2){
        SimpleGfxGridPosition position = player1.getSimpleGfxGridPosition();

        int colP = position.getCol();
        int rowP = position.getRow();

        if(maze.getScheme()[rowP][colP] != 9){
            return false;
        }

        player1.setCanPlay(false);
        player2.setCanPlay(false);
        return true;
    }

    public boolean winPlayer2(Player2 player2,Player1 player1){
        SimpleGfxGridPosition position = player2.getSimpleGfxGridPosition();

        int colP = position.getCol();
        int rowP = position.getRow();

        if(maze.getScheme()[rowP][colP] != 9){
            return false;
        }
        player1.setCanPlay(false);
        player2.setCanPlay(false);
        return true;
    }

    public boolean canWalkPlayer1(Player1 player) {

        SimpleGfxGridPosition position = player.getSimpleGfxGridPosition();

        int colP = position.getCol();
        int rowP = position.getRow();

        if (maze.getScheme()[rowP][colP] == 0 || maze.getScheme()[rowP][colP] == 2 || maze.getScheme()[rowP][colP] == 6
                || maze.getScheme()[rowP][colP] == 7 || maze.getScheme()[rowP][colP] == 12) {
            return false;
        }

        System.out.println(true);
        return true;
    }

    public boolean canWalkPlayer2(Player2 player2) {

        SimpleGfxGridPosition position2 = player2.getSimpleGfxGridPosition();
        int colP = position2.getCol();
        int rowP = position2.getRow();

        if (maze.getScheme()[rowP][colP] == 0 || maze.getScheme()[rowP][colP] == 2 || maze.getScheme()[rowP][colP] == 6 || maze.getScheme()[rowP][colP] == 7 || maze.getScheme()[rowP][colP] == 12) {//maze.getScheme()[row][col] == 0 && colP == col && rowP == row) {
            return false;
        }

        System.out.println(true);
        return true;
    }
}
