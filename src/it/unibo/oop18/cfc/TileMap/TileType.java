package it.unibo.oop18.cfc.TileMap;

import java.util.stream.Stream;

public enum TileType {
    // tile food
    SALAD(5, 0), BREAD(6, 0), TOMATO(7, 0), MEAT(8, 0),
    // tile action
    DISH(10, 1), WASHBASIN(11, 1), COOKER(12, 1), CHOPPINGBOARD(13, 1), COUNTER(14, 1),
    //tile floor
    LEFTPARQUET(1,0), RIGHTPARQUET(2,0);

    private int pos;
    private int space;

    private TileType(final int pos, final int space) {
        this.pos = pos;
        this.space = space;
    }

    public int getPos() {
        return pos;
    }

    public int getSpace() {
        return space;
    }

    public static TileType getTileType(int pos) {
        for (TileType t : values()) {
            if(t.getPos() == pos) {
                return t;
            }
        }
        return null;
    }
}
