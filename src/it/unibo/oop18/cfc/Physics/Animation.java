package it.unibo.oop18.cfc.Physics;

import java.awt.Image;
import java.awt.image.BufferedImage;

public interface Animation {

	void setFrames(BufferedImage[] bi);

	void setDelay(int delay);

	void setFrame(BufferedImage stopSprite);

	void update();

	Image getImage();

}
