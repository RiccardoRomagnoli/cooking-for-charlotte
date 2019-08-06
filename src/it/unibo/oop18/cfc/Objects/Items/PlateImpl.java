package it.unibo.oop18.cfc.Objects.Items;

import java.util.ArrayList;

public class PlateImpl extends AbstractItem implements Plate {

    private ArrayList<IngredientImpl> dishes;

    public PlateImpl() {
        super();
        dishes = new ArrayList<IngredientImpl>();
    }

    public void addDish(IngredientImpl d) {
        dishes.add(d);
    }

    public IngredientImpl getDish(int pos) {
        return dishes.get(pos);
    }
}
