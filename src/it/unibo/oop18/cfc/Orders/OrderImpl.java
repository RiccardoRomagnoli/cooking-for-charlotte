package it.unibo.oop18.cfc.Orders;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import it.unibo.oop18.cfc.Objects.Items.IngredientType;
import it.unibo.oop18.cfc.Objects.Items.OrderIngredient;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Graphics.OrderGraphicComponent;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientState;
import it.unibo.oop18.cfc.Objects.Items.Plate;
import it.unibo.oop18.cfc.Util.Pair;

public class OrderImpl implements Order {

    private final static int TIMER_PERIOD = 1000;

    private final ArrayList<OrderIngredient> ingredientsList;
    private int points;
    private int slot; // 1 2 3 4
    private int countDownTime;
    private Timer countDownTimer;
    private final OrdersManager ordersManager;
    private final Order thisOrder;
    private final GraphicsComponent graphicComponent;
	
    public OrderImpl(final OrdersManager ordersManager) {
        thisOrder = this;
        this.ordersManager = ordersManager;
        this.countDownTimer = new Timer();
	this.ingredientsList = new ArrayList<>();
	this.graphicComponent = new OrderGraphicComponent(this);
    }

    @Override
    public boolean checkOrder(Plate plate) {
        return plate.checkIngredients(this.ingredientsList);
    }
    
    public int getPoints() {
        return points;
    }
    
    public void addIngredient(IngredientType ingredientType, IngredientState ingredientState) {
        if(ingredientsList.size()==4)
            throw new IllegalStateException();
        ingredientsList.add(new IngredientImpl(this.ordersManager.getWorld().getItemManager(), ingredientType, ingredientState));
    }
    
    @Override
    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getSlot() {
        return this.slot;
    }
    
    @Override
    public void setCountDownTimer(int timeInSeconds) {
        this.countDownTime = timeInSeconds;
        this.ordersManager.getCurrentOrders().sort((o1, o2) -> o1.getCountDownTime() - o2.getCountDownTime());
    }
    
    @Override
    public int getCountDownTime() {
        return countDownTime;
    }

    @Override
    public int getOrderIngredientQuantity() {
        return ingredientsList.size();
    }
    
    @Override
    public ArrayList<OrderIngredient> getIngredientsList() {
        return ingredientsList;
    }

    @Override
    public void startOrder() {
        this.countDownTimer = new Timer();
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
    
    @Override
    public void stopOrder() {
        countDownTimer.cancel();
        countDownTimer.purge();
    }

    @Override
    public void draw(Graphics2D g) {
        this.graphicComponent.draw(g);
    }

}
