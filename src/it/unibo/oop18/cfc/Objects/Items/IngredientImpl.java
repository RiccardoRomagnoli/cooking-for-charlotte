package it.unibo.oop18.cfc.Objects.Items;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Manager.ItemManager;
import it.unibo.oop18.cfc.Util.CheckStatus;
import it.unibo.oop18.cfc.Util.Position;

public class IngredientImpl extends AbstractItem implements Ingredient, OrderIngredient {

    private IngredientType type;
    private IngredientState state;

    public IngredientImpl(final ItemManager itemManager, final IngredientType type) {
        super(itemManager);
        this.type = type;
        this.state = IngredientState.RAW;
    }
    
    public IngredientImpl(final ItemManager itemManager, final IngredientType type, final IngredientState state) {
        super(itemManager);
        this.type = type;
        this.state = state;
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
    public void draw(final Graphics2D g, final Position p) {
        g.drawImage(super.getItemManager().getFoodSprites().getIngredientSprite().get(type.getX()).get(state.getX()).getImage(),
            AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
    }

    @Override
    public void draw(final Graphics2D g, final Position p, final int width, final int height) {
        g.drawImage(
                super.getItemManager().getFoodSprites().getIngredientSprite().get(type.getX()).get(state.getX())
                        .getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH),
                AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
    }

    @Override
    public void drawState(final Graphics2D g, final Position p) {
        switch (state) {
        case CHOPPED:
            g.drawImage(super.getItemManager().getFoodSprites().getStateSprite().get(0).getImage(),
                    AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
            break;
        case PERFECT:
            g.drawImage(super.getItemManager().getFoodSprites().getStateSprite().get(1).getImage(),
                    AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
            break;
        default:
            break;
        }
    }

    @Override
    public CheckStatus checkIngredient(Ingredient ingredient) {
        CheckStatus returnStatus = CheckStatus.NOT_ACCEPTABLE;
        if(ingredient.getIngredient().equals(this.type)) {
            returnStatus = CheckStatus.ACCEPTABLE_WITH_ERROR;
        }else if(ingredient.getIngredient().equals(this.type) && 
                 ingredient.getState().equals(this.state)) {
            returnStatus = CheckStatus.ACCEPTABLE_WITHOUT_ERROR;
        }
        return returnStatus;
    }
}
