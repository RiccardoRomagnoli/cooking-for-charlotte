package it.unibo.oop18.cfc.tilemap;

/**
 * The Enum TileType.
 */
public enum TileType {

    /** The parquetfloor. */
    PARQUETLEFTFLOOR(0, 0),

    /** The parquetrightfloor. */
    PARQUETRIGHTFLOOR(1, 0),

    /** The choppingstation. */
    CHOPPINGSTATION(0, 1),

    /** The cooker. */
    COOKER(0, 2),

    /** The counter. */
    COUNTER(0, 3),

    /** The boardercounter. */
    BOARDERCOUNTER(1, 3),

    /** The edgecounter. */
    EDGECOUNTER(2, 3),

    /** The deliverystation. */
    DELIVERYSTATION(0, 4),

    /** The breadstation. */
    BREADSTATION(0, 5),

    /** The meatstation. */
    MEATSTATION(0, 6),

    /** The lettucestation. */
    LETTUCESTATION(0, 7),

    /** The tomatostation. */
    TOMATOSTATION(0, 8),

    /** The trashcan. */
    TRASHCAN(0, 9),

    /** The washbasin. */
    WASHBASIN(0, 10),

    /** The platestation. */
    PLATESTATION(0, 11);

    private int posY;
    private int posX;

    /**
     * Instantiates a new tile type.
     *
     * @param pos the pos
     */
    TileType(final int posX, final int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * Gets the pos.
     *
     * @return the pos
     */
    public int getPosX() {
        return this.posX;
    }

    /**
     * Gets the pos.
     *
     * @return the pos
     */
    public int getPosY() {
        return this.posY;
    }

}
