package it.unibo.oop18.cfc.object.entity;

import java.util.Optional;

import it.unibo.oop18.cfc.input.PlayerInputComponent;
import it.unibo.oop18.cfc.object.items.Item;
import it.unibo.oop18.cfc.util.Position;

/**
 * The Interface Player.
 */
public interface Player extends DynamicObject {

    /**
     * Increase points.
     */
    void increasePoints();

    /**
     * Gets the points.
     *
     * @return the points
     */
    int getPoints();

    /**
     * Gets the total points to reach.
     *
     * @return the total points
     */
    int getTotalPoints();

    /**
     * Sets the total points to reach.
     *
     * @param i the new total points
     */
    void setTotalPoints(int i);

    /**
     * Gets the lifes.
     *
     * @return the lifes
     */
    int getLifes();

    /**
     * Decrease lifes.
     */
    void decLifes();

    /**
     * Gets the item in hand.
     *
     * @return the Optional {@link Item} in hand
     */
    Optional<Item> getItemInHand();

    /**
     * Sets the item in hand.
     *
     * @param i the new {@link Item} in hand
     */
    void setItemInHand(Item i);

    /**
     * Removes the {@link Item} in hand.
     */
    void removeItemInHand();

    /**
     * Checks if is cutting.
     *
     * @return true, if is cutting
     */
    boolean isCutting();

    /**
     * Sets the cut action.
     *
     * @param b the new cut action
     */
    void setCutAction(boolean b);

    /**
     * Gets the player's input component.
     *
     * @return {@link PlayerInputComponent}
     */
    PlayerInputComponent getInput();

    /**
     * Do action when release bar space.
     */
    void doAction();

    /**
     * Cut ingredient when press bar space.
     */
    void cutIngredient();

    /**
     * Gets the next position.
     *
     * @return the next {@link Position}
     */
    Position getNextPosition();

}
