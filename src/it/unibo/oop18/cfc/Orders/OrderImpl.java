package it.unibo.oop18.cfc.Orders;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import it.unibo.oop18.cfc.Objects.Items.IngredientType;
import it.unibo.oop18.cfc.Objects.Items.OrderIngredient;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientState;
import it.unibo.oop18.cfc.Objects.Items.Plate;
import it.unibo.oop18.cfc.Util.Pair;

public class OrderImpl implements Order {
    
    private final static int TIMER_PERIOD = 1000;
	
    private final ArrayList<OrderIngredient> plate;
    private int points;
    private int slot; // 1 2 3 4
    private int countDownTime;
    private Timer countDownTimer;
    private final OrdersManager ordersManager;
    private final Order thisOrder;
	
    public OrderImpl(final OrdersManager ordersManager) {
        thisOrder = this;
        this.ordersManager = ordersManager;
        this.countDownTimer = new Timer();
	plate = new ArrayList<>();
    }

    @Override
    public boolean checkOrder(Plate plate) {
        // TODO Auto-generated method stub
	return false;
    }
    
    public int getPoints() {
        return points;
    }
    
    public void addIngredient(IngredientType ingredientType, IngredientState ingredientState) {
        if(plate.size()==4)
            throw new IllegalStateException();
        plate.add(new IngredientImpl(this.ordersManager.getWorld().getItemManager(), ingredientType, ingredientState));
    }
    
    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public void setCountDownTimer(int timeInSeconds) {
        this.countDownTime = timeInSeconds;
    }

    @Override
    public int getOrderIngredientQuantity() {
        return plate.size();
    }

    @Override
    public void draw(Graphics2D g) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void startOrder() {
        countDownTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                countDownTime--;
                if (countDownTime == 0) {
                    countDownTimer.cancel();
                    ordersManager.orderFailed(thisOrder);
                }
            }
        }, 0, TIMER_PERIOD);
    }

}
