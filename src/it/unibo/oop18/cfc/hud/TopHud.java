// Contains a reference to the Player.
// Draws all relevant information at the
// bottom of the screen.

package it.unibo.oop18.cfc.hud;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import it.unibo.oop18.cfc.gamestate.PlayState;
import it.unibo.oop18.cfc.object.entity.PlayerImpl;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.world.World;

public class TopHud {

    private int yoffset;
    private BufferedImage bar;
    private final World world;

    public TopHud(World world) {
        this.world = world;
        yoffset = 0;
        bar = ContentUtil.TOPBAR[0][0];
    }

    public void draw(Graphics2D g) {
        g.drawImage(bar, 0, yoffset, null);
        this.world.getOrdersManager().draw(g);
    }
}
