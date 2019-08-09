//Contains a reference to the Player.
//Draws all relevant information at the
//bottom of the screen.

package it.unibo.oop18.cfc.HUD;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import it.unibo.oop18.cfc.Main.GameEngine;
import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Manager.ItemManager;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.PlateImpl;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

public class DownHud {

    public static final String ITEMPATH = "/Sprites/itemSprite.png";
    private int yoffset;
    private final World world;
    private BufferedImage bar;
    private ItemManager im;

    public DownHud(final World world) throws IOException {

        this.yoffset = GameEngine.HEIGHT2;
        this.world = world;
        this.bar = Content.DOWNBAR[0][0];
        im = world.getItemManager();
    }

    public void draw(Graphics2D g) {

        // draw hud
        g.drawImage(bar, 0, yoffset, null);
        if (world.getPlayer().getItemInHand().isPresent()) {
            if (world.getPlayer().getItemInHand().get() instanceof PlateImpl) {
                PlateImpl p = ((PlateImpl) world.getPlayer().getItemInHand().get());
                p.draw(g, new Position(320, yoffset + 25), 60, 60);
                IntStream.range(0, p.getIngredients().size())
                        .forEach(a -> { 
                            p.getIngredient(a).draw(g, new Position(420 + a * 100, yoffset + 25), 50, 50);
                            p.getIngredient(a).drawState(g, new Position(425 + a * 100, yoffset + 95));
                        });
            } else {
                world.getPlayer().getItemInHand().get().draw(g, new Position(420, yoffset + 25), 50, 50);
            }
        }
        // draw time
        int minutes = (int) world.getGameTimer().getMinutes();
        int seconds = (int) world.getGameTimer().getSeconds();
        if (minutes < 10) {
            if (seconds < 10) {
                Content.drawString(g, "0" + minutes + ":0" + seconds, 17, 704);
            } else {
                Content.drawString(g, "0" + minutes + ":" + seconds, 17, 704);
            }
        } else {
            if (seconds < 10) {
                Content.drawString(g, minutes + ":0" + seconds, 17, 704);
            } else {
                Content.drawString(g, minutes + ":" + seconds, 17, 704);
            }
        }
    }
}
