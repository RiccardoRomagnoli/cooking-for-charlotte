package it.unibo.oop18.cfc.object;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import it.unibo.oop18.cfc.util.Position;


/**
 * This interface declares all method of all objects in the game.
 */
public interface GameObject {

    /**
     * Gets for the position of the object.
     * 
     * @return object's position
     */
    Position getPosition();

    /**
     * Gets for the rectangle of the body.
     * 
     * @return body's rectangle
     */
    Rectangle2D getBounds();
    /**
     * Renders object's sprite.
     * 
     * @param g component that draw the sprite
     */
    void draw(Graphics2D g);
}
