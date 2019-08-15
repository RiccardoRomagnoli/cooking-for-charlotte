package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.graphics.CookerGraphicComponent;
import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.IngredientState;
import it.unibo.oop18.cfc.object.items.PlateImpl;
import it.unibo.oop18.cfc.tile.CookerTile;
import it.unibo.oop18.cfc.util.GameTimer;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where food si cooked.
 *
 */
public class Cooker extends AbstractStationObject {

    private static final int TIME_TO_BURN = 5;

    private final GraphicsComponent graphicComponent;
    private final GameTimer timer;
    private Optional<IngredientImpl> food;
    private boolean cooking;

    /**
     * Instantiates a new {@link Cooker}.
     *
     * @param position   the {@link Position}
     * @param cookerTile the {@link CookerTile} to draw
     */
    public Cooker(final Position position, final CookerTile cookerTile) {
        super(position);
        this.food = Optional.empty();
        this.timer = new GameTimer();
        this.cooking = false;
        this.graphicComponent = new CookerGraphicComponent(this, cookerTile);
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    /**
     * Gets the cooker {@link GameTimer}.
     *
     * @return the cooker {@link GameTimer}
     */
    public GameTimer getCookerTimer() {
        return this.timer;
    }

    /**
     * Gets the {@link GameTimer}.
     *
     * @return the {@link GameTimer}
     */
    public Optional<IngredientImpl> getFood() {
        return this.food;
    }

    /**
     * Take {@link GameTimer}.
     *
     * @return the optional {@link GameTimer}
     */
    public Optional<IngredientImpl> takeItem() {
        final Optional<IngredientImpl> f = food;
        this.food = Optional.empty();
        return f;
    };

    /**
     * Sets the {@link GameTimer}.
     *
     * @param f the new {@link GameTimer}
     */
    public void setItem(final IngredientImpl f) {
        this.food = Optional.ofNullable(f);
        this.timer.start();
    };

    /**
     * Update and check if the cooker and food is cooking.
     */
    public void update() {
        if (cooking && this.food.isPresent()) {
            if (this.food.get().getState() == IngredientState.CHOPPED
                    && timer.getSeconds() >= this.food.get().getIngredient().getTimeToCook()) {
                this.food.get().changeState(IngredientState.PERFECT);
            } else if (this.food.get().getState() == IngredientState.PERFECT
                    && timer.getSeconds() >= this.food.get().getIngredient().getTimeToCook() + TIME_TO_BURN) {
                this.food.get().changeState(IngredientState.BURNED);
            } else if (this.food.get().getState() == IngredientState.BURNED
                    && timer.getSeconds() >= this.food.get().getIngredient().getTimeToCook() + TIME_TO_BURN * 2) {
                this.food.get().changeState(IngredientState.WASTE);
                this.food = Optional.empty();
                this.cooking = false;
                this.timer.reset();
            }
        }
    }

    /**
     * Checks if is cooking.
     *
     * @return true, if is cooked
     */
    public boolean isCooking() {
        return cooking;
    }

    /**
     * {@inheritDoc}
     */
    public void doAction(final World world) {
        // se cibo presente
        if (food.isPresent()) {
            // se il player ha un piatto in mano e non è pieno
            if (world.getPlayer().getItemInHand().isPresent()
                    && world.getPlayer().getItemInHand().get() instanceof PlateImpl
                    && ((PlateImpl) world.getPlayer().getItemInHand().get()).getIngredients().size() < 4) {
                // aggiungi l'ingrediente nel piatto e toglilo dalla station
                ((PlateImpl) world.getPlayer().getItemInHand().get()).addIngredient(food.get());
                this.food = Optional.empty();
                this.timer.reset();
                this.cooking = false;
                // se il player non ha niente in mano e l'ingrediente è cotto o bruciato
            } else if (!world.getPlayer().getItemInHand().isPresent()
                    && (this.food.get().getState() == IngredientState.PERFECT
                            || this.food.get().getState() == IngredientState.BURNED)) {
                world.getPlayer().setItemInHand(this.food.get());
                this.food = Optional.empty();
                this.timer.reset();
                this.cooking = false;
            }
        } else {
            // se non c'è cibo e ho in mano qualcosa che sia un ingrediente tagliato
            if (world.getPlayer().getItemInHand().isPresent()
                    && world.getPlayer().getItemInHand().get() instanceof IngredientImpl
                    && ((IngredientImpl) world.getPlayer().getItemInHand().get()).getState() == IngredientState.CHOPPED
                    && ((IngredientImpl) world.getPlayer().getItemInHand().get()).getIngredient()
                            .getTimeToCook() != 0) {
                // aggiungi l'ingrediente nella station e toglilo dalla mano
                this.food = Optional.ofNullable((IngredientImpl) world.getPlayer().getItemInHand().get());
                world.getPlayer().removeItemInHand();
                this.timer.start();
                this.cooking = true;
            }
        }
    }
}
