package it.unibo.oop18.cfc.object.items;

/**
 * The Enum IngredientType.
 */
public enum IngredientType {

    /** The tomato. */
    TOMATO(3, 0, 2, 0),
    /** The lettuce. */
    LETTUCE(2, 0, 2, 0),
    /** The bread. */
    BREAD(0, 2, 1, 0),
    /** The meat. */
    MEAT(1, 5, 2, 10);

    private int x;
    private int y;
    private int timeToCut;
    private int timeToCook;

    IngredientType(final int x, final int y, final int timeToCut, final int timeToCook) {
        this.x = x;
        this.y = y;
        this.timeToCut = timeToCut;
        this.timeToCook = timeToCook;
    }

    /**
     * Gets the x position on the sheet.
     *
     * @return the x value of the ingredient
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the y position on the sheet.
     *
     * @return the y value of the ingredient
     */
    public int getY() {
        return this.y;
    }
    /**
     * Gets the time to cut.
     *
     * @return the time needed to cut the ingredient
     */
    public int getTimeToCut() {
        return this.timeToCut;
    }

    /**
     * Gets the time to cook.
     *
     * @return the time needed to cook the ingredient
     */
    public int getTimeToCook() {
        return this.timeToCook;
    }

}
