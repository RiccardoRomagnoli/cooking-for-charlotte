package it.unibo.oop18.cfc.object.entity;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.graphics.DynamicPlayerGraphicsComponent;
import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.input.PlayerInputComponent;
import it.unibo.oop18.cfc.input.PlayerInputComponentImpl;
import it.unibo.oop18.cfc.object.items.Item;
import it.unibo.oop18.cfc.object.stations.ChoppingStation;
import it.unibo.oop18.cfc.physics.DynamicPhysicsComponent;
import it.unibo.oop18.cfc.physics.DynamicPhysicsComponentImpl;
import it.unibo.oop18.cfc.sprite.PlayerSprites;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * The Class PlayerImpl.
 */
public class PlayerImpl extends AbstractEntity implements Player {

    private static final int INITIAL_LIFES = 3;
    // gameplay
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
     * @param position      the position
     * @param playerSprites the player sprites
     * @param world         the world
     */
    public PlayerImpl(final Position position, final PlayerSprites playerSprites, final World world) {
        super(position, world);
        this.actionCut = false;
        this.hand = Optional.empty();
        this.lifes = INITIAL_LIFES;
        this.physics = new DynamicPhysicsComponentImpl(this);
        this.input = new PlayerInputComponentImpl(this);
        this.gfx = new DynamicPlayerGraphicsComponent(this, playerSprites);
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
                .filter(p -> p.getPosition().samePosition((Position.setInTile(this.physics.getNextPosition()))))
                .findFirst().ifPresent(val -> val.doAction(super.getWorld()));
    }

    /**
     * Cut ingredient when press bar space.
     */
    private void cutIngredient() {
        final Optional<ChoppingStation> cs = super.getWorld().getChoppingStations().stream()
                .filter(p -> p.getPosition().samePosition((Position.setInTile(this.physics.getNextPosition()))))
                .findFirst();
        if (cs.isPresent()) {
            cs.get().cutIngredient();
        } else {
            this.actionCut = false;
        }
    }

}
