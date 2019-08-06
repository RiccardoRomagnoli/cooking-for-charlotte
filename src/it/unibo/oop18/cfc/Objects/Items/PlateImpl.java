package it.unibo.oop18.cfc.Objects.Items;

import java.util.ArrayList;

public class PlateImpl extends AbstractItem implements Plate {

    private ArrayList<IngredientImpl> ingredients;
    private int points;

    public PlateImpl() {
        super();
        ingredients = new ArrayList<IngredientImpl>();
        this.points = 0;
    }

    public void addDish(IngredientImpl ing) {
        ingredients.add(ing);
    }

    public IngredientImpl getDish(int pos) {
        return ingredients.get(pos);
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
        for (IngredientImpl i : ingredients) {
            updatePoints(i.getIngredient().getPoints());
            if (i.isReady()) { 
                counter++; 
            }    
        }
        if (counter == max) {
            return true;
        }
        return false;
    }
}
