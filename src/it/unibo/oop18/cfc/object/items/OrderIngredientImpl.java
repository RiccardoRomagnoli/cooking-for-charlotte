package it.unibo.oop18.cfc.object.items;

import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.util.CheckStatus;

/**
 * the class OrderIngredientImpl.
 */
public class OrderIngredientImpl extends IngredientImpl implements OrderIngredient {

    private final IngredientType type;
    private IngredientState state;

    /**
     * Instantiates a new {@link OrderIngredientImpl}.
     *
     * @param itemManager the {@link ItemManager} to get the sprites
     * @param type        the {@link IngredientType}
     */
    public OrderIngredientImpl(final ItemManager itemManager, final IngredientType type) {
        super(itemManager, type);
        this.type = type;
    }

    /**
     * Instantiates a new {@link OrderIngredientImpl}.
     *
     * @param itemManager the {@link ItemManager} to get the sprites
     * @param type        the {@link IngredientType}
     * @param state       the {@link IngredientState}
     */
    public OrderIngredientImpl(final ItemManager itemManager, final IngredientType type, final IngredientState state) {
        super(itemManager, type, state);
        this.type = type;
        this.state = state;
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
