package org.academiadecodigo.bitjs.amazeing.setup.tiles;

import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RightFence extends Tile {
    private SimpleGfxGridPosition position;
    private Picture picture;

    public RightFence(int row, int col, SimpleGfxGrid grid) {
        super(row, col, grid);
        position = new SimpleGfxGridPosition(col, row, grid);
        picture = new Picture(position.getX(), position.getY(), "resources/leftFence.png");
    }

    public void init() {
        picture.draw();
    }

}

