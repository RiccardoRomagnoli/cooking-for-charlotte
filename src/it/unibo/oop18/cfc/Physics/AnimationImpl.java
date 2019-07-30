package it.unibo.oop18.cfc.Physics;

import java.awt.image.BufferedImage;

public class AnimationImpl implements Animation {
	
	private BufferedImage[] frames;
	private int currentFrame;
	private int numFrames;
	
	private int count;
	private int delay;
	
	private int timesPlayed;
	
	public AnimationImpl() {
		timesPlayed = 0;
	}
	
	private void setFrames(BufferedImage[] frames) {
		this.frames = frames;
		currentFrame = 0;
		count = 0;
		timesPlayed = 0;
		delay = 2;
		numFrames = frames.length;
	}
	
	private void setFrame(BufferedImage frame) {
		this.frames = new BufferedImage[1];
		this.frames[0] = frame;
		currentFrame = 0;
		count = 0;
		timesPlayed = 0;
		delay = -1;
		numFrames = 0;
	}
	
    /**
     * @param i
     * @param bi
     * @param d
     */
    public void setAnimation(final Direction dir, final BufferedImage[] bi, final int delay) {
        setFrames(bi);
        setDelay(delay);
    }
	
	private void setDelay(int i) {
		delay = i;
	}

	public void setFrame(int i) {
		currentFrame = i;
	}

	public void setNumFrames(int i) {
		numFrames = i;
	}
	
	public void update() {

		if (delay == -1)
			return;

		count++;
		if (count == delay) {
			currentFrame++;
			count = 0;
		}
		
		if (currentFrame >= numFrames) {
			currentFrame = 0;
			timesPlayed++;
		}
	}
	
	public int getFrame() { 
		return currentFrame; 
	}
	
	public int getCount() {
		return count;
	}

	public BufferedImage getImage() {
		return frames[currentFrame];
	}

	public boolean hasPlayedOnce() {
		return timesPlayed > 0;
	}

	public boolean hasPlayed(int i) {
		return timesPlayed == i;
	}
}
