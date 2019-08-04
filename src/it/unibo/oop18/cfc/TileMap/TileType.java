package it.unibo.oop18.cfc.TileMap;

public enum TileType {
    // tile Station
    CHOPPINGSTATION(1, 0), COOKER(2, 0), COUNTER(3, 0), DELIVERYSTATION(4, 0), FOODSTATION(5, 0), PLATESTATION(8, 0), TRASHCAN(6, 0), WASHBASIN(7, 0),

    //tile Floor
    PARQUETFLOOR(0, 1);

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
            if (t.getPos() == pos) {
                return t;
            }
        }
        return null;
    }
}
