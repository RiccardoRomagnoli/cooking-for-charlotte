package it.unibo.oop18.cfc.hud;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.stream.IntStream;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.object.items.PlateImpl;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * The Class {@link DownHud}.
 */
public class DownHud {

    /** The Constant ITEMPATH. */
    public static final String ITEMPATH = "/Sprites/itemSprite.png";
    private static final int POSITION_X_PLATE = 320;
    private static final int POSITION_Y_ITEM = 25;
    private static final int POSITION_Y_STATE = 95;
    private static final int WIDTH_FOOD = 70;
    private static final int HEIGHT_FOOD = 60;
    private static final int DIM_ITEM = 60;
    private static final int POSITION_X_FOOD = 412;
    private static final int POSITION_X_STATE = 425;
    private static final int DISTANCE_BETWEEN_FOOD = 100;
    private static final int POSITION_X_STRINGS  = 17 + 50;
    private static final int POSITION_Y_LIFE = 654 + 35;
    private static final int POSITION_Y_TIME = 704 + 35;

    private final int yoffset;
    private final World world;

    /**
     * Instantiates a new down hud.
     *
     * @param world the {@link World}
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public DownHud(final World world) throws IOException {

        this.yoffset = GameEngine.HEIGHT2;
        this.world = world;
    }

    /**
     * Draw to the screen.
     *
     * @param g the {@link Graphics2D} to draw
     */
    public void draw(final Graphics2D g) {

        // draw hud
        ContentUtil.drawBotHud(g);
        if (world.getPlayer().getItemInHand().isPresent()) {
            if (world.getPlayer().getItemInHand().get() instanceof PlateImpl) {
                final PlateImpl p = ((PlateImpl) world.getPlayer().getItemInHand().get());

                p.draw(g, new Position(POSITION_X_PLATE, yoffset + POSITION_Y_ITEM), DIM_ITEM, DIM_ITEM);
                IntStream.range(0, p.getIngredients().size()).forEach(a -> {
                    p.getIngredient(a).draw(g,
                            new Position(POSITION_X_FOOD + a * DISTANCE_BETWEEN_FOOD, yoffset + POSITION_Y_ITEM), WIDTH_FOOD,
                            HEIGHT_FOOD);
                    p.getIngredient(a).drawState(g,
                            new Position(POSITION_X_STATE + a * DISTANCE_BETWEEN_FOOD, yoffset + POSITION_Y_STATE));
                });
            } else {
                world.getPlayer().getItemInHand().get().draw(g,
                        new Position(POSITION_X_FOOD, yoffset + POSITION_Y_ITEM), WIDTH_FOOD, HEIGHT_FOOD);
            }
        }
        // draw time
        final int minutes = (int) world.getGameTimer().getMinutes();
        final int seconds = (int) world.getGameTimer().getSeconds();
        if (minutes < 10) {
            if (seconds < 10) {
                //ContentUtil.drawString(g, "0" + minutes + ":0" + seconds, POSITION_X_STRINGS, POSITION_Y_TIME);
                ContentUtil.drawStringFont(g, POSITION_X_STRINGS, POSITION_Y_TIME,  "0" + minutes + ":0" + seconds);

            } else {
                //ContentUtil.drawString(g, "0" + minutes + ":" + seconds, POSITION_X_STRINGS, POSITION_Y_TIME);
                ContentUtil.drawStringFont(g, POSITION_X_STRINGS, POSITION_Y_TIME, "0" + minutes + ":" + seconds);

            }
        } else {
            if (seconds < 10) {
                //ContentUtil.drawString(g, minutes + ":0" + seconds, POSITION_X_STRINGS, POSITION_Y_TIME);
                ContentUtil.drawStringFont(g, POSITION_X_STRINGS, POSITION_Y_TIME, minutes + ":0" + seconds);

            } else {
                //ContentUtil.drawString(g, minutes + ":" + seconds, POSITION_X_STRINGS, POSITION_Y_TIME);
                ContentUtil.drawStringFont(g, POSITION_X_STRINGS, POSITION_Y_TIME, minutes + ":" + seconds);

            }
        }
        // draw lifes
        final Integer lifes = world.getPlayer().getLifes();
        if (lifes <= 10) {
            //ContentUtil.drawString(g, "hp:0" + lifes.toString(), POSITION_X_STRINGS, POSITION_Y_LIFE);
            ContentUtil.drawStringFont(g, POSITION_X_STRINGS, POSITION_Y_LIFE,"0" + lifes.toString());

        } else {
            //ContentUtil.drawString(g, "hp: " + lifes.toString(), POSITION_X_STRINGS, POSITION_Y_LIFE);
            ContentUtil.drawStringFont(g, POSITION_X_STRINGS, POSITION_Y_LIFE, lifes.toString());

        }

    }
}
