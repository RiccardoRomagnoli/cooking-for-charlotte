package it.unibo.oop18.cfc.object.items;

/**
 * The Enum IngredientType.
 */
public enum IngredientType {

    /** The tomato. */
    TOMATO(3, 0, 200, 2, 0),
    /** The lettuce. */
    LETTUCE(2, 0, 200, 2, 0),
    /** The bread. */
    BREAD(0, 2, 200, 1, 0),
    /** The meat. */
    MEAT(1, 5, 500, 2, 6);

    private int x;
    private int y;
    private int pointValue;
    private int timeToCut;
    private int timeToCook;

    IngredientType(final int x, final int y, final int pointValue, final int timeToCut, final int timeToCook) {
        this.x = x;
        this.y = y;
        this.pointValue = pointValue;
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
     * Gets the value points.
     *
     * @return the value of the value of the ingredient
     */
    public int getPoints() {
        return this.pointValue;
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
