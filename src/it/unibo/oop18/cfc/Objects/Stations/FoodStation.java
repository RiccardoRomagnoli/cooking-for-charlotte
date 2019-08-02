package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.FoodStationGraphicComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Tile.FoodStationTile;
import it.unibo.oop18.cfc.Util.Position;

public class FoodStation extends AbstractStationObject{

    private final GraphicsComponent graphicComponent;
    
    public FoodStation(final Position position, final FoodStationTile foodStationTile) {
        super(position);
        this.graphicComponent = new FoodStationGraphicComponent(this, foodStationTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

}