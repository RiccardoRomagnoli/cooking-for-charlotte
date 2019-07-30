package it.unibo.oop18.cfc.Physics;

import java.awt.Image;
import java.awt.image.BufferedImage;

public interface Animation {

	void update();

	Image getImage();
	
	public void setAnimation(final Direction dir, final BufferedImage[] bi, final int delay);

}
