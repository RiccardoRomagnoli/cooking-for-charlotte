package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.Graphics.ChoppingStationGraphicComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientState;
import it.unibo.oop18.cfc.Objects.Items.PlateImpl;
import it.unibo.oop18.cfc.Tile.ChoppingStationTile;
import it.unibo.oop18.cfc.Util.GameTimer;
import it.unibo.oop18.cfc.Util.JukeBoxUtil;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

public class ChoppingStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    private GameTimer timer;
    private Optional<IngredientImpl> food;
    private World world;
    private boolean isCutting;
    int isSoundPlaying = 0;

    /**
     * Creates a generic {@code Station}.
     * 
     * @param position            block's position
     * @param choppingStationTile block's tile
     */
    public ChoppingStation(final Position position, final ChoppingStationTile choppingStationTile, final World world) {
        super(position);
        this.food = Optional.empty();
        timer = new GameTimer();
        this.world = world;
        this.isCutting = false;
        this.graphicComponent = new ChoppingStationGraphicComponent(this, choppingStationTile);
    }

    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    public boolean isCut() {
        return isCutting;
    }

    public Optional<IngredientImpl> getFood() {
        return this.food;
    }

    public Optional<IngredientImpl> takeItem() {
        final Optional<IngredientImpl> f = food;
        this.food = Optional.empty();
        return f;
    };

    public void setItem(IngredientImpl f) {
        this.food = Optional.ofNullable(f);
        this.timer.start();
    };

    public void update() {
        if (isCutting == true && world.getPlayer().action == true && timer.isStopped()) {
            timer.start();
            isSoundPlaying = 1;
            JukeBoxUtil.loop("cuttingSound");
        } else if (isCutting == false || world.getPlayer().action == false) {
            isCutting = false;
            timer.reset();
            // isSoundPlaying = 2;
            // JukeBoxUtil.stop("cuttingSound");
        }
        if (food.isPresent() && food.get().getIngredient().getTimeToCut() == timer.getSeconds()) {
            isCutting = false;
            timer.reset();
            isSoundPlaying = 2;
            JukeBoxUtil.stop("cuttingSound");
            food.get().changeState(IngredientState.CHOPPED);
        }
    }

    /**
     * Spacebar pressed.
     */
    public void cutIngredient() {
        if (food.isPresent() && food.get().getState() == IngredientState.RAW) {
            if (!world.getPlayer().getItemInHand().isPresent()) {
                isCutting = true;
                if (isSoundPlaying != 1) {
                    JukeBoxUtil.loop("cuttingSound");
                    isSoundPlaying = 1;
                }
            }
        }

    }

    /**
     * Spacebar released.
     * 
     * @param world world
     */
    public void doAction(final World world) {
        // se cibo presente
        if (food.isPresent()) {
            // se il player ha qualcosa in mano
            if (world.getPlayer().getItemInHand().isPresent()) {
                // se è un piatto
                if (world.getPlayer().getItemInHand().get() instanceof PlateImpl) {
                    // e non è pieno
                    if (((PlateImpl) world.getPlayer().getItemInHand().get()).getIngredients().size() < 4) {
                        // aggiungi l'ingrediente nel piatto e toglilo dalla station
                        ((PlateImpl) world.getPlayer().getItemInHand().get()).addDish(food.get());
                        this.food = Optional.empty();
                    }
                }
            } else {
                // se il player non ha niente in mano e l'ingrediente è tagliato
                if (this.food.get().getState() == IngredientState.CHOPPED) {
                    world.getPlayer().setItemInHand(this.food.get());
                    this.food = Optional.empty();
                }
            }
        } else {
            // se non c'è cibo e ho in mano qualcosa che si un ingrediente
            if (world.getPlayer().getItemInHand().isPresent()
                    && world.getPlayer().getItemInHand().get() instanceof IngredientImpl
                    && ((IngredientImpl) world.getPlayer().getItemInHand().get()).getState() == IngredientState.RAW) {
                // aggiungi l'ingrediente nella station e toglilo dalla mano
                this.food = Optional.ofNullable((IngredientImpl) world.getPlayer().getItemInHand().get());
                world.getPlayer().removeItemInHand();
            }
        }
        isCutting = false;
        isSoundPlaying = 2;
        JukeBoxUtil.stop("cuttingSound");
    }
}
