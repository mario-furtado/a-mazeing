/*
package org.academiadecodigo.bitjs.amazeing.grid;

import org.academiadecodigo.bitjs.amazeing.grid.position.GridColor;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGridPosition;

public class FieldElements {

    private SimpleGfxGrid grid;
    private SimpleGfxGridPosition[] horizontalBushes;
    private SimpleGfxGridPosition[] verticalBushes;
    private SimpleGfxGridPosition[] middleLine;

    public FieldElements(SimpleGfxGrid grid) {
        this.grid = grid;
        this.horizontalBushes = new SimpleGfxGridPosition[grid.getCols()+1];
        this.verticalBushes = new SimpleGfxGridPosition[grid.getRows()+1];
        this.middleLine = new SimpleGfxGridPosition[grid.getRows()];
    }

    public void bushesFactory() {
        //Creates the bushes of the first and last rows:
        for (int i = 0; i < horizontalBushes.length; i++) {
            horizontalBushes[i] = new SimpleGfxGridPosition(i, 0, this.grid, GridColor.GREEN);
            horizontalBushes[i] = new SimpleGfxGridPosition(i, this.grid.getRows(), this.grid, GridColor.GREEN);
        }
        //Creates the bushes of the first and last columns:
        for (int i = 0; i < verticalBushes.length; i++) {
            verticalBushes[i] = new SimpleGfxGridPosition(0, i, this.grid, GridColor.GREEN);
            verticalBushes[i] = new SimpleGfxGridPosition(this.grid.getCols(), i, this.grid, GridColor.GREEN);
        }
    }

    public void middleLineFactory(){
       for (int i = 1; i < middleLine.length; i++) {
           horizontalBushes[i] = new SimpleGfxGridPosition((int)Math.ceil(this.grid.getCols()/2), i, this.grid, GridColor.BLACK);
       }
    }
}
*/

