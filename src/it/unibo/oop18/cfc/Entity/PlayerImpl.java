// The only subclass the fully utilizes the
// Entity superclass (no other class requires
// movement in a tile based map).
// Contains all the gameplay associated with
// the Player.

package it.unibo.oop18.cfc.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Physics.Direction;
import it.unibo.oop18.cfc.Physics.DynamicPhysicsComponent;
import it.unibo.oop18.cfc.Physics.DynamicPhysicsComponentImpl;
import it.unibo.oop18.cfc.TileMap.TileMap;

public class PlayerImpl implements Player {
	
    // gameplay
    private int points;
    private int totalPoints;
    private long ticks;
    
    //Phisics
    private final DynamicPhysicsComponent physics;

    /**
     * @param tm
     */
    public PlayerImpl(final TileMap tm) {
    	points = 0;
        physics = new DynamicPhysicsComponentImpl(tm);
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
     *  @param i total point to reach
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

    // Keyboard input.
    // If Player has dish, can take food
    /**
     *
     */
    public void setAction() {

    }

    /**
     *
     */
    public void update() {
        physics.update();
    }

    /**
     * @param g element to draw
     */
    public void draw(final Graphics2D g) {
        physics.draw(g);
    }

	@Override
	public void doAction() {
		
	}

	// Keyboard input. Moves the player.
	@Override
	public void move(Direction way) {
		switch(way) {
		case DOWN:
			physics.moveDown();
			break;
		case LEFT:
			physics.moveLeft();
			break;
		case RIGHT:
			physics.moveRight();
			break;
		case UP:
			physics.moveUp();
			break;
		case STOP:
			physics.stop();
			break;
		default:
			break;
		}
	}

	@Override
	public DynamicPhysicsComponent getPhysics() {
		return physics;
	}
}