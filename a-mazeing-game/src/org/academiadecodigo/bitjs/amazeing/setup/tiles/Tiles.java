package org.academiadecodigo.bitjs.amazeing.setup.tiles;

public enum Tiles {
    FIXEDBUSH (0),
    WALKABLEBUSH (3),
    TROPHY (9),
    PATH (1),
    P1START(4),
    P2START(5);

    private int symbol;

    Tiles(int symbol){
        this.symbol = symbol;
    }

    public int getSymbol(){
        return symbol;
    }
}
