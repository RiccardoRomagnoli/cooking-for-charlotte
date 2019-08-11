package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.DeliveryStationGraphicComponent;
import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.object.Items.Plate;
import it.unibo.oop18.cfc.tile.DeliveryStationTile;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

public class DeliveryStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;

    public DeliveryStation(final Position position, final DeliveryStationTile deliveryStationTile) {
        super(position);
        this.graphicComponent = new DeliveryStationGraphicComponent(this, deliveryStationTile);
    }

    @Override
    public void draw(Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    @Override
    public void doAction(World world) {
        if (world.getPlayer().getItemInHand().isPresent() && world.getPlayer().getItemInHand().get() instanceof Plate) {
            world.getOrdersManager().deliveryPlate((Plate) world.getPlayer().getItemInHand().get());
            world.getPlayer().removeItemInHand();
        }
    }

}
