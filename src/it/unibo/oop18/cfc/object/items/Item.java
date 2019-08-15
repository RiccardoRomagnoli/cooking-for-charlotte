package it.unibo.oop18.cfc.object.items;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.util.Position;

/**
 * The Interface of a generic Item.
 */
public interface Item {

    /**
     * Draw the item in the {@link Position}.
     *
     * @param g the {@link Graphics2D} of the screen
     * @param p the {@link Position}
     */
    void draw(Graphics2D g, Position p);

    /**
     * Draw the item in the {@link Position} with width and height.
     *
     * @param g      the {@link Graphics2D} of the screen
     * @param p      the {@link Position}
     * @param width  the width
     * @param height the height
     */
    void draw(Graphics2D g, Position p, int width, int height);
}
