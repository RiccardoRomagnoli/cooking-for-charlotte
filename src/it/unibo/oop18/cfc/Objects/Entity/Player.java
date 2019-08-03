package it.unibo.oop18.cfc.Objects.Entity;

import it.unibo.oop18.cfc.Input.PlayerInputComponent;

public interface Player extends DynamicObject {

    public void doAction();

    public void increasePoints();

    public int numPoints();

    public int getTotalPoints();

    public void setTotalPoints(int i);

    /**
     * Gets the player's input component.
     *
     * @return {@link PlayerInputComponent}
     */
    PlayerInputComponent getInput();
}
