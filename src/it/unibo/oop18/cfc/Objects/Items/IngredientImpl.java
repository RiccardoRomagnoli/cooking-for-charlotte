package it.unibo.oop18.cfc.Objects.Items;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Manager.ItemManager;
import it.unibo.oop18.cfc.Util.Position;

public class IngredientImpl extends AbstractItem implements Ingredient {

    private IngredientType type;
    private IngredientState state;

    public IngredientImpl(final ItemManager itemManager, final IngredientType type) {
        super(itemManager);
        this.type = type;
        this.state = IngredientState.RAW;
    }

    public IngredientType getIngredient() {
        return this.type;
    }
    public IngredientState getState() {
        return this.state;
    }
    public void changeState(IngredientState state){
        this.state = state;
    }
    public boolean isReady() {
        if (this.state != IngredientState.RAW) {
            if (this.state == IngredientState.CHOPPED) {
                if (this.type.getTimeToCook() == 0) {
                    return true;
                }
                return false;
            }
            if (this.state != IngredientState.WASTE) {
                return true;
            }
        } 
        return false;
    }

    @Override
    public void draw(Graphics2D g, Position p) {
        g.drawImage(super.getItemManager().getFoodSprites().getIngredientSprite().get(type.getX()).get(state.getX()).getImage()
            .getScaledInstance(20, 20, Image.SCALE_SMOOTH),
            AffineTransform.getTranslateInstance(p.getX() + 20, p.getY() + 5), null);
    }
}
