package it.unibo.oop18.cfc.cookingstuff;

import java.util.List;

/**
 * Dish manage and setting.
 * 
 */
public class Dish {

    private final String name;
    private final List<Ingredient> ingredients;
    private int points;

    /**
     * 
     * @param name        the name of the dish
     * @param ingredients the ingredients of which the dish is composed Dish
     *                    constructor.
     */
    public Dish(final String name, final List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
        this.points = 0;
    }

    private void updatePoints(final int points) {
        this.points += points;
    }

    /**
     * TODO. Add method description
     * 
     * @return true if it's ready, or viceversa
     */
    public boolean checkReady() {
        final int max = ingredients.size();
        int counter = 0;
        this.points = 0;
        for (Ingredient i : ingredients) {
            updatePoints(i.getPointsValue());
            if (i.isReady()) {
                counter++;
            }
        }
        if (counter == max) {
            return true;
        }
        return false;
    }

    /**
     * Get the name of the dish.
     * 
     * @return name of the dish
     */
    public String getDishName() {
        return name;
    }

}