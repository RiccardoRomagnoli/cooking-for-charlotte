package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Graphics.StationObjectGraphicComponent;
import it.unibo.oop18.cfc.TileMap.Tile;
import it.unibo.oop18.cfc.Util.Position;

public class Trashcan extends AbstractStationObject{

    private final GraphicsComponent graphicComponent;

    public Trashcan(final Position position, final Tile tile) {
        super(position);
        this.graphicComponent = new StationObjectGraphicComponent(this, tile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }
}
