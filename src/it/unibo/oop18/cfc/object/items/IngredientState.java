package it.unibo.oop18.cfc.object.items;

/**
 * The Enum IngredientState.
 */
public enum IngredientState {

    /**
     * the ingredient as you pick it up.
     */
    RAW(0, 0),

    /**
     * the ingredient after being chopped.
     */
    CHOPPED(1, 10),

    /**
     * the ingredient perfectly cooked.
     */
    PERFECT(2, 15),

    /**
     * the ingredient is overcooked, so burned but still edible.
     */
    BURNED(3, 5),

    /**
     * the ingredient is dangerous to eat, unusable.
     */
    WASTE(4, 0);

    private int x;
    private int points;

    IngredientState(final int x, final int points) {
        this.x = x;
        this.points = points;
    }

    /**
     * Gets the x position in the sheet.
     *
     * @return the x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the points based on Ingredient State.
     * 
     * @return points state points
     */
    public int getPoints() {
        return this.points;
    }

}
