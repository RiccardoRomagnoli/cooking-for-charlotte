package it.unibo.oop18.cfc.orders;

public enum OrderDifficulty {

    /**
     * First Param : numeber of Ingredients Second Param : time delay;
     */
    EASY(2, 45), MEDIUM(3, 60), HARD(4, 90), EXTREME(4, 80);

    private int numberOfIngredients;
    private int secondsOfCountDown;

    public int getNumberOfIngredients() {
        return this.numberOfIngredients;
    }

    public int getSecondsOfConutDown() {
        return this.secondsOfCountDown;
    }

    OrderDifficulty(final int numberOfIngredients, final int secondsOfCountDown) {
        this.numberOfIngredients = numberOfIngredients;
        this.secondsOfCountDown = secondsOfCountDown;
    }

}
