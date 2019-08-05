package it.unibo.oop18.cfc.Objects.Items;

public enum IngredientType {
    TOMATO(4, 0, 200, 2, 0),
    LATTUCE(7, 0, 200, 2, 0),
    BREAD(3, 2, 200, 1, 0),
    MEAT(2, 5, 500, 2, 6);

    private int x;
    private int y;
    private int pointValue;
    private int timeToCut;
    private int timeToCook;
    private IngredientState state;

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getPoints() {
        return this.pointValue;
    }
    public int getTimeToCut() {
        return this.timeToCut;
    }
    public int getTimeToCook() {
        return this.timeToCook;
    }
    public IngredientState getState() {
        return this.state;
    }
    IngredientType(final int x, final int y, final int pointValue, final int timeToCut, final int timeToCook) {
        this.x = x;
        this.y = y;
        this.pointValue = pointValue;
        this.timeToCut = timeToCut;
        this.timeToCook = timeToCook;
        this.state = IngredientState.RAW;
    }
}
