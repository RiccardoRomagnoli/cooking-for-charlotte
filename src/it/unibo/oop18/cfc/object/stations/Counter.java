package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;
import java.util.Optional;
import it.unibo.oop18.cfc.graphics.CounterGraphicComponent;
import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.Item;
import it.unibo.oop18.cfc.object.items.PlateImpl;
import it.unibo.oop18.cfc.tile.CounterTile;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where items are stored.
 *
 */
public class Counter extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    private Optional<Item> item;

    /**
     * Instantiates a new {@link Counter}.
     *
     * @param position the {@link Position}
     * @param counterTile the {@link CounterTile} to draw
     */
    public Counter(final Position position, final CounterTile counterTile) {
        super(position);
        this.item = Optional.empty();
        this.graphicComponent = new CounterGraphicComponent(this, counterTile);
    }

    /**
    * {@inheritDoc}
    */
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    /**
     * Gets the Optional {@link Item}.
     *
     * @return the Optional {@link Item}
     */
    public Optional<Item> getItem() {
        return item;
    }

    /**
     * Sets the Optional {@link Item}.
     *
     * @param item the {@link Item}
     */
    public void setItem(final Item item) {
        this.item = Optional.ofNullable(item);
    }

    /**
     * Removes the Optional {@link Item}.
     */
    public void removeItem() {
        this.item = Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    public void doAction(final World world) {
        // Se la station ha un oggetto
        if (item.isPresent()) {
            // se il player ha qualcosa in mano
            if (world.getPlayer().getItemInHand().isPresent()) {
                // e quel qualcosa è un piatto non pieno
                if (world.getPlayer().getItemInHand().get() instanceof PlateImpl
                        && ((PlateImpl) world.getPlayer().getItemInHand().get()).getIngredients().size() < 4) {
                    final PlateImpl plate = (PlateImpl) world.getPlayer().getItemInHand().get();
                    // e la station ha un ingrediente
                    if (this.item.get() instanceof IngredientImpl) {
                        //aggiungi l'ingrediente al piatto e svuota il counter
                        plate.addIngredient((IngredientImpl) this.item.get());
                        this.item = Optional.empty();
                    }
                    //se invece ho un ingrediente e il piatto sulla station non è pieno
                } else if (world.getPlayer().getItemInHand().get() instanceof IngredientImpl
                        && this.item.get() instanceof PlateImpl
                        && ((PlateImpl) this.item.get()).getIngredients().size() < 4) { 
                    // aggiungo l'ingrediente al piatto
                    ((PlateImpl) this.item.get()).addIngredient((IngredientImpl) world.getPlayer().getItemInHand().get());
                    world.getPlayer().removeItemInHand();
                }
            } else {
                // se il player non ha niente in mano prendo quello che c'è
                world.getPlayer().setItemInHand(item.get());
                this.removeItem();
            }
        } else {
            // se non c'è niente e io ho qualcosa lo appoggio li
            if (world.getPlayer().getItemInHand().isPresent()) {
                this.setItem(world.getPlayer().getItemInHand().get());
                world.getPlayer().removeItemInHand();
            }
        }
    }
}
