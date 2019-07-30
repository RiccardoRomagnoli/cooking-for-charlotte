package it.unibo.oop18.cfc.Objects.Items;

public enum Food {
    TOMATO(4, 0),
    MEAT(2, 5),
    SALAD(7, 0),
    BREAD(3, 2);

    private int x;
    private int y;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    private Food(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
