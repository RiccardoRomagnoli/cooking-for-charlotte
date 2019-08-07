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
        im = new ItemManager(ITEMPATH);
    }

    public void draw(Graphics2D g) {

        // draw hud
        g.drawImage(bar, 0, yoffset, null);
        if (world.getPlayer().getItemInHand().isPresent()) {
            if (world.getPlayer().getItemInHand().get() instanceof IngredientImpl) {
                IngredientImpl i = (IngredientImpl) world.getPlayer().getItemInHand().get();
                drawFood(g, i, 0);
            } else if (world.getPlayer().getItemInHand().get() instanceof PlateImpl) {
                PlateImpl p = (PlateImpl) world.getPlayer().getItemInHand().get();
                g.drawImage(im.getPlateSprites().getItemSprite().get(0).getImage(), 320, yoffset + 25, 60, 60, null);
                IntStream.range(0, p.getIngredients().size()).forEach(a -> drawFood(g, p.getIngredient(a), a));
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

    private void drawFood(final Graphics2D g, final IngredientImpl i, final int count) {
        switch (i.getIngredient()) {
        case BREAD:
            g.drawImage(im.getFoodSprites().getBreadSprite().get(0).getImage(), 420 + count * 95, yoffset + 25, 60, 60,
                    null);
            break;
        case MEAT:
            g.drawImage(im.getFoodSprites().getMeatSprite().get(0).getImage(), 420 + count * 95, yoffset + 25, 60, 60,
                    null);
            break;
        case LETTUCE:
            g.drawImage(im.getFoodSprites().getLettuceSprite().get(0).getImage(), 420 + count * 95, yoffset + 25, 60,
                    60, null);
            break;
        case TOMATO:
            g.drawImage(im.getFoodSprites().getTomatoSprite().get(0).getImage(), 420 + count * 95, yoffset + 25, 60, 60,
                    null);
            break;
        default:
            break;
        }

        switch (i.getState()) {
        case CHOPPED:
            g.drawImage(im.getFoodSprites().getItemSprite().get(0).getImage(), 420 + count * 95, yoffset + 25, 60, 60,
                    null);
            break;
        case PERFECT:
            g.drawImage(im.getFoodSprites().getItemSprite().get(1).getImage(), 420 + count * 95, yoffset + 25, 60, 60,
                    null);
            break;
        default:
            break;
        }
    }
}
