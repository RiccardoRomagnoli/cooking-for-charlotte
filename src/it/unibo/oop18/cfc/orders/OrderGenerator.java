package it.unibo.oop18.cfc.orders;

/**
 * Order Generator Interface.
 *
 */
public interface OrderGenerator {

    /**
     * Changes the difficulty in the generator.
     * 
     * @param currentDifficulty Difficulty to be set
     */
    void setDifficulty(OrderDifficulty currentDifficulty);

    /**
     * @param intervalMilliseconds frequency of generation
     */
    void startGeneration(long intervalMilliseconds);

    /**
     * @param paused True if paused
     */
    void setPaused(boolean paused);

    /**
     * 
     */
    void generateNewOrder();
}
