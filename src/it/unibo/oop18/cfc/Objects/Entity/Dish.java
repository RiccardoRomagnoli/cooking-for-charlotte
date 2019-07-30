package it.unibo.oop18.cfc.Objects.Entity;

public interface Dish {
    public Food getFood();

    public boolean isCooked();

    public void setCooked(boolean isCooked);

    public boolean isCut();

    public void setCut(boolean isCut);
}
