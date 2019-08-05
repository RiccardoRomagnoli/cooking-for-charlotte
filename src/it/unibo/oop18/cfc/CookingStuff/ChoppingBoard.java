package it.unibo.oop18.cfc.CookingStuff;

import java.util.Timer;
import java.util.TimerTask;

import it.unibo.oop18.cfc.Objects.Items.IngredientState;

public class ChoppingBoard {

    private boolean chopping;
    private long startChopping;
    private long endChopping;
    private long choppedTime;

    private void chop(Ingredient ing) {
        if (ing.getState() == IngredientState.RAW) {
            this.chopping = !this.chopping;
            if (this.chopping) {
                this.startChopping = System.nanoTime();
            } else {
                this.endChopping = System.nanoTime();
                long passedTime = endChopping - startChopping;
                this.choppedTime += passedTime;
                if (this.choppedTime >= ing.getTimeToChop()) {
                    ing.changeState(IngredientState.CHOPPED);
                }
            }
        }
    }
}
