package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.graphics.ChoppingStationGraphicComponent;
import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.IngredientState;
import it.unibo.oop18.cfc.object.items.PlateImpl;
import it.unibo.oop18.cfc.tile.ChoppingStationTile;
import it.unibo.oop18.cfc.util.GameTimer;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where food is cut.
 *
 */
public class ChoppingStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    private final GameTimer timer;
    private Optional<IngredientImpl> food;
    private final World world;
    private boolean isCutting;

    /** The is sound playing. */
    private int isSoundPlaying;

    /**
     * Instantiates a new {@link ChoppingStation}.
     *
     * @param position            the {@link Position}
     * @param choppingStationTile the {@link ChoppingStationTile} to draw
     * @param world               the {@link World}
     */
    public ChoppingStation(final Position position, final ChoppingStationTile choppingStationTile, final World world) {
        super(position);
        this.food = Optional.empty();
        this.isSoundPlaying = 0;
        timer = new GameTimer();
        this.world = world;
        this.isCutting = false;
        this.graphicComponent = new ChoppingStationGraphicComponent(this, choppingStationTile);
    }

    /**
     * Gets the chopping station {@link GameTimer}.
     *
     * @return the chopping station {@link GameTimer}
     */
    public GameTimer getChoppingStationTimer() {
        return timer;
    }

    /**
     * {@inheritDoc}.
     */
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    /**
     * Checks if is cutting.
     *
     * @return true, if is cutting
     */
    public boolean isCut() {
        return isCutting;
    }

    /**
     * Gets the {@link IngredientImpl}.
     *
     * @return an Optional of {@link IngredientImpl}
     */
    public Optional<IngredientImpl> getFood() {
        return this.food;
    }

    /**
     * Take item.
     *
     * @return the optional
     */
    public Optional<IngredientImpl> takeItem() {
        final Optional<IngredientImpl> f = food;
        this.food = Optional.empty();
        return f;
    };

    /**
     * Sets the {@link IngredientImpl} and start cut.
     *
     * @param f the {@link IngredientImpl}
     */
    public void setItem(final IngredientImpl f) {
        this.food = Optional.ofNullable(f);
        this.timer.start();
    };

    /**
     * Update the station to check the end of action.
     */
    public void update() {
        if (!world.getPlayer().isCutting() || (food.isPresent() && food.get().getState() == IngredientState.CHOPPED)) {
            isCutting = false;
            timer.reset();
            isSoundPlaying = 2;
            JukeBoxUtil.stop("cuttingSound");
        }
        if (food.isPresent() && food.get().getIngredient().getTimeToCut() == timer.getSeconds()) {
            food.get().changeState(IngredientState.CHOPPED);
        }
    }

    /**
     * When a player press/longpress Spacebar do this.
     */
    public void cutIngredient() {
        if (this.timer.isStopped() && food.isPresent() && food.get().getState() == IngredientState.RAW
                && !world.getPlayer().getItemInHand().isPresent()) {
            isCutting = true;
            timer.start();
            if (isSoundPlaying != 1) {
                JukeBoxUtil.loop("cuttingSound");
                isSoundPlaying = 1;

            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void doAction(final World world) {
        // se cibo presente
        if (food.isPresent()) {
            // se ha un piatto e non è pieno
            if (world.getPlayer().getItemInHand().isPresent()
                    && world.getPlayer().getItemInHand().get() instanceof PlateImpl
                    && ((PlateImpl) world.getPlayer().getItemInHand().get()).getIngredients().size() < 4) {
                // aggiungi l'ingrediente nel piatto e toglilo dalla station
                ((PlateImpl) world.getPlayer().getItemInHand().get()).addIngredient(food.get());
                this.food = Optional.empty();
                // se il player non ha niente in mano e l'ingrediente è tagliato
            } else if (!world.getPlayer().getItemInHand().isPresent()) {
                world.getPlayer().setItemInHand(this.food.get());
                this.food = Optional.empty();
            }
        } else {
            // se non c'è cibo e ho in mano qualcosa che sia un ingrediente
            if (world.getPlayer().getItemInHand().isPresent()
                    && world.getPlayer().getItemInHand().get() instanceof IngredientImpl
                    && ((IngredientImpl) world.getPlayer().getItemInHand().get()).getState() == IngredientState.RAW) {
                // aggiungi l'ingrediente nella station e toglilo dalla mano
                this.food = Optional.ofNullable((IngredientImpl) world.getPlayer().getItemInHand().get());
                world.getPlayer().removeItemInHand();
            }
        }
    }
}
