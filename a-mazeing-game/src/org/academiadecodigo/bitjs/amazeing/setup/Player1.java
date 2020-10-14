package org.academiadecodigo.bitjs.amazeing.setup;

import org.academiadecodigo.bitjs.amazeing.CollisionDetector;
import org.academiadecodigo.bitjs.amazeing.grid.Maze;
import org.academiadecodigo.bitjs.amazeing.grid.position.GridColor;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player1 extends Player {

    private Picture sprite;
    private SimpleGfxGridPosition initialPosition;
    private SimpleGfxGridPosition currentPosition;
    private CollisionDetector collisionDetector;

    public Player1(Maze maze, SimpleGfxGrid grid) {
        super(maze,grid);
        initialPosition = initialPosition();
        this.currentPosition = initialPosition;
        this.collisionDetector = new CollisionDetector(maze);
        sprite = new Picture(currentPosition.getX(), currentPosition.getY(),"resources/right.png");

    }

    private SimpleGfxGridPosition initialPosition(){
    Maze maze = super.getMaze();

        for (int row = 0; row < maze.getScheme().length; row++) {        // maze.length retorna o numero de rows
            for (int col = 0; col < maze.getScheme()[0].length; col++) {  // maze[0].length retorna o numero de cols

                if (maze.getScheme()[row][col] == 4) {
                    this.initialPosition = new SimpleGfxGridPosition(col, row, super.getGrid());
                    return initialPosition;
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
        currentPosition.setCol(currentPosition.getCol() +40);

        if(collisionDetector.canWalk(this)){
            sprite.translate(40,0);
            //currentPosition.setCol(currentPosition.getCol() +40);
        } else {
            //this.currentPosition = initialPosition;
            //sprite.draw();
            currentPosition.setCol(currentPosition.getCol() -40);
            //this.currentPosition = initialPosition;
        }
    }

    @Override
    public void moveLeft() {
        sprite.translate(-40,0);
        currentPosition.setCol(currentPosition.getCol() -40);
    }

    @Override
    public void moveUp() {
        sprite.translate(0,-40);
        currentPosition.setRow(currentPosition.getRow() - 40);
    }

    @Override
    public void moveDown() {
        sprite.translate(0,40);
        currentPosition.setRow(currentPosition.getRow() + 40);
    }

    public Picture getSprite() {
        return sprite;
    }

    public SimpleGfxGridPosition getCurrentPosition() {
        return currentPosition;
    }
}
