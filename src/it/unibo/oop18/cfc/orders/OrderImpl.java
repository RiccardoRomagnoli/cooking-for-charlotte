package it.unibo.oop18.cfc.orders;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.OrderGraphicComponent;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.IngredientState;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.object.items.OrderIngredient;
import it.unibo.oop18.cfc.object.items.Plate;

/**
* The Class OrderImpl.
*/
public class OrderImpl implements Order {

    private static final  int TIMER_PERIOD = 1000;

    private final List<OrderIngredient> ingredientsList;
    private int slot;
    private boolean paused;
    private int countDownTime;
    private Timer countDownTimer;
    private final OrdersManager ordersManager;
    private final Order thisOrder;
    private final GraphicsComponent graphicComponent;

    /**
     * @param ordersManager OrderManager
     */
    public OrderImpl(final OrdersManager ordersManager) {
        this.paused = false;
        thisOrder = this;
        this.ordersManager = ordersManager;
        this.countDownTimer = new Timer();
        this.ingredientsList = new ArrayList<>();
        this.graphicComponent = new OrderGraphicComponent(this);
    }

    /**
    * {@inheritDoc}
    */
    public boolean checkOrder(final Plate plate) {
        return plate.checkIngredients(this.ingredientsList);
    }

    /**
    * {@inheritDoc}
    */
    public void addIngredient(final IngredientType ingredientType, final IngredientState ingredientState) {
        if (ingredientsList.size() == 4) {
            throw new IllegalStateException();

        }
        ingredientsList.add(
                new IngredientImpl(this.ordersManager.getWorld().getItemManager(), ingredientType, ingredientState));
    }

    /**
    * {@inheritDoc}
    */
    public void setSlot(final int slot) {
        this.slot = slot;
    }

    /**
    * {@inheritDoc}
    */
    public int getSlot() {
        return this.slot;
    }

    /**
    * {@inheritDoc}
    */
    public void setCountDownTimer(final int timeInSeconds) {
        this.countDownTime = timeInSeconds;
        this.ordersManager.getCurrentOrders().sort((o1, o2) -> o1.getCountDownTime() - o2.getCountDownTime());
    }

    /**
    * {@inheritDoc}
    */
    public int getCountDownTime() {
        return countDownTime;
    }

    /**
    * {@inheritDoc}
    */
    public int getOrderIngredientQuantity() {
        return ingredientsList.size();
    }

    /**
    * {@inheritDoc}
    */
    public List<OrderIngredient> getIngredientsList() {
        return ingredientsList;
    }

    /**
    * {@inheritDoc}
    */
    public void startOrder() {
        this.countDownTimer = new Timer();
        countDownTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!paused) {
                    countDownTime--;
                    if (countDownTime == 0) {
                        countDownTimer.cancel();
                        ordersManager.orderFailed(thisOrder);
                    }
                }
            }
        }, 0, TIMER_PERIOD);
    }

    /**
    * {@inheritDoc}
    */
    public void stopOrder() {
        countDownTimer.cancel();
        countDownTimer.purge();
    }

    /**
    * {@inheritDoc}
    */
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    /**
    * {@inheritDoc}
    */
    public void setPaused(final boolean paused) {
        this.paused = paused;
    }

}
