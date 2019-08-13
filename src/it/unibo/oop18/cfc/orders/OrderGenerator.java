package it.unibo.oop18.cfc.orders;

public interface OrderGenerator {

    public void setDifficulty(OrderDifficulty currentDifficulty);

    public void startGeneration(long intervalMilliseconds);

    void setPaused(boolean paused);

    public void generateNewOrder();
}
