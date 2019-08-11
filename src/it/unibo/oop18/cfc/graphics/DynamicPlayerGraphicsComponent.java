package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.object.Entity.AbstractEntity;
import it.unibo.oop18.cfc.physics.Direction;
import it.unibo.oop18.cfc.sprite.PlayerSprites;

/**
 * Graphics component for any dynamic entity that it moves.
 */
public class DynamicPlayerGraphicsComponent implements GraphicsComponent {

    private static final int DIVISION_BY_ZERO_PROTECTION = 1;
    private static final int MOVE_FRAME_DELAY = Math.round(GameEngine.FPS / 15) + DIVISION_BY_ZERO_PROTECTION;
    private static final int STOP_FRAME_DELAY = Math.round(GameEngine.FPS / 2) + DIVISION_BY_ZERO_PROTECTION;
    private static final int COUNTER_FRAME_LIMITER = STOP_FRAME_DELAY * 2;

    private final AbstractEntity entity;
    private final PlayerSprites sprites;
    private int frame;
    private int updateFrame;

    /**
     * Creates {@code DynamicEntityGraphicsComponent}.
     *
     * @param entity reference to take its direction
     * @param sprites for player and entity animations
     */
    public DynamicPlayerGraphicsComponent(final AbstractEntity entity,
                                          final PlayerSprites sprites) {
        this.sprites = sprites;
        this.entity = entity;
        this.frame = 0;
        this.updateFrame = 0;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        this.nextFrame();
        Direction dir = this.entity.getPhysics().getVelocity().getDirection();
        Direction oldDir = this.entity.getPhysics().getVelocity().getOldDirection();
        switch (dir) {
        case UP:
            g.drawImage(this.sprites.getUpSprites().get(this.frame).getImage(),
                        AffineTransform.getTranslateInstance(this.entity.getPosition().getX(),
                                                             this.entity.getPosition().getY()), null);
            break;
        case RIGHT:
            g.drawImage(this.sprites.getRightSprites().get(this.frame).getImage(),
                        AffineTransform.getTranslateInstance(this.entity.getPosition().getX(),
                                                             this.entity.getPosition().getY()), null);
            break;
        case LEFT:
            g.drawImage(this.sprites.getLeftSprites().get(this.frame).getImage(),
                        AffineTransform.getTranslateInstance(this.entity.getPosition().getX(),
                                                             this.entity.getPosition().getY()), null);
            break;
        case DOWN:
            g.drawImage(this.sprites.getDownSprites().get(this.frame).getImage(),
                        AffineTransform.getTranslateInstance(this.entity.getPosition().getX(),
                                                             this.entity.getPosition().getY()), null);
            break;
        default:
            g.drawImage(this.sprites.getStopSprites().get(oldDir).getImage(),
                    AffineTransform.getTranslateInstance(this.entity.getPosition().getX(),
                                                         this.entity.getPosition().getY()), null);
            break;
        }
    }

    /**
     * Gets the entity's container.
     *
     * @return the reference to the {@link AbstractEntity}
     */
    public AbstractEntity getEntity() {
        return this.entity;
    }

    private void nextFrame() {
        if (this.entity.getPhysics().getVelocity().getDirection() != Direction.STOP) {
            this.nextMoveFrame();
        } else {
            this.nextStopFrame();
        }
    }

    private void nextMoveFrame() {
        this.updateFrame += 1;
        if (this.updateFrame % MOVE_FRAME_DELAY == 0) {
            this.frame += 1;
            this.frame = this.frame >= this.sprites.getSpritesNumberToMove() ? 0 : this.frame;
        }
        this.resetUpdateFrameCounter();
    }

    private void nextStopFrame() {
//        this.updateFrame += 1;
//        this.frame = this.updateFrame < STOP_FRAME_DELAY ? 0 : 1;
//        this.resetUpdateFrameCounter();
    }

    private void resetUpdateFrameCounter() {
        this.updateFrame = this.updateFrame >= COUNTER_FRAME_LIMITER ? 0 : this.updateFrame;
    }
}
