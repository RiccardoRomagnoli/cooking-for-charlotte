package it.unibo.oop18.cfc.object.entity;

import java.util.Optional;

import it.unibo.oop18.cfc.input.PlayerInputComponent;
import it.unibo.oop18.cfc.object.items.Item;
import it.unibo.oop18.cfc.util.Position;

public interface Player extends DynamicObject {

    void doAction();

    void cutIngredient();

    void increasePoints();

    int numPoints();

    int getTotalPoints();

    void setTotalPoints(int i);

    Optional<Item> getItemInHand();

    void setItemInHand(Item i);

    void removeItemInHand();

    Position getNextPosition();

    int getLifes();

    void decLifes();

    /**
     * Gets the player's input component.
     *
     * @return {@link PlayerInputComponent}
     */
    PlayerInputComponent getInput();
}
