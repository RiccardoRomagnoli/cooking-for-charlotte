package it.unibo.oop18.cfc.cookingstuff;

import it.unibo.oop18.cfc.object.Items.IngredientState;

/*import java.util.Timer;
import java.util.TimerTask;
*/

/**
 * the main part of each dish, it gives access to all the primary informations
 * and is possible to change them to make the game harder.
 */
public class Ingredient {

    private static final int TIME_TO_CHOP = 2;
    private String name;

    /*
     * private long startTime; private long endTime;
     */
    private long timeToCook;
    private long timeToBurn;
    private int pointsValue;
    private boolean rawGood; // if an ingredient must not be cooked
    private IngredientState state;
    /*
     * private boolean cooking; private boolean chopping;
     */
    private int choppingTime;

    // timer section
    /*
     * Timer timer = new Timer(); TimerTask task = new TimerTask() {
     * 
     * @Override public void run() { // TODO Auto-generated method stub
     * 
     * } };
     */

    public Ingredient(final String name, final int pointsValue, final long timeToCook) {
        this.name = name;
        this.pointsValue = pointsValue;
        this.timeToCook = timeToCook / 3 + timeToCook;
        this.timeToBurn = timeToCook + timeToCook / 2;
        this.state = IngredientState.RAW;
    }

    public Ingredient(final String name, final int pointsValue) {
        this.name = name;
        this.pointsValue = pointsValue;
        this.rawGood = true;
        this.state = IngredientState.RAW;
    }

    protected int getPointsValue() {
        return pointsValue;
    }

    protected IngredientState getState() {
        return this.state;
    }

    protected void setPointsValue(final int pointsValue) {
        this.pointsValue = pointsValue;
    }

    protected long getTimeToCook() {
        return timeToCook;
    }

    protected void setTimeToCook(final int timeToCook) {
        this.timeToCook = timeToCook;
    }

    protected long getTimeToChop() {
        return this.TIME_TO_CHOP;
    }

    protected long getTimeToBurn() {
        return this.timeToBurn;
    }

    protected void changeState(IngredientState newState) {
        this.state = newState;
    }

    protected boolean isRawGood() {
        return this.rawGood;
    }

    protected boolean isReady() {
        if (this.state == IngredientState.CHOPPED) {
            if (isRawGood()) {
                return true;
            }
            if (this.state != IngredientState.RAW) {
                return true;
            }
        }
        return false;
    }

    protected void restartCooking() {
        this.state = IngredientState.CHOPPED;
    }

}
