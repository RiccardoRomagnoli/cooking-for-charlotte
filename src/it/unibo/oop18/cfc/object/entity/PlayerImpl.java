package it.unibo.oop18.cfc.object.entity;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.graphics.DynamicPlayerGraphicsComponent;
import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.input.PlayerInputComponent;
import it.unibo.oop18.cfc.input.PlayerInputComponentImpl;
import it.unibo.oop18.cfc.object.items.Item;
import it.unibo.oop18.cfc.object.stations.ChoppingStation;
import it.unibo.oop18.cfc.physics.Direction;
import it.unibo.oop18.cfc.physics.DynamicPhysicsComponent;
import it.unibo.oop18.cfc.physics.DynamicPhysicsComponentImpl;
import it.unibo.oop18.cfc.sprite.PlayerSprites;
import it.unibo.oop18.cfc.sprite.SpriteSheet;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * The Class PlayerImpl.
 */
public class PlayerImpl extends AbstractEntity implements Player {

    // gameplay
    private int points;
    private int totalPoints;
    private int lifes;
    private Optional<Item> hand;
    private boolean actionCut;
    // Physics, Input and Graphics
    private final DynamicPhysicsComponent physics;
    private final PlayerInputComponent input;
    private final GraphicsComponent gfx;

    /**
     * Instantiates a new player impl.
     *
     * @param position the position
     * @param playerSprites the player sprites
     * @param world the world
     */
    public PlayerImpl(final Position position, final PlayerSprites playerSprites, final World world) {
        super(position, world);
        this.points = 0;
        this.actionCut = false;
        this.hand = Optional.empty();
        this.lifes = 3;
        this.physics = new DynamicPhysicsComponentImpl(this);
        this.input = new PlayerInputComponentImpl(this);
        this.gfx = new DynamicPlayerGraphicsComponent(this, playerSprites);
    }


    /**
    * {@inheritDoc}
    */
    public void increasePoints() {
        points++;
    }


    /**
    * {@inheritDoc}
    */
    public int getPoints() {
        return points;
    }


    /**
    * {@inheritDoc}
    */
    public int getTotalPoints() {
        return totalPoints;
    }


    /**
    * {@inheritDoc}
    */
    public void setTotalPoints(final int i) {
        totalPoints = i;
    }

    /**
    * {@inheritDoc}
    */
    public int getLifes() {
        return this.lifes;
    }

    /**
    * {@inheritDoc}
    */
    public void decLifes() {
        this.lifes--;
    }

    /**
    * {@inheritDoc}
    */
    public Optional<Item> getItemInHand() {
        return this.hand;
    }

    /**
    * {@inheritDoc}
    */
    public void setItemInHand(final Item i) {
        this.hand = Optional.ofNullable(i);
    }

    /**
    * {@inheritDoc}
    */
    public void removeItemInHand() {
        this.hand = Optional.empty();
    }

    /**
    * {@inheritDoc}
    */
    public boolean isCutting() {
        return actionCut;
    }

    /**
    * {@inheritDoc}
    */
    public void setCutAction(final boolean b) {
        this.actionCut = b;
    }

    /**
    * {@inheritDoc}
    */
    public DynamicPhysicsComponent getPhysics() {
        return physics;
    }

    /**
    * {@inheritDoc}
    */
    public PlayerInputComponent getInput() {
        return input;
    }

    /**
    * {@inheritDoc}
    */
    public void update() {
        this.input.processInput();
        this.physics.move();
        if (this.actionCut) {
            cutIngredient();
        }
    }

    /**
    * {@inheritDoc}
    */
    public void draw(final Graphics2D g) {
        gfx.draw(g);
    }


    /**
    * {@inheritDoc}
    */
    public void doAction() {
        super.getWorld().getAllStations().stream()
                .filter(p -> p.getPosition().samePosition((Position.setInTile(getNextPosition())))).findFirst()
                .ifPresent(val -> val.doAction(super.getWorld()));
    }

    /**
    * {@inheritDoc}
    */
    public void cutIngredient() {
        final Optional<ChoppingStation> cs = super.getWorld().getChoppingStations().stream()
                .filter(p -> p.getPosition().samePosition((Position.setInTile(getNextPosition())))).findFirst();
        if (cs.isPresent()) {
            cs.get().cutIngredient();
        } else {
            this.actionCut = false;
        }
    }

    /**
    * {@inheritDoc}
    */
    public Position getNextPosition() {
        final Position nextPosition = new Position(0, 0);
        final Direction way = this.physics.getVelocity().getOldDirection();
        switch (way) {
        case UP:
            nextPosition.setX(this.getPosition().getX() + SpriteSheet.SPRITE_SIZE_IN_GAME / 2);
            nextPosition.setY(this.getPosition().getY() - 1);
            break;
        case DOWN:
            nextPosition.setX(this.getPosition().getX() + SpriteSheet.SPRITE_SIZE_IN_GAME / 2);
            nextPosition.setY(this.getPosition().getY() + SpriteSheet.SPRITE_SIZE_IN_GAME + 1);
            break;
        case LEFT:
            nextPosition.setX(this.getPosition().getX() - 1);
            nextPosition.setY(this.getPosition().getY() + SpriteSheet.SPRITE_SIZE_IN_GAME / 2);
            break;
        case RIGHT:
            nextPosition.setX(this.getPosition().getX() + SpriteSheet.SPRITE_SIZE_IN_GAME + 1);
            nextPosition.setY(this.getPosition().getY() + SpriteSheet.SPRITE_SIZE_IN_GAME / 2);
            break;
        default:
            break;
        }
        return nextPosition;
    }

}
