package it.unibo.oop18.cfc.Objects.Items;

public enum IngredientState {

    /**
     * the ingredient as you pick it up.
     */
    RAW,

    /**
     * the ingredient after being chopped.
     */
    CHOPPED,

    /**
     * the ingredient perfectly cooked.
     */
    PERFECT,

    /**
     * the ingredient is overcooked, so burned but still edible.
     */
    BURNED,

    /**
     * the ingredient is dangerous to eat, unusable.
     */
    WASTE;
}
