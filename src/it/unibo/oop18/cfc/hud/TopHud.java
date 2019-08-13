// Contains a reference to the Player.
// Draws all relevant information at the
// bottom of the screen.

package it.unibo.oop18.cfc.hud;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.world.World;

/**
 * The Class {@link TopHud}.
 */
public class TopHud {

    private final World world;

    /**
     * Instantiates a new top hud.
     *
     * @param world the {@link World}
     */
    public TopHud(final World world) {
        this.world = world;
    }

    /**
     * Draw to the screen.
     *
     * @param g the {@link Graphics2D} to draw 
     */
    public void draw(final Graphics2D g) {
        ContentUtil.drawTopHud(g);
        this.world.getOrdersManager().draw(g);
    }
}
