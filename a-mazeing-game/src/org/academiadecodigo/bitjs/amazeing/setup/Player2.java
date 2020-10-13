package org.academiadecodigo.bitjs.amazeing.setup;


import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player2 extends Player {

    private Picture sprite;
    private SimpleGfxGridPosition simpleGfxGridPosition = initialPosition();


    public Player2(Maze maze, SimpleGfxGrid grid) {
        super(maze,grid);
        //this.simpleGfxGridPosition = simpleGfxGridPosition;
        sprite = new Picture(simpleGfxGridPosition.getX(), simpleGfxGridPosition.getY(),"resources/bushbush.png");

    }

    private SimpleGfxGridPosition initialPosition(){
        Maze maze = super.getMaze();

        for (int row = 0; row < maze.getScheme().length; row++) {        // maze.length retorna o numero de rows
            for (int col = 0; col < maze.getScheme()[0].length; col++) {  // maze[0].length retorna o numero de cols

                if (maze.getScheme()[row][col] == 5) {
                    this.simpleGfxGridPosition = new SimpleGfxGridPosition(col, row, super.getGrid());
                    return simpleGfxGridPosition;
                }
            }
        }
        return null;
    }

    public void init(){
        sprite.draw();
    }

    @Override
    public void moveRight() {
        sprite.translate(40,0);
        simpleGfxGridPosition.setCol(simpleGfxGridPosition.getCol() +40);
    }

    @Override
    public void moveLeft() {
        sprite.translate(-40,0);
        simpleGfxGridPosition.setCol(simpleGfxGridPosition.getCol() -40);
    }

    @Override
    public void moveUp() {
        sprite.translate(0,-40);
        simpleGfxGridPosition.setRow(simpleGfxGridPosition.getRow() - 40);
    }

    @Override
    public void moveDown() {
        sprite.translate(0,40);
        simpleGfxGridPosition.setRow(simpleGfxGridPosition.getRow() + 40);
    }

    public Picture getSprite() {
        return sprite;
    }
}
