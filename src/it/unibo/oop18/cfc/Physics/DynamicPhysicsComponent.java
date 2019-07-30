package it.unibo.oop18.cfc.Physics;

import java.awt.Graphics2D;

public interface DynamicPhysicsComponent {

	void stop();

	void move(Direction dir);

	void draw(Graphics2D g);

	void update();

	void setTilePosition(int i, int j);

}
