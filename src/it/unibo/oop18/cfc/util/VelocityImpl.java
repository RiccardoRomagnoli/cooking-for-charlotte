package it.unibo.oop18.cfc.util;

import it.unibo.oop18.cfc.physics.Direction;

/**
 * This class implements the {@link Velocity} interface.
 */
public class VelocityImpl implements Velocity {

    private double spaceX;
    private double spaceY;
    private Direction direction;
    private Direction oldDirection;

    /**
     * Creates a new {@link Velocity}.
     */
    public VelocityImpl() {
        this.spaceX = 0;
        this.spaceY = 0;
        this.direction = Direction.STOP;
        this.oldDirection = Direction.DOWN;
    }

    /**
     * {@inheritDoc}
     */
    public double getSpaceX() {
        return this.spaceX;
    }

    /**
     * {@inheritDoc}
     */
    public void setSpaceX(final double spaceX) {
        this.spaceX = spaceX;
    }

    /**
     * {@inheritDoc}
     */
    public double getSpaceY() {
        return this.spaceY;
    }

    /**
     * {@inheritDoc}
     */
    public void setSpaceY(final double spaceY) {
        this.spaceY = spaceY;
    }

    /**
     * {@inheritDoc}
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * {@inheritDoc}
     */
    public void setDirection(final Direction direction) {
        if (direction != Direction.STOP) {
            this.oldDirection = direction;
        }
        this.direction = direction;
    }

    /**
     * {@inheritDoc}
     */
    public Direction getOldDirection() {
        return oldDirection;
    }

}
