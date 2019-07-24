package it.unibo.oop18.cfc.Entity;

import java.awt.Graphics2D;

public interface Player {
	
	public void draw(Graphics2D g);
	
	public void update();
	
	public void setDown();
	
	public void setLeft();
	
	public void setRight();
	
	public void setUp();
	
	public void doAction();
	
	public void increasePoints();
	
	public int numPoints();
	
	public int getTotalPoints();
	
	public void setTotalPoints(int i);
	
	public void setTilePosition(int a, int b);
	
	public void move(Direction way);
	
	public void stop();

}
