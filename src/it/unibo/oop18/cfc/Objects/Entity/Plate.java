package it.unibo.oop18.cfc.Objects.Entity;

public interface Plate {
    public void addDish(DishImpl d);

    public DishImpl getDish(int pos);
}
