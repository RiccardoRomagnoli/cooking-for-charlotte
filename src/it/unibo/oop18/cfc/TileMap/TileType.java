package it.unibo.oop18.cfc.TileMap;

import java.util.stream.Stream;

public enum TileType {
    // tile food
    SALAD(5, 0), BREAD(6, 0), TOMATO(7, 0), MEAT(8, 0),
    // tile action
    DISH(10, 1), WASHBASIN(11, 1), COOKER(12, 1), CHOPPINGBOARD(13, 1), COUNTER(14, 1),
    //tile floor
    LEFTPARQUET(1,2), RIGHTPARQUET(2,2);

    private int pos;
    private int type;

    private TileType(final int pos, final int type) {
        this.pos = pos;
        this.type = type;
    }

    public int getPos() {
        return pos;
    }

    public int getType() {
        return type;
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
