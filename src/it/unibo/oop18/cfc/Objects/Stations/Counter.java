package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.Graphics.CounterGraphicComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientType;
import it.unibo.oop18.cfc.Objects.Items.Item;
import it.unibo.oop18.cfc.Objects.Items.PlateImpl;
import it.unibo.oop18.cfc.Tile.CounterTile;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

public class Counter extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    private Optional<Item> item;

    public Counter(final Position position, final CounterTile counterTile) {
        super(position);
        this.item = Optional.empty();
        this.graphicComponent = new CounterGraphicComponent(this, counterTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    public Optional<Item> getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = Optional.ofNullable(item);
    }

    public void removeItem() {
        this.item = Optional.empty();
    }

    @Override
    public void doAction(World world) {
        // Se la station ha un oggetto
        if (item.isPresent()) {
            // se il player ha qualcosa in mano
            if (world.getPlayer().getItemInHand().isPresent()) {
                // se quel qualcosa è un piatto
                if (world.getPlayer().getItemInHand().get() instanceof PlateImpl) {
                    PlateImpl plate = (PlateImpl) world.getPlayer().getItemInHand().get();
                    // se la station ha un ingrediente
                    if (this.item.get() instanceof IngredientImpl) {
                        plate.addDish((IngredientImpl) this.item.get());
                        this.item = Optional.empty();
                    }
                } else if (world.getPlayer().getItemInHand().get() instanceof IngredientImpl) { // se ha un ingrediente in mano
                    // se la station ha un piatto 
                    //!!!!!miss check max plate size
                    if (this.item.get() instanceof PlateImpl) {
                        ((PlateImpl) this.item.get()).addDish((IngredientImpl)world.getPlayer().getItemInHand().get());
                        world.getPlayer().removeItemInHand();
                    }
                }
            } else {// se il player non ha niente in mano
                world.getPlayer().setItemInHand(item.get());
                this.removeItem();
            }
        } else {
            if (world.getPlayer().getItemInHand().isPresent()) {
                this.setItem(world.getPlayer().getItemInHand().get());
                world.getPlayer().removeItemInHand();
            }
        }
    }
}
