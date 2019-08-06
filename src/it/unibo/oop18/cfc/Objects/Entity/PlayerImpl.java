package it.unibo.oop18.cfc.Objects.Entity;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.Graphics.DynamicPlayerGraphicsComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Input.PlayerInputComponent;
import it.unibo.oop18.cfc.Input.PlayerInputComponentImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.Item;
import it.unibo.oop18.cfc.Objects.Items.PlateImpl;
import it.unibo.oop18.cfc.Physics.Direction;
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
        //this.physics.
        this.physics.move();
        // check collision with blocks in the map
        //this.physics.checksCollisions(super.getTileMap());
    }

    public Optional<Item> getItemInHand(){
        return this.hand;
    }

    public void setItemInHand(Item i){
        this.hand = Optional.ofNullable(i);
    }
    
    public void removeItemInHand() {
        this.hand = Optional.empty();
    }
    /**
     * @param g element to draw
     */
    public void draw(final Graphics2D g) {
        gfx.draw(g);
    }

    @Override
    public DynamicPhysicsComponent getPhysics() {
        return physics;
    }

    @Override
    public PlayerInputComponent getInput() {
        return input;
    }

    @Override
    public void doAction() {
//        if (this.getItemInHand().isPresent()) {
//            if (this.getItemInHand().get() instanceof IngredientImpl) {
//                IngredientImpl ingr = (IngredientImpl) this.getItemInHand().get();
//            } else if (this.getItemInHand().get() instanceof PlateImpl) {
//
//            }
//        } else {
            this.getWorld().getAllStations().stream()
                    .filter(p -> p.getPosition().samePosition((Position.setInTile(getNextPosition()))))
                    .forEach(p -> p.doAction(getWorld()));
//        }
        System.out.println(this.getItemInHand());
    }

    private Position getNextPosition() {
        Position nextPosition = new Position(0, 0);
        Direction way = this.physics.getVelocity().getOldDirection();
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