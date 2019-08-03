package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.DeliveryStationGraphicComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Tile.DeliveryStationTile;
import it.unibo.oop18.cfc.Util.Position;

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

}
