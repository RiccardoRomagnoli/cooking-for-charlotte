package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.orders.Order;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.Position;

/**
 * The Class OrderGraphicComponent.
 */
public class OrderGraphicComponent implements GraphicsComponent {

    private static final int DISTANCE_BETWEEN_INGREDIENT = 12;
    private static final int SLOT_DIMENSION = 250;
    private static final int X_TIMER = 61;
    private static final int Y_TIMER = 90;
    private static final int WIDTH_TIMER_TEXT = 25;
    private static final int HEIGHT_TIMER_TEXT = 25;
    private static final int INGREDIENT_WIDTH_HEIGHT = 40;
    private static final int X_FIRST_INGREDIENT = 6;
    private static final int Y_INGREDIENTS = 25;
    private static final int OFFSET = 1;
    private static final int WIDTH_SLOT_GRAPHIC = 13;
    private static final int SECONDS_IN_MINUTE = 60;

    private final Order order;

    /**
     * Instantiates a new {@link OrderGraphicComponent}.
     *
     * @param order the {@link Order}
     */
    public OrderGraphicComponent(final Order order) {
        this.order = order;
    }

    /**
     * {@inheritDoc}.
     */
    public void draw(final Graphics2D g) {
        this.order.getIngredientsList()
                .forEach(i -> i.draw(g,
                        new Position(OFFSET + WIDTH_SLOT_GRAPHIC + X_FIRST_INGREDIENT + SLOT_DIMENSION * order.getSlot()
                                + (DISTANCE_BETWEEN_INGREDIENT + INGREDIENT_WIDTH_HEIGHT)
                                        * order.getIngredientsList().indexOf(i),
                                Y_INGREDIENTS),
                        INGREDIENT_WIDTH_HEIGHT, INGREDIENT_WIDTH_HEIGHT));
        drawCountDown(g, order.getCountDownTime() / SECONDS_IN_MINUTE, order.getCountDownTime() % SECONDS_IN_MINUTE,
                OFFSET + WIDTH_SLOT_GRAPHIC + X_TIMER + SLOT_DIMENSION * order.getSlot(), Y_TIMER, WIDTH_TIMER_TEXT,
                HEIGHT_TIMER_TEXT);
    }

    private void drawCountDown(final Graphics2D g, final int minutes, final int seconds, final int x, final int y, final int width, final int height) {
        if (minutes < 10) {
            if (seconds < 10) {
                ContentUtil.drawString(g, "0" + minutes + ":0" + seconds, x, y, width, height);
            } else {
                ContentUtil.drawString(g, "0" + minutes + ":" + seconds, x, y, width, height);
            }
        } else {
            if (seconds < 10) {
                ContentUtil.drawString(g, minutes + ":0" + seconds, x, y, width, height);
            } else {
                ContentUtil.drawString(g, minutes + ":" + seconds, x, y, width, height);
            }
        }
    }

}
