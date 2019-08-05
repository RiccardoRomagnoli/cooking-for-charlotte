package it.unibo.oop18.cfc.Objects.Items;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Util.Position;

public class IngredientImpl extends AbstractItem implements Ingredient {

    private IngredientType f;
    private boolean isCooked;
    private boolean isCut;

    public IngredientImpl(final Position position) {
        super(position);
        this.isCut = false;
        this.isCooked = false;
    }

    public IngredientType getFood() {
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

    @Override
    public void draw(Graphics2D g) {
        // TODO Auto-generated method stub
        
    }

}
