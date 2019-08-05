package it.unibo.oop18.cfc.Objects.Items;

public interface Ingredient {
    public IngredientType getFood();

    public boolean isCooked();

    public void setCooked(boolean isCooked);

    public boolean isCut();

    public void setCut(boolean isCut);
}
