package it.unibo.oop18.cfc.Entity;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Physics.Direction;
import it.unibo.oop18.cfc.Physics.DynamicPhysicsComponent;

public interface Player {
	
	public void draw(Graphics2D g);
	
	public void update();
	
	public void doAction();
	
	public void increasePoints();
	
	public int numPoints();
	
	public int getTotalPoints();
	
	public void setTotalPoints(int i);
	
	public void move(Direction way);
	
	public DynamicPhysicsComponent getPhysics();
}
