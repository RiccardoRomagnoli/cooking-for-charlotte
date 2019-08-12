package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.PlateStationGraphicComponent;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.PlateImpl;
import it.unibo.oop18.cfc.tile.PlateStationTile;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where plate is generated.
 */
public class PlateStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;

    /**
     * Instantiates a new {@link PlateStation}.
     *
     * @param position the {@link Position}
     * @param plateStationTile the {@link PlateStationTile} to draw
     */
    public PlateStation(final Position position, final PlateStationTile plateStationTile) {
        super(position);
        this.graphicComponent = new PlateStationGraphicComponent(this, plateStationTile);
    }

    /**
    * {@inheritDoc}
    */
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    /**
    * {@inheritDoc}
    */
    public void doAction(final World world) {
        if (!world.getPlayer().getItemInHand().isPresent()) {
            final PlateImpl plate = new PlateImpl(world.getItemManager());
            world.getPlayer().setItemInHand(plate);
        } else if (world.getPlayer().getItemInHand().isPresent()
                && world.getPlayer().getItemInHand().get() instanceof IngredientImpl) {
            final PlateImpl plate = new PlateImpl(world.getItemManager());
            plate.addDish((IngredientImpl) world.getPlayer().getItemInHand().get());
            world.getPlayer().removeItemInHand();
            world.getPlayer().setItemInHand(plate);
        }
    }

}
