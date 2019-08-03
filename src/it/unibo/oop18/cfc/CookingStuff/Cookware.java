package it.unibo.oop18.cfc.CookingStuff;

/**
 * an interface for cookaware stuff, like pan adn pots.
 *
 */
public interface Cookware {

    /**
     * @param ing : the ingredient you're about to add to the cookware. it also
     *             resets the ingredient to his CHOPPED state.
     */
    void add(Ingredient ing);

    /**
     * It starts or stops the cooking of the ingredients inside the pot.
     */
    void cook();

    /**
     * @return if the cookware is full.
     */
    boolean isFull();
}
