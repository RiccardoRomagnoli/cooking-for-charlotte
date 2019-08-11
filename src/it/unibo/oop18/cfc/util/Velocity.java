package it.unibo.oop18.cfc.util;

import it.unibo.oop18.cfc.physics.Direction;

/**
 * It models a vector composed by two components and one direction.
 */
public interface Velocity {

    /**
     * Gets vector x component.
     * 
     * @return x velocity
     */
    double getSpaceX();

    /**
     * Gets vector y component.
     * 
     * @return y velocity
     */
    double getSpaceY();

    /**
     * Sets a new value for x component.
     * 
     * @param spaceX to set
     */
    void setSpaceX(double spaceX);

    /**
     * Sets a new value for y component.
     * 
     * @param spaceY to set
     */
    void setSpaceY(double spaceY);

    /**
     * Gets the current entity's direction.
     * 
     * @return the current direction
     */
    Direction getDirection();

    /**
     * Gets the previous entity's direction.
     * 
     * @return the current direction
     */
    Direction getOldDirection();

    /**
     * Sets a new direction.
     * 
     * @param direction to set
     */
    void setDirection(Direction direction);

}
