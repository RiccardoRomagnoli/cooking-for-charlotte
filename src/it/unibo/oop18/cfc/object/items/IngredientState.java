package it.unibo.oop18.cfc.object.items;

/**
 * The Enum IngredientState.
 */
public enum IngredientState {

    /**
     * the ingredient as you pick it up.
     */
    RAW(0),

    /**
     * the ingredient after being chopped.
     */
    CHOPPED(1),

    /**
     * the ingredient perfectly cooked.
     */
    PERFECT(2),

    /**
     * the ingredient is overcooked, so burned but still edible.
     */
    BURNED(3),

    /**
     * the ingredient is dangerous to eat, unusable.
     */
    WASTE(4);

    private int x;

    IngredientState(final int x) {
        this.x = x;
    }

    /**
     * Gets the x position in the sheet.
     *
     * @return the x
     */
    public int getX() {
        return this.x;
    }

}
