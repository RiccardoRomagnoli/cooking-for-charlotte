package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.DeliveryStationGraphicComponent;
import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.object.items.Plate;
import it.unibo.oop18.cfc.tile.DeliveryStationTile;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where final plates are checked.
 *
 */
public class DeliveryStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;

    /**
     * Instantiates a new {@link DeliveryStation}.
     *
     * @param position            the {@link Position}
     * @param deliveryStationTile the {@link DeliveryStationTile} to draw
     */
    public DeliveryStation(final Position position, final DeliveryStationTile deliveryStationTile) {
        super(position);
        this.graphicComponent = new DeliveryStationGraphicComponent(this, deliveryStationTile);
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
        if (world.getPlayer().getItemInHand().isPresent() && world.getPlayer().getItemInHand().get() instanceof Plate) {
            world.getOrdersManager().deliveryPlate((Plate) world.getPlayer().getItemInHand().get());
            world.getPlayer().removeItemInHand();
        }
    }

}
