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
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

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
     * @param tm
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
     *
     */
    public void increasePoints() {
        points++;
    }

    /**
     *
     */
    public int getPoints() {
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

    public int getLifes() {
        return this.lifes;
    }

    public void decLifes() {
        this.lifes--;
    }

    public Optional<Item> getItemInHand() {
        return this.hand;
    }

    public void setItemInHand(final Item i) {
        this.hand = Optional.ofNullable(i);
    }

    public void removeItemInHand() {
        this.hand = Optional.empty();
    }

    public boolean isCutting() {
        return actionCut;
    }

    public void setCutAction(final boolean b) {
        this.actionCut = b;
    }

    public DynamicPhysicsComponent getPhysics() {
        return physics;
    }

    public PlayerInputComponent getInput() {
        return input;
    }

    /**
     *
     */
    public void update() {
        this.input.processInput();
        this.physics.move();
        if (this.actionCut) {
            cutIngredient();
        }
    }

    /**
     * @param g element to draw
     */
    public void draw(final Graphics2D g) {
        gfx.draw(g);
    }

    @Override
    public void doAction() {
        super.getWorld().getAllStations().stream()
                .filter(p -> p.getPosition().samePosition((Position.setInTile(getNextPosition())))).findFirst()
                .ifPresent(val -> val.doAction(super.getWorld()));
    }

    @Override
    public void cutIngredient() {
        final Optional<ChoppingStation> cs = super.getWorld().getChoppingStations().stream()
                .filter(p -> p.getPosition().samePosition((Position.setInTile(getNextPosition())))).findFirst();
        if (cs.isPresent()) {
            cs.get().cutIngredient();
        } else {
            this.actionCut = false;
        }
    }

    public Position getNextPosition() {
        final Position nextPosition = new Position(0, 0);
        final Direction way = this.physics.getVelocity().getOldDirection();
        switch (way) {
        case UP:
            nextPosition.setX(this.getPosition().getX() + 32);
            nextPosition.setY(this.getPosition().getY() - 1);
            break;
        case DOWN:
            nextPosition.setX(this.getPosition().getX() + 32);
            nextPosition.setY(this.getPosition().getY() + 65);
            break;
        case LEFT:
            nextPosition.setX(this.getPosition().getX() - 1);
            nextPosition.setY(this.getPosition().getY() + 32);
            break;
        case RIGHT:
            nextPosition.setX(this.getPosition().getX() + 65);
            nextPosition.setY(this.getPosition().getY() + 32);
            break;
        default:
            break;
        }
        return nextPosition;
    }

}
