package it.unibo.oop18.cfc.Objects.Entity;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import it.unibo.oop18.cfc.Manager.Content;

public class PlateImpl extends ItemImpl implements Plate {

    private ArrayList<DishImpl> dishes;
    private Player p;

    public PlateImpl(final Player p) {
        super(Content.FOOD[0][2]);
        this.p = p;
        dishes = new ArrayList<DishImpl>();
    }

    public void addDish(DishImpl d) {
        dishes.add(d);
    }

    public DishImpl getDish(int pos) {
        return dishes.get(pos);
    }
}
