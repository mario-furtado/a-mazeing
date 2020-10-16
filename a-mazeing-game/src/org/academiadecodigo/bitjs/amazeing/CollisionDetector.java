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

    public boolean canWalkPlayer1(Player1 player) {

        SimpleGfxGridPosition position = player.getSimpleGfxGridPosition();

        int colP = position.getCol();
        int rowP = position.getRow();


        //for (int row = 0; row < maze.getScheme().length; row++) {        // maze.length retorna o numero de rows (8)
            //for (int col = 0; col < maze.getScheme()[0].length; col++) {
                //System.out.println(maze.getScheme()[row][col]);
                if (maze.getScheme()[rowP][colP] == 0){//maze.getScheme()[row][col] == 0 && colP == col && rowP == row) {
                    //System.out.println(colP +" " +col);
                    //System.out.println(rowP +" " + row);
                    //if(colP == col && rowP == row){
                        //System.out.println("11");
                        return false;
                    }
               // }
            //}
        System.out.println(true);
        return true;
    }

    public boolean canWalkPlayer2(Player2 player) {

        SimpleGfxGridPosition position2 = player.getSimpleGfxGridPosition();

        int colP = position2.getCol();
        int rowP = position2.getRow();


        //for (int row = 0; row < maze.getScheme().length; row++) {        // maze.length retorna o numero de rows (8)
        //for (int col = 0; col < maze.getScheme()[0].length; col++) {
        //System.out.println(maze.getScheme()[row][col]);
        if (maze.getScheme()[rowP][colP] == 0){//maze.getScheme()[row][col] == 0 && colP == col && rowP == row) {
            //System.out.println(colP +" " +col);
            //System.out.println(rowP +" " + row);
            //if(colP == col && rowP == row){
            //System.out.println("11");
            return false;
        }
        // }
        //}
        System.out.println(true);
        return true;
    }
}
