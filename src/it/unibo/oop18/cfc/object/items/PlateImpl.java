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

    private List<IngredientImpl> ingredients;
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
        this.points += points;
    }

    /**
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
        return counter == max ? true : false;
    }

    @Override
    public List<IngredientImpl> getIngredients() {
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
     * order ingredient it fails directly.
     * 
     * @param ingredientsList List of order ingredients
     */
    @Override
    public boolean checkIngredients(final List<OrderIngredient> ingredientsList) {
        List<IngredientImpl> cloneIngredients = new ArrayList<IngredientImpl>(ingredients);
        boolean found = false;
        int index = 0;
        int indexFound = 0;

        for (OrderIngredient orderIngredient : ingredientsList) {
            found = false;
            index = 0;
            indexFound = 0;
            for (Ingredient plateIngredient : cloneIngredients) {
                CheckStatus status = orderIngredient.checkIngredient(plateIngredient);
                if (status.equals(CheckStatus.ACCEPTABLE_WITH_ERROR)
                        || status.equals(CheckStatus.ACCEPTABLE_WITHOUT_ERROR)) {
                    found = true;
                    indexFound = index;
                }
                index++;
            }
            if (found) {
                cloneIngredients.remove(indexFound);
            } else {
                return false;
            }
        }
        return true;
    }

    public void wash() {
        this.ingredients.clear();
    }
}
