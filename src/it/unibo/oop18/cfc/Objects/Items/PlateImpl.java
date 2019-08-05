package it.unibo.oop18.cfc.Objects.Items;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Objects.Entity.Player;
import it.unibo.oop18.cfc.Util.Position;

public class PlateImpl extends AbstractItem implements Plate {

    private ArrayList<IngredientImpl> dishes;

    public PlateImpl(final Position position) {
        super(position);
        dishes = new ArrayList<IngredientImpl>();
    }

    public void addDish(IngredientImpl d) {
        dishes.add(d);
    }

    public IngredientImpl getDish(int pos) {
        return dishes.get(pos);
    }

    @Override
    public void draw(Graphics2D g) {
        // TODO Auto-generated method stub
        
    }
}
