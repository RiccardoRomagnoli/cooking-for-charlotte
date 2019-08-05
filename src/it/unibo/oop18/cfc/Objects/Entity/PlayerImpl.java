package it.unibo.oop18.cfc.Objects.Entity;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.Graphics.DynamicPlayerGraphicsComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Input.PlayerInputComponent;
import it.unibo.oop18.cfc.Input.PlayerInputComponentImpl;
import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Manager.SpriteManager;
import it.unibo.oop18.cfc.Objects.Items.Item;
import it.unibo.oop18.cfc.Objects.Items.Plate;
import it.unibo.oop18.cfc.Physics.DynamicPhysicsComponent;
import it.unibo.oop18.cfc.Physics.DynamicPhysicsComponentImpl;
import it.unibo.oop18.cfc.Sprite.PlayerSprites;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

public class PlayerImpl extends AbstractEntity implements Player {

    // gameplay
    private int points;
    private int totalPoints;

    // Physics, Input and Graphics
    private final DynamicPhysicsComponent physics;
    private final PlayerInputComponent input;
    private final GraphicsComponent gfx;

    //Plate and dishes
    private Optional<Item> hand;

    /**
     * @param tm
     */
    public PlayerImpl(final Position position, final PlayerSprites playerSprites, final World world) {
        super(position, world);
        points = 0;
        hand = Optional.empty();
        this.physics = new DynamicPhysicsComponentImpl(this);
        this.input = new PlayerInputComponentImpl(this);
        this.gfx = new DynamicPlayerGraphicsComponent(this, playerSprites);
    }

    /**
     *
     */
    public void increasePoints() {
        points++;
    }

    /**
     *
     */
    public int numPoints() {
        return points;
    }

    /**
     *
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * @param i total point to reach
     */
    public void setTotalPoints(final int i) {
        totalPoints = i;
    }

    /**
     *
     */
    public void update() {
        this.input.processInput();

        this.physics.move();
        // check collision with blocks in the map
        // this.physics.checksCollisions(super.getTileMap());
    }

    /**
     * @param g element to draw
     */
    public void draw(final Graphics2D g) {
        gfx.draw(g);
    }

    @Override
    public void doAction() {
        //System.out.println(this.physics.getNextTile());
    }

    @Override
    public DynamicPhysicsComponent getPhysics() {
        return physics;
    }

    @Override
    public PlayerInputComponent getInput() {
        return input;
    }
}