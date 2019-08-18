package it.unibo.oop18.cfc.physics;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.object.entity.DynamicObject;
import it.unibo.oop18.cfc.sprite.SpriteSheet;
import it.unibo.oop18.cfc.util.Pair;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.util.Velocity;
import it.unibo.oop18.cfc.util.VelocityImpl;

/**
 * The Class DynamicPhysicsComponentImpl.
 */
public class DynamicPhysicsComponentImpl implements DynamicPhysicsComponent {

    private final Velocity vector;
    private final DynamicObject entity;

    /**
     * Instantiates a new {@link DynamicPhysicsComponentImpl}.
     *
     * @param entity the {@link DynamicObject} to give this dynamic
     */
    public DynamicPhysicsComponentImpl(final DynamicObject entity) {
        this.vector = new VelocityImpl();
        this.entity = entity;
    }

    /**
     * {@inheritDoc}
     */
    public Velocity getVelocity() {
        return vector;
    }

    /**
     * {@inheritDoc}
     */
    public Position getNextPosition() {
        final Position nextPosition = new Position(0, 0);
        final Position currentPosition = this.entity.getPosition();
        final Direction way = this.vector.getOldDirection();
        switch (way) {
        case UP:
            nextPosition.setX(currentPosition.getX() + SpriteSheet.SPRITE_SIZE_IN_GAME / 2);
            nextPosition.setY(currentPosition.getY() - 1);
            break;
        case DOWN:
            nextPosition.setX(currentPosition.getX() + SpriteSheet.SPRITE_SIZE_IN_GAME / 2);
            nextPosition.setY(currentPosition.getY() + SpriteSheet.SPRITE_SIZE_IN_GAME + 1);
            break;
        case LEFT:
            nextPosition.setX(currentPosition.getX() - 1);
            nextPosition.setY(currentPosition.getY() + SpriteSheet.SPRITE_SIZE_IN_GAME / 2);
            break;
        case RIGHT:
            nextPosition.setX(currentPosition.getX() + SpriteSheet.SPRITE_SIZE_IN_GAME + 1);
            nextPosition.setY(currentPosition.getY() + SpriteSheet.SPRITE_SIZE_IN_GAME / 2);
            break;
        default:
            break;
        }
        return nextPosition;
    }

    /**
     * {@inheritDoc}
     */
    public void move() {
        final Position previousPos = this.entity.getPosition();
        final double velX = this.vector.getSpaceX();
        final double velY = this.vector.getSpaceY();

        final Pair<Double, Double> deltas = this.getDeltas(new Pair<>(velX, velY), previousPos);
        this.entity.getPosition().setX(this.entity.getPosition().getX() + deltas.getFirst());
        this.entity.getPosition().setY(this.entity.getPosition().getY() + deltas.getSecond());
    }

    private Pair<Double, Double> getDeltas(final Pair<Double, Double> velocity, final Position previousPos) {
        double deltaX = velocity.getFirst();
        double deltaY = velocity.getSecond();
        if (previousPos.getX() + deltaX >= GameEngine.RIGHT_BOUND_IN_PIXEL) {
            deltaX = GameEngine.RIGHT_BOUND_IN_PIXEL - previousPos.getX();
        } else if (previousPos.getX() + deltaX <= GameEngine.LEFT_BOUND_IN_PIXEL) {
            deltaX = GameEngine.LEFT_BOUND_IN_PIXEL - previousPos.getX();
        }

        if (previousPos.getY() + deltaY >= GameEngine.DOWN_BOUND_IN_PIXEL) {
            deltaY = GameEngine.DOWN_BOUND_IN_PIXEL - previousPos.getY();
        } else if (previousPos.getY() + deltaY <= GameEngine.TOP_BOUND_IN_PIXEL) {
            deltaY = GameEngine.TOP_BOUND_IN_PIXEL - previousPos.getY();
        }
        return new Pair<>(deltaX, deltaY);
    }
}
