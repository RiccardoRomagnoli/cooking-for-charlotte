package it.unibo.oop18.cfc.Objects.Entity;

import java.util.Optional;

import it.unibo.oop18.cfc.Input.PlayerInputComponent;
import it.unibo.oop18.cfc.Objects.Items.Item;

public interface Player extends DynamicObject {

    public void doAction();
    
    public void increasePoints();

    public int numPoints();

    public int getTotalPoints();

    public void setTotalPoints(int i);

    public Optional<Item> getItemInHand();

    /**
     * Gets the player's input component.
     *
     * @return {@link PlayerInputComponent}
     */
    PlayerInputComponent getInput();
}
