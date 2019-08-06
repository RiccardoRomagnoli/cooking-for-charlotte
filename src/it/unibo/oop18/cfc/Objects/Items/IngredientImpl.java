package it.unibo.oop18.cfc.Objects.Items;

public class IngredientImpl extends AbstractItem implements Ingredient {

    private IngredientType f;
    private boolean isCooked;
    private boolean isCut;

    public IngredientImpl(final IngredientType ingredientType) {
        super();
        this.isCut = false;
        this.isCooked = false;
        this.f = ingredientType;
    }

    public IngredientType getFood() {
        return f;
    }

    public boolean isCooked() {
        return isCooked;
    }

    public void setCooked(boolean isCooked) {
        this.isCooked = isCooked;
    }

    public boolean isCut() {
        return isCut;
    }

    public void setCut(boolean isCut) {
        this.isCut = isCut;
    }
}
