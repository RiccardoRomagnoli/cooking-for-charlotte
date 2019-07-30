package it.unibo.oop18.cfc.Objects.Entity;

import java.awt.image.BufferedImage;

import it.unibo.oop18.cfc.Manager.Content;

public class DishImpl extends ItemImpl implements Dish {

    private Food f;
    private boolean isCooked;
    private boolean isCut;

    public DishImpl(Food f) {
        super(Content.FOOD[f.getX()][f.getY()]);
        this.f = f;
        this.isCut = false;
        this.isCooked = false;
    }

    public Food getFood() {
        return f;
    }

    public boolean isCooked() {
        return isCooked;
    }

    public void setCooked(boolean isCooked) {
        this.isCooked = isCooked;
    }

    public boolean isCut() {
        return isCut;
    }

    public void setCut(boolean isCut) {
        this.isCut = isCut;
    }

}
