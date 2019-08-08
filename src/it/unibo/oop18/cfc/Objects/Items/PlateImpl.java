package it.unibo.oop18.cfc.Objects.Items;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import it.unibo.oop18.cfc.Manager.ItemManager;
import it.unibo.oop18.cfc.Util.Position;

public class PlateImpl extends AbstractItem implements Plate {

    private ArrayList<IngredientImpl> ingredients;
    private int points;

    public PlateImpl(final ItemManager itemManager) {
        super(itemManager);
        ingredients = new ArrayList<IngredientImpl>();
        this.points = 0;
    }

    public void addDish(IngredientImpl ing) {
        ingredients.add(ing);
    }

    public IngredientImpl getIngredient(int pos) {
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

    @Override
    public ArrayList<IngredientImpl> getIngredients() {
        return this.ingredients;
    }

    @Override
    public void draw(Graphics2D g, Position p) {
        g.drawImage(super.getItemManager().getPlateSprites().getItemSprite().get(0).getImage(),AffineTransform
                .getTranslateInstance(p.getX(), p.getY()), null);
    }
}
