package it.unibo.oop18.cfc.Objects.Items;

public enum IngredientType {

    TOMATO(4, 0, 200, 2, 0),
    LETTUCE(7, 0, 200, 2, 0),
    BREAD(3, 2, 200, 1, 0),
    MEAT(2, 5, 500, 2, 6);

    private int x;
    private int y;
    private int pointValue;
    private int timeToCut;
    private int timeToCook;
    private IngredientState state;
    /** 
     * 
     * @return the x value of the ingredient
     */
    public int getX() {
        return this.x;
    }
    /**
     * 
     * @return the y value of the ingredient
     */
    public int getY() {
        return this.y;
    }
    /**
     * @return the value of the value of the ingredient
     */
    public int getPoints() {
        return this.pointValue;
    }

    /**
     * 
     * @return the time needed to cut the ingredient
     */
    public int getTimeToCut() {
        return this.timeToCut;
    }

    /**
     * 
     * @return the time needed to cook the ingredient
     */
    public int getTimeToCook() {
        return this.timeToCook;
    }
    IngredientType(final int x, final int y, final int pointValue, final int timeToCut, final int timeToCook) {
        this.x = x;
        this.y = y;
        this.pointValue = pointValue;
        this.timeToCut = timeToCut;
        this.timeToCook = timeToCook;
    }
}
