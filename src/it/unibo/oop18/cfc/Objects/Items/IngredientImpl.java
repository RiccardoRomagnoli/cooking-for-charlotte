package it.unibo.oop18.cfc.Objects.Items;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Util.Position;

public class IngredientImpl extends AbstractItem implements Ingredient {

    private IngredientType type;
    private IngredientState state;

    public IngredientImpl(final Position position, final IngredientType type) {
        super(position);
        this.type = type;
        this.state = IngredientState.RAW;
    }

    public IngredientType getFood() {
        return this.type;
    }
    public IngredientState getState() {
        return this.state;
    }
    public void changeState(IngredientState state){
        this.state = state;
    }
    @Override
    public void draw(final Graphics2D g) {
        // TODO Auto-generated method stub
    }

}
