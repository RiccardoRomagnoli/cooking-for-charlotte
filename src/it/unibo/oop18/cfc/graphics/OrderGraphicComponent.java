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
    private static final int SLOT_DIMENSION = 255;
    private static final int INGREDIENT_WIDTH_HEIGHT = 40;
    private static final int X_FIRST_INGREDIENT = 6;
    private static final int Y_INGREDIENTS = 25;
    private static final int OFFSET = 1;
    private static final int WIDTH_SLOT_GRAPHIC = 13;
    private static final int X_BAR = 42;
    private static final int Y_BAR = 76;
    private static final int BAR_HEIGHT = 23;
    private static final int BAR_WEIGHT = 175;

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
        drawCountDownBar(g, order.getCountDownTime(), order.getCurrentCountDownTime(),  X_BAR + SLOT_DIMENSION * order.getSlot(),
                Y_BAR, BAR_WEIGHT, BAR_HEIGHT);
    }

    private void drawCountDownBar(final Graphics2D g, final int secondsTotal, final int secondsRemaining, final int x, final int y, final int width,
            final int height) {
        final int color = (secondsTotal - secondsRemaining - 1)
                / (secondsTotal / 3) + 1;
        final double currentWidth = ((double) width) / secondsTotal * secondsRemaining + 1;
        ContentUtil.drawLoadBar(g, x, y, (int) currentWidth, height, color);
    }
}
