package it.unibo.oop18.cfc.Objects.Entity;

import java.util.Optional;

import it.unibo.oop18.cfc.Input.PlayerInputComponent;
import it.unibo.oop18.cfc.Objects.Items.Item;
import it.unibo.oop18.cfc.Util.Position;

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

    /**
     * Gets the player's input component.
     *
     * @return {@link PlayerInputComponent}
     */
    PlayerInputComponent getInput();
}
