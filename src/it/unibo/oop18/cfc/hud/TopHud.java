// Contains a reference to the Player.
// Draws all relevant information at the
// bottom of the screen.

package it.unibo.oop18.cfc.hud;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.world.World;

/**
 * The Class {@link TopHud}.
 */
public class TopHud {

    private final int yoffset;
    private final BufferedImage bar;
    private final World world;

    /**
     * Instantiates a new top hud.
     *
     * @param world the {@link World}
     */
    public TopHud(final World world) {
        this.world = world;
        yoffset = 0;
        bar = ContentUtil.TOPBAR[0][0];
    }

    /**
     * Draw to the screen.
     *
     * @param g the {@link Graphics2D} to draw 
     */
    public void draw(final Graphics2D g) {
        g.drawImage(bar, 0, yoffset, null);
        this.world.getOrdersManager().draw(g);
    }
}
