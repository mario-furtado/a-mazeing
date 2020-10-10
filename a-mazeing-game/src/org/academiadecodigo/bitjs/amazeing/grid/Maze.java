package org.academiadecodigo.bitjs.amazeing.grid;

import org.academiadecodigo.bitjs.amazeing.grid.position.GridColor;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;

public class Maze {
    /*
    Values:
    0 = blank space
    1 = wall
    2 = visited space
    9 = target
     */
    private int [][] maze =
            {

                    {0,1,0,1,0,1,0,0,0,0,0},
                    {0,1,0,0,0,1,0,1,1,1,0},
                    {0,0,0,1,1,1,0,0,0,0,0},
                    {0,1,0,0,0,0,0,1,1,1,0},
                    {0,1,0,1,1,1,0,1,0,0,9},   // 9 = (10,4)
                    {0,1,0,1,0,0,0,1,1,1,0},
                    {0,1,0,1,1,1,0,1,0,1,0},
                    {0,0,0,0,0,0,0,0,0,1,0},


            };
    public void paintMaze(SimpleGfxGridPosition position){
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[0].length; col++){
                GridColor color;
                switch (maze[row][col]) {
                    case 1:
                        color = GridColor.BLACK;
                        break;
                    case 0:
                        color = GridColor.NOCOLOR;
                        break;
                    case 9:
                        color = GridColor.RED;
                        break;
                }
                //position.setColor(color);


                }
            }
        }
    }


