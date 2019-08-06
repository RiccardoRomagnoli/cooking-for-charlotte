//Contains a reference to the Player.
//Draws all relevant information at the
//bottom of the screen.

package it.unibo.oop18.cfc.HUD;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import it.unibo.oop18.cfc.GameState.PlayState;
import it.unibo.oop18.cfc.Main.GameEngine;
import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientType;
import it.unibo.oop18.cfc.Objects.Items.PlateImpl;
import it.unibo.oop18.cfc.World.World;

public class DownHud {

    private int yoffset;
    private final World world;
    private BufferedImage bar;

    public DownHud(final World world) {

        this.yoffset = GameEngine.HEIGHT2;
        this.world = world;
        this.bar = Content.DOWNBAR[0][0];
    }

    public void draw(Graphics2D g) {

        // draw hud
        g.drawImage(bar, 0, yoffset, null);
        if (world.getPlayer().getItemInHand().isPresent()) {
            if (world.getPlayer().getItemInHand().get() instanceof IngredientImpl) {
                IngredientImpl i = (IngredientImpl) world.getPlayer().getItemInHand().get();
                drawFood(g, i);
            } else if (world.getPlayer().getItemInHand().get() instanceof PlateImpl) {
                PlateImpl p = (PlateImpl) world.getPlayer().getItemInHand().get();
                g.drawRect(320, yoffset + 20, 50, 50);
                p.getDishes().forEach(ing -> drawFood(g, ing));
            }
        }
//             // draw time
//             int minutes = (int) (playstate.getTicks() / 1800);
//             int seconds = (int) ((playstate.getTicks() / 30) % 60);
//             if(minutes < 10) {
//                     if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 17, 704);
//                     else Content.drawString(g, "0" + minutes + ":" + seconds, 17, 704);
//             }
//             else {
//                     if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 17, 704);
//                     else Content.drawString(g, minutes + ":" + seconds, 17, 704);
//             }
    }

    private void drawFood(final Graphics2D g, final IngredientImpl i) {
        switch (i.getIngredient()) {
        case BREAD:
            g.drawRect(380, yoffset + 20, 50, 50);
            break;
        case MEAT:
            g.drawRect(440, yoffset + 20, 50, 50);
            break;
        case LATTUCE:
            g.drawRect(500, yoffset + 20, 50, 50);
            break;
        case TOMATO:
            g.drawRect(560, yoffset + 20, 50, 50);
            break;
        default:
            break;
        }
    }

}
