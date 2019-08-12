package it.unibo.oop18.cfc.physics;

import java.awt.geom.Rectangle2D;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.object.entity.DynamicObject;
import it.unibo.oop18.cfc.tile.TileSheet;
import it.unibo.oop18.cfc.util.Pair;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.util.Velocity;
import it.unibo.oop18.cfc.util.VelocityImpl;

/**
 * The Class DynamicPhysicsComponentImpl.
 */
public class DynamicPhysicsComponentImpl implements DynamicPhysicsComponent {

    private static final int POSITION_ADJUSTMENT = 10;
    private static final int HEIGHT_ADJUSTMENT = 5;
    private static final int WIDTH_ADJUSTMENT = 20;

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
    public Rectangle2D getTopBound() {
        return new Rectangle2D.Double(this.entity.getPosition().getX() + POSITION_ADJUSTMENT,
                this.entity.getPosition().getY(), TileSheet.TILE_SIZE_IN_GAME - WIDTH_ADJUSTMENT, HEIGHT_ADJUSTMENT);
    }

    /**
     * {@inheritDoc}
     */
    public Rectangle2D getLowerBound() {
        return new Rectangle2D.Double(this.entity.getPosition().getX() + POSITION_ADJUSTMENT,
                this.entity.getPosition().getY() + TileSheet.TILE_SIZE_IN_GAME - HEIGHT_ADJUSTMENT,
                TileSheet.TILE_SIZE_IN_GAME - WIDTH_ADJUSTMENT, HEIGHT_ADJUSTMENT);
    }

    /**
     * {@inheritDoc}
     */
    public Rectangle2D getLeftBound() {
        return new Rectangle2D.Double(this.entity.getPosition().getX(),
                this.entity.getPosition().getY() + POSITION_ADJUSTMENT, HEIGHT_ADJUSTMENT,
                TileSheet.TILE_SIZE_IN_GAME - WIDTH_ADJUSTMENT);
    }

    /**
     * {@inheritDoc}
     */
    public Rectangle2D getRightBound() {
        return new Rectangle2D.Double(
                this.entity.getPosition().getX() + TileSheet.TILE_SIZE_IN_GAME - HEIGHT_ADJUSTMENT,
                this.entity.getPosition().getY() + POSITION_ADJUSTMENT, HEIGHT_ADJUSTMENT,
                TileSheet.TILE_SIZE_IN_GAME - WIDTH_ADJUSTMENT);
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
