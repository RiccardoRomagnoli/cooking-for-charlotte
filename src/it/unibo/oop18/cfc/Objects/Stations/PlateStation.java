package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Graphics.PlateStationGraphicComponent;
import it.unibo.oop18.cfc.Tile.PlateStationTile;
import it.unibo.oop18.cfc.Util.Position;

public class PlateStation extends AbstractStationObject{

    private final GraphicsComponent graphicComponent;
    
    public PlateStation(final Position position, final PlateStationTile plateStationTile) {
        super(position);
        this.graphicComponent = new PlateStationGraphicComponent(this, plateStationTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

}
