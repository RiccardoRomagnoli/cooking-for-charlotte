package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.DeliveryStationGraphicComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Objects.Items.Plate;
import it.unibo.oop18.cfc.Tile.DeliveryStationTile;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

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
