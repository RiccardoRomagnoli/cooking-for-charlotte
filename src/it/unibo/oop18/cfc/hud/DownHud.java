//Contains a reference to the Player.
//Draws all relevant information at the
//bottom of the screen.

package it.unibo.oop18.cfc.hud;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.manager.Content;
import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.object.Items.IngredientImpl;
import it.unibo.oop18.cfc.object.Items.PlateImpl;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

public class DownHud {

    public static final String ITEMPATH = "/Sprites/itemSprite.png";
    private static final int POSITION_X_PLATE = 320;
    private static final int POSITION_Y_ITEM = 25;
    private static final int POSITION_Y_STATE = 95;
    private static final int DIM_ITEM = 60;
    private static final int POSITION_X_FOOD = 412;
    private static final int POSITION_X_STATE = 425;
    private static final int DISTANCE_BETWEEN_FOOD = 100;


    private int yoffset;
    private final World world;
    private BufferedImage bar;

    public DownHud(final World world) throws IOException {

        this.yoffset = GameEngine.HEIGHT2;
        this.world = world;
        this.bar = Content.DOWNBAR[0][0];
    }

    public void draw(Graphics2D g) {

        // draw hud
        g.drawImage(bar, 0, yoffset, null);
        if (world.getPlayer().getItemInHand().isPresent()) {
            if (world.getPlayer().getItemInHand().get() instanceof PlateImpl) {
                PlateImpl p = ((PlateImpl) world.getPlayer().getItemInHand().get());

                p.draw(g, new Position(POSITION_X_PLATE, yoffset + POSITION_Y_ITEM), DIM_ITEM, DIM_ITEM);
                IntStream.range(0, p.getIngredients().size()).forEach(a -> {
                    p.getIngredient(a).draw(g, new Position(POSITION_X_FOOD + a * DISTANCE_BETWEEN_FOOD, yoffset + POSITION_Y_ITEM), 70, DIM_ITEM);
                    p.getIngredient(a).drawState(g, new Position(POSITION_X_STATE + a * DISTANCE_BETWEEN_FOOD, yoffset + POSITION_Y_STATE));
                });
            } else {
                world.getPlayer().getItemInHand().get().draw(g, new Position(POSITION_X_FOOD, yoffset + POSITION_Y_ITEM), 80, DIM_ITEM);
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
        //draw lifes
        Integer lifes = world.getPlayer().getLifes();
        if (lifes <= 10) {
            Content.drawString(g, "hp:0" + lifes.toString(), 17, 654);
        } else {
            Content.drawString(g, "hp: " + lifes.toString(), 17, 654);
        }

    }
}
