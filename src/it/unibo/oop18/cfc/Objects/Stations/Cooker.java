package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.Graphics.CookerGraphicComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientState;
import it.unibo.oop18.cfc.Objects.Items.PlateImpl;
import it.unibo.oop18.cfc.Tile.CookerTile;
import it.unibo.oop18.cfc.Util.GameTimer;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

public class Cooker extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    private GameTimer timer;
    private Optional<IngredientImpl> food;
    private World world;
    private boolean isCooking;
    /**
     * Creates a generic {@code Station}.
     * 
     * @param position block's position
     * @param cookerTile   block's tile
     */
    public Cooker(final Position position, final CookerTile cookerTile) {
        super(position);
        this.food = Optional.empty();
        this.timer = new GameTimer();
        this.isCooking = false;
        this.graphicComponent = new CookerGraphicComponent(this, cookerTile);
    }

    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
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
        if(isCooking == true) {
            if (this.food.get().getState() == IngredientState.CHOPPED &&
                    timer.getSeconds() >= this.food.get().getIngredient().getTimeToCook()) {
                this.food.get().changeState(IngredientState.PERFECT);
            } else if(this.food.get().getState() == IngredientState.PERFECT &&
                    timer.getSeconds() >= this.food.get().getIngredient().getTimeToCook() + 5) {
                this.food.get().changeState(IngredientState.BURNED);
            } else if(this.food.get().getState() == IngredientState.BURNED &&
                    timer.getSeconds() >= this.food.get().getIngredient().getTimeToCook() + 10) {
                this.food.get().changeState(IngredientState.WASTE);
                this.world.removeItem(this.food.get());
                this.food = Optional.empty();
                this.isCooking = false;
                this.timer.reset();
            }
        }
    }

    public boolean isCooked() {
        return isCooking;
    }

    @Override
    public void doAction(World world) {
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
                        this.timer.stop();
                        this.isCooking = false;
                    }
                }
            } else {
                // se il player non ha niente in mano e l'ingrediente è cotto
                if (this.food.get().getState() == IngredientState.PERFECT) {
                    world.getPlayer().setItemInHand(this.food.get());
                    this.food = Optional.empty();
                    this.timer.stop();
                    this.isCooking = false;
                }
            }
        } else {
            // se non c'è cibo e ho in mano qualcosa che sia un ingrediente tagliato
            if (world.getPlayer().getItemInHand().isPresent()
                    && world.getPlayer().getItemInHand().get() instanceof IngredientImpl
                    && ((IngredientImpl)world.getPlayer().getItemInHand().get()).getState() == IngredientState.CHOPPED 
                    && ((IngredientImpl)world.getPlayer().getItemInHand().get()).getIngredient().getTimeToCook() != 0) {
                // aggiungi l'ingrediente nella station e toglilo dalla mano
                this.food = Optional.ofNullable((IngredientImpl) world.getPlayer().getItemInHand().get());
                world.getPlayer().removeItemInHand();
                this.timer.start();
                this.isCooking = true;
            }
        }

    }
}
