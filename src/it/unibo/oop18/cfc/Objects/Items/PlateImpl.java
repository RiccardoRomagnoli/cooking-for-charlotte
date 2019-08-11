package it.unibo.oop18.cfc.object.items;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;

import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.util.CheckStatus;
import it.unibo.oop18.cfc.util.Position;

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
        if (this.ingredients.size() == 0) {
            g.drawImage(super.getItemManager().getPlateSprites().getPlateSprite().get(0).getImage(),AffineTransform
                    .getTranslateInstance(p.getX(), p.getY()), null);
        } else {
            g.drawImage(super.getItemManager().getPlateSprites().getPlateSprite().get(1).getImage(),AffineTransform
                    .getTranslateInstance(p.getX(), p.getY()), null);
        }

    }

    @Override
    public void draw(Graphics2D g, Position p, int width, int height) {
        if (this.ingredients.size() == 0) {
            g.drawImage(super.getItemManager().getPlateSprites().getPlateSprite().get(0).getImage().getScaledInstance(width,
                    height, Image.SCALE_SMOOTH), AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
        } else {
            g.drawImage(super.getItemManager().getPlateSprites().getPlateSprite().get(1).getImage().getScaledInstance(width,
                    height, Image.SCALE_SMOOTH), AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
        }
    }

    /**
     * Matches each order Ingredient to each plate ingredient 
     * if found a match removes the ingredients matched in the plate
     * if there is no match for just an order ingredient it fails directly
     * 
     * @param ingredientsList List of order ingredients
     */
    @Override
    public boolean checkIngredients(ArrayList<OrderIngredient> ingredientsList) {
        ArrayList<IngredientImpl> cloneIngredients = (ArrayList<IngredientImpl>) ingredients.clone();
        boolean found=false;
        int index = 0;
        int indexFound = 0;
        
        for(OrderIngredient orderIngredient : ingredientsList) {
            found=false;
            index = 0;
            indexFound = 0;
            for(Ingredient plateIngredient : cloneIngredients) {
                CheckStatus status = orderIngredient.checkIngredient(plateIngredient);
                if(status.equals(CheckStatus.ACCEPTABLE_WITH_ERROR) || 
                   status.equals(CheckStatus.ACCEPTABLE_WITHOUT_ERROR)) {
                    found = true;
                    indexFound = index;
                }
                index++;
            }
            cloneIngredients.remove(indexFound);
            if(!found)
                return false;
        }
        return true;
    }

    public void wash() {
        this.ingredients.clear();
    }
}