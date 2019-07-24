// The only subclass the fully utilizes the
// Entity superclass (no other class requires
// movement in a tile based map).
// Contains all the gameplay associated with
// the Player.

package it.unibo.oop18.cfc.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.TileMap.TileMap;
import it.unibo.oop18.cfc.Util.JukeBox;

public class Player extends Entity {
	
	// sprites
	private BufferedImage[] downSprites;
	private BufferedImage[] leftSprites;
	private BufferedImage[] rightSprites;
	private BufferedImage[] upSprites;
	
	// animation
	private final int DOWN = 0;
	private final int LEFT = 1;
	private final int RIGHT = 2;
	private final int UP = 3;

	
	// gameplay
	private int points;
	private int totalPoints;
	private long ticks;
	
	public Player(TileMap tm) {

		super(tm);

		width = 64;
		height = 64;
		cwidth = 12;
		cheight = 12;

		moveSpeed = 2;

		points = 0;

		downSprites = Content.PLAYER[0];
		leftSprites = Content.PLAYER[1];
		rightSprites = Content.PLAYER[2];
		upSprites = Content.PLAYER[3];
		animation.setFrames(downSprites);
		animation.setDelay(10);
	}
	
	private void setAnimation(int i, BufferedImage[] bi, int d) {
		currentAnimation = i;
		animation.setFrames(bi);
		animation.setDelay(d);
	}
	
	public void increasePoints() { points++; }
	public int numPoints() { return points; }
	public int getTotalPoints() { return totalPoints; }
	public void setTotalPoints(int i) { totalPoints = i; }
	
	
	// Used to update time.
	public long getTicks() { return ticks; }
	
	// Keyboard input. Moves the player.
	public void setDown() {
		super.setDown();
	}
	public void setLeft() {
		super.setLeft();
	}
	public void setRight() {
		super.setRight();
	}
	public void setUp() {
		super.setUp();
	}
	
	// Keyboard input.
	// If Player has dish, can take food
	public void setAction() {

	}
	
	public void update() {

		ticks++;

		// check if had dish



		// set animation
		if(down) {
                    if(currentAnimation != DOWN) {
                            setAnimation(DOWN, downSprites, 10);
                    }
                }
                if(left) {
                        if(currentAnimation != LEFT) {
                                setAnimation(LEFT, leftSprites, 10);
                        }
                }
                if(right) {
                        if(currentAnimation != RIGHT) {
                                setAnimation(RIGHT, rightSprites, 10);
                        }
                }
                if(up) {
                        if(currentAnimation != UP) {
                                setAnimation(UP, upSprites, 10);
                        }
                }

		// update position
		super.update();

	}
	
	// Draw Player.
	public void draw(Graphics2D g) {
		super.draw(g);
	}
	
}