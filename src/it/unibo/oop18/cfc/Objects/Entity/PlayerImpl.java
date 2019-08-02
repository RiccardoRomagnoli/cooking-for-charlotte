package it.unibo.oop18.cfc.Objects.Entity;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.Graphics.DynamicEntityGraphicsComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Input.PlayerInputComponent;
import it.unibo.oop18.cfc.Input.PlayerInputComponentImpl;
import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Objects.Items.Plate;
import it.unibo.oop18.cfc.Physics.DynamicPhysicsComponent;
import it.unibo.oop18.cfc.Physics.DynamicPhysicsComponentImpl;
import it.unibo.oop18.cfc.TileMap.PlayerSprites;
import it.unibo.oop18.cfc.TileMap.TileMap;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

public class PlayerImpl extends AbstractEntity implements Player {

    // gameplay
    private int points;
    private int totalPoints;
    private long ticks;

    // Physics, Input and Graphics
    private final DynamicPhysicsComponent physics;
    private final PlayerInputComponent input;
    private final GraphicsComponent gfx;

    //Plate and dishes
    private Optional<Plate> plate;

    /**
     * @param tm
     */
    public PlayerImpl(final Position position, final World world) {
        super(position, world);
        points = 0;
        plate = Optional.empty();
        this.physics = new DynamicPhysicsComponentImpl(this);
        this.input = new PlayerInputComponentImpl(this);
        this.gfx = new DynamicEntityGraphicsComponent(this, new PlayerSprites(Content.PLAYER));
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

    // Used to update time.
    /**
     * @return
     */
    public long getTicks() {
        return ticks;
    }

    /**
     *
     */
    public void update() {
        this.physics.move();
        // check collision with blocks in the map
        // this.physics.checksCollisions(super.getTileMap());
        this.input.processInput();
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