package org.academiadecodigo.bitjs.amazeing.grid;

import org.academiadecodigo.bitjs.amazeing.grid.position.GridColor;
import org.academiadecodigo.bitjs.amazeing.setup.Player1;
import org.academiadecodigo.bitjs.amazeing.setup.tiles.FixedBush;
import org.academiadecodigo.bitjs.amazeing.setup.tiles.Path;
import org.academiadecodigo.bitjs.amazeing.setup.tiles.Trophy;
import org.academiadecodigo.bitjs.amazeing.setup.tiles.WalkableBush;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;

public class Maze {
    
    /*
    Values:
    0 = green unbreakable wall (fixed bushes)
    1 = rock path
    2 = green wall (inside the maze)
    3 = green path (walkable bushes)
    4 = player1 initial position
    5 = player2 initial position
    9 = trophy
     */

    private static final int PADDING = 10;
    private FixedBush fixedBush;
    private WalkableBush walkableBush;
    private Path path;
    private Trophy trophy;

    private int[][] scheme =
            {
                    //0| 1| 2 |3| 4| 5| 6| 7 |8 |9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40

                    {0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 0, 3, 0, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                    {0, 0, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 1, 0, 3, 0, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0},
                    {0, 0, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0, 3, 0, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0, 0},
                    {0, 0, 1, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 0, 3, 0, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 1, 0, 0},
                    {0, 0, 1, 2, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0, 3, 0, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 2, 1, 0, 0},
                    {0, 0, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 0, 3, 0, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 0, 0},
                    {0, 0, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0, 3, 0, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 0, 0},
                    {0, 0, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 3, 0, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0},
                    {4, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 5},
                    {0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 0, 3, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 0, 0},
                    {0, 0, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 0, 3, 0, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 0, 0},
                    {0, 0, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 0, 3, 0, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 0, 0},
                    {0, 0, 1, 2, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0, 3, 0, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1, 2, 1, 0, 0},
                    {0, 0, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 0, 3, 0, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 0, 0},
                    {0, 0, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 0, 3, 0, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 0, 0},
                    {0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1, 0, 3, 0, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 0, 0},
                    {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0, 3, 0, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0},
            };


    public void paintMaze(SimpleGfxGrid grid) {
        for (int row = 0; row < scheme.length; row++) {        // maze.length retorna o numero de rows (8)
            for (int col = 0; col < scheme[0].length; col++) {  // maze[0].length retorna o numero de cols (11)

                /*GridColor color = GridColor.NOCOLOR;*/

                SimpleGfxGridPosition position = new SimpleGfxGridPosition(col, row, grid/*, color*/);

                switch (scheme[row][col]) {
                    case 1:
                        path = new Path(row,col,grid);
                        path.init();
                        /*color = GridColor.NOCOLOR;
                        position.setColor(color);
                        position.show();*/
                        break;
                    case 0:
                        fixedBush = new FixedBush(row,col,grid);
                        fixedBush.init();
                        /*color = GridColor.GREEN;
                        position.setColor(color);
                        position.show();*/
                        break;
                    case 2:
                        fixedBush = new FixedBush(row,col,grid);
                        fixedBush.init();
                        /*color = GridColor.BLACK;
                        position.setColor(color);
                        position.show();*/
                        break;
                    case 3:
                        walkableBush = new WalkableBush(row,col,grid);
                        walkableBush.init();
                        /*color = GridColor.GREEN;
                        position.setColor(color);
                        position.show();*/
                        break;
                    case 4:
                        path = new Path(row,col,grid);
                        path.init();
                        break;
                    case 5:
                        path = new Path(row,col,grid);
                        path.init();
                        break;
                    case 9:
                        trophy = new Trophy(row,col,grid);
                        trophy.init();
                        /*color = GridColor.RED;
                        position.setColor(color);
                        position.show();*/
                        break;
                }
            }
        }
    }

    public int[][] getScheme() {
        return scheme;
    }
}



