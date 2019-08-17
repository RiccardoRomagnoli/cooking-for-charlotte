package it.unibo.oop18.cfc.object.items;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.util.CheckStatus;
import it.unibo.oop18.cfc.util.Position;

/**
 * The Class PlateImpl.
 */
public class PlateImpl extends AbstractItem implements Plate {

    private final List<IngredientImpl> ingredients;
    private int points;
    private static final int INGREDIENTS_WIDTH = 15;
    private static final int INGREDIENTS_HEIGHT = 15;

    /**
     * Instantiates a new plate impl.
     *
     * @param itemManager the {@link ItemManager} to get the sprites
     */
    public PlateImpl(final ItemManager itemManager) {
        super(itemManager);
        ingredients = new ArrayList<IngredientImpl>();
        this.points = 0;
    }

    /**
     * {@inheritDoc}
     */
    public void addIngredient(final IngredientImpl ing) {
        ingredients.add(ing);
        updatePoints(ing.getState().getPoints());
    }

    /**
     * {@inheritDoc}
     */
    public IngredientImpl getIngredient(final int pos) {
        return ingredients.get(pos);
    }

    /**
     * {@inheritDoc}
     */
    public boolean checkReady() {
        final int max = ingredients.size();
        int counter = 0;
        this.points = 0;
        for (final IngredientImpl i : ingredients) {
            if (i.isReady()) {
                counter++;
            }
        }
        return counter == max ? true : false;
    }

    /**
     * {@inheritDoc}
     */
    public List<IngredientImpl> getIngredients() {
        return this.ingredients;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g, final Position p) {
        g.drawImage(super.getItemManager().getPlateSprites().getPlateSprite().get(0).getImage(),
                AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g, final Position p, final int width, final int height) {
        g.drawImage(super.getItemManager().getPlateSprites().getPlateSprite().get(0).getImage().getScaledInstance(width,
                height, Image.SCALE_SMOOTH), AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
    }

    /**
     * {@inheritDoc}
     */
    public void drawWithIngredients(final Graphics2D g, final Position p, final int width, final int height) {
        g.drawImage(super.getItemManager().getPlateSprites().getPlateSprite().get(0).getImage().getScaledInstance(width,
                height, Image.SCALE_SMOOTH), AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
        IntStream.range(0, ingredients.size()).forEach(a -> ingredients.get(a).draw(g,
                new Position(p.getX() + ((a % 2) * INGREDIENTS_WIDTH), p.getY() + ((a / 2) * INGREDIENTS_HEIGHT)),
                INGREDIENTS_WIDTH, INGREDIENTS_HEIGHT));
    }

    /**
     * {@inheritDoc}
     */
    public boolean checkIngredients(final List<OrderIngredient> ingredientsList) {
        final List<IngredientImpl> cloneIngredients = new ArrayList<IngredientImpl>(ingredients);
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
            if (found) {
                cloneIngredients.remove(indexFound);
            } else {
                return false;
            }
        }

        return cloneIngredients.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    public void wash() {
        this.ingredients.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPoints() {
        return points;
    }

    private void updatePoints(final int points) {
        this.points += points;
    }

}
