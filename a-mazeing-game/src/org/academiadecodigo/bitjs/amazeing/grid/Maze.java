package org.academiadecodigo.bitjs.amazeing.grid;

import org.academiadecodigo.bitjs.amazeing.grid.position.GridColor;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxColorMapper;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
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
                    {0,1,0,0,0,1,0,1,1,1,0},    //8 rows and 11 cols
                    {0,0,0,1,1,1,0,0,0,0,0},
                    {0,1,0,0,0,0,0,1,1,1,0},
                    {0,1,0,1,1,1,0,1,0,0,9},   // 9 = (10,4)
                    {0,1,0,1,0,0,0,1,1,1,0},
                    {0,1,0,1,1,1,0,1,0,1,0},
                    {0,0,0,0,0,0,0,0,0,1,0},


            };


    public void paintMaze(SimpleGfxGrid grid){
        for(int row = 0; row < maze.length; row++){        // maze.length retorna o numero de rows (8)
            for(int col = 0; col < maze[0].length; col++){  // maze[0].length retorna o numero de cols (11)

                GridColor color = GridColor.NOCOLOR;

                SimpleGfxGridPosition position = new SimpleGfxGridPosition(col,row,grid,color);

                switch (maze[row][col]) {
                    case 1:
                        color = GridColor.BLACK;
                        position.setColor(color);
                        position.show();
                        break;
                    case 0:
                        color = GridColor.NOCOLOR;
                        position.setColor(color);
                        position.show();
                        break;
                    case 9:
                        color = GridColor.RED;
                        position.setColor(color);
                        position.show();
                        break;
                }
            }
        }
    }
}



