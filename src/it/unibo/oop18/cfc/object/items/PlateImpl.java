package it.unibo.oop18.cfc.object.items;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.util.CheckStatus;
import it.unibo.oop18.cfc.util.Position;

public class PlateImpl extends AbstractItem implements Plate {

    final private ArrayList<IngredientImpl> ingredients;
    private int points;

    public PlateImpl(final ItemManager itemManager) {
        super(itemManager);
        ingredients = new ArrayList<IngredientImpl>();
        this.points = 0;
    }

    public void addDish(final IngredientImpl ing) {
        ingredients.add(ing);
    }

    public IngredientImpl getIngredient(final int pos) {
        return ingredients.get(pos);
    }

    private void updatePoints(final int points) {
        this.setPoints(this.getPoints() + points);
    }

    /**
     * TODO. Add method description
     * 
     * @return true if it's ready, or viceversa
     */
    public boolean checkReady() {
        final int max = ingredients.size();
        int counter = 0;
        this.setPoints(0);
        for (final IngredientImpl i : ingredients) {
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
    public void draw(final Graphics2D g, final Position p) {
        if (this.ingredients.size() == 0) {
            g.drawImage(super.getItemManager().getPlateSprites().getPlateSprite().get(0).getImage(),
                    AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
        } else {
            g.drawImage(super.getItemManager().getPlateSprites().getPlateSprite().get(1).getImage(),
                    AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
        }

    }

    @Override
    public void draw(final Graphics2D g, final Position p, final int width, final int height) {
        if (this.ingredients.size() == 0) {
            g.drawImage(
                    super.getItemManager().getPlateSprites().getPlateSprite().get(0).getImage().getScaledInstance(width,
                            height, Image.SCALE_SMOOTH),
                    AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
        } else {
            g.drawImage(
                    super.getItemManager().getPlateSprites().getPlateSprite().get(1).getImage().getScaledInstance(width,
                            height, Image.SCALE_SMOOTH),
                    AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
        }
    }

    /**
     * Matches each order Ingredient to each plate ingredient if found a match
     * removes the ingredients matched in the plate if there is no match for just an
     * order ingredient it fails directly
     * 
     * @param ingredientsList List of order ingredients
     */
    @Override
    public boolean checkIngredients(final ArrayList<OrderIngredient> ingredientsList) {
        final List<IngredientImpl> cloneIngredients = (ArrayList<IngredientImpl>) ingredients.clone();
        boolean found = false;
        int index = 0;
        int indexFound = 0;

        for (final OrderIngredient orderIngredient : ingredientsList) {
            found = false;
            index = 0;
            indexFound = 0;
            for (final Ingredient plateIngredient : cloneIngredients) {
                final CheckStatus status = orderIngredient.checkIngredient(plateIngredient);
                if (status.equals(CheckStatus.ACCEPTABLE_WITH_ERROR)
                        || status.equals(CheckStatus.ACCEPTABLE_WITHOUT_ERROR)) {
                    found = true;
                    indexFound = index;
                }
                index++;
            }
            /**
             * TODO. Qua tira una bella eccezzione.......... :)
             */
            cloneIngredients.remove(indexFound);
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public void wash() {
        this.ingredients.clear();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
