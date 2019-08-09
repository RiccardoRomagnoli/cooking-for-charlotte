package it.unibo.oop18.cfc.Objects.Items;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;

import it.unibo.oop18.cfc.Manager.ItemManager;
import it.unibo.oop18.cfc.Util.CheckStatus;
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
        g.drawImage(super.getItemManager().getPlateSprites().getPlateSprite().get(0).getImage(),AffineTransform
                .getTranslateInstance(p.getX(), p.getY()), null);
    }

    @Override
    public void draw(Graphics2D g, Position p, int width, int height) {
        g.drawImage(super.getItemManager().getPlateSprites().getPlateSprite().get(0).getImage().getScaledInstance(width,
                height, Image.SCALE_SMOOTH), AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
    }
    
    @Override
    public boolean checkIngredients(ArrayList<OrderIngredient> ingredientsList) {
        ArrayList<IngredientImpl> cloneIngredients = (ArrayList<IngredientImpl>) ingredients.clone();
        boolean ret = true;
        boolean found = false;
        int cont = 0;
        for(OrderIngredient orderIngredient : ingredientsList) {
            while(!found && cloneIngredients.size()>0) {
                Ingredient plateIngredient = cloneIngredients.get(cont);
                CheckStatus status = orderIngredient.checkIngredient(plateIngredient);
                if(status.equals(CheckStatus.NOT_ACCEPTABLE)) {
                    ret = false;
                    cont++;
                }
                if(status.equals(CheckStatus.ACCEPTABLE_WITH_ERROR) || 
                   status.equals(CheckStatus.ACCEPTABLE_WITHOUT_ERROR)) {
                    found = true;
                    cloneIngredients.remove(cont);
                }
            }
            found = false;
            cont = 0;
        }
        return ret;
    }

    public void wash() {
        this.ingredients.clear();
    }
}
