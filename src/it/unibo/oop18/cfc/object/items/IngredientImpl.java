package it.unibo.oop18.cfc.object.items;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.util.CheckStatus;
import it.unibo.oop18.cfc.util.Position;

/**
 * The Class IngredientImpl.
 */
public class IngredientImpl extends AbstractItem implements Ingredient, OrderIngredient {

    private final IngredientType type;
    private IngredientState state;

    /**
     * Instantiates a new {@link IngredientImpl}.
     *
     * @param itemManager the {@link ItemManager} to get the sprites
     * @param type        the {@link IngredientType}
     */
    public IngredientImpl(final ItemManager itemManager, final IngredientType type) {
        super(itemManager);
        this.type = type;
        this.state = IngredientState.RAW;
    }

    /**
     * Instantiates a new ingredient impl.
     *
     * @param itemManager the {@link ItemManager} to get the sprites
     * @param type        the {@link IngredientType}
     * @param state       the {@link IngredientState}
     */
    public IngredientImpl(final ItemManager itemManager, final IngredientType type, final IngredientState state) {
        super(itemManager);
        this.type = type;
        this.state = state;
    }

    /**
     * {@inheritDoc}
     */
    public IngredientType getIngredient() {
        return this.type;
    }

    /**
     * {@inheritDoc}
     */
    public IngredientState getState() {
        return this.state;
    }

    /**
     * {@inheritDoc}
     */
    public void changeState(final IngredientState state) {
        this.state = state;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isReady() {
        if (this.state != IngredientState.RAW) {
            if (this.state == IngredientState.CHOPPED) {
                return this.type.getTimeToCook() == 0 ? true : false;
            }
            if (this.state != IngredientState.WASTE) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g, final Position p) {
        g.drawImage(super.getItemManager().getFoodSprites().getIngredientSprite().get(type.getX()).get(state.getX())
                .getImage(), AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g, final Position p, final int width, final int height) {
        g.drawImage(
                super.getItemManager().getFoodSprites().getIngredientSprite().get(type.getX()).get(state.getX())
                        .getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH),
                AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void drawState(final Graphics2D g, final Position p, final int width, final int height) {
        switch (state) {
        case CHOPPED:
            g.drawImage(
                    super.getItemManager().getFoodSprites().getStateSprite().get(0).getImage().getScaledInstance(width,
                            height, Image.SCALE_SMOOTH),
                    AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
            break;
        case PERFECT:
            g.drawImage(
                    super.getItemManager().getFoodSprites().getStateSprite().get(1).getImage().getScaledInstance(width,
                            height, Image.SCALE_SMOOTH),
                    AffineTransform.getTranslateInstance(p.getX(), p.getY()), null);
            break;
        default:
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    public CheckStatus checkIngredient(final Ingredient ingredient) {
        CheckStatus returnStatus = CheckStatus.NOT_ACCEPTABLE;
        if (ingredient.getIngredient().equals(this.type) && ingredient.getState().equals(this.state)) {
            returnStatus = CheckStatus.ACCEPTABLE_WITHOUT_ERROR;
        } else if (ingredient.getIngredient().equals(this.type)
                && ingredient.getState().equals(IngredientState.BURNED)) {
            returnStatus = CheckStatus.ACCEPTABLE_WITH_ERROR;
        }
        return returnStatus;
    }
}
