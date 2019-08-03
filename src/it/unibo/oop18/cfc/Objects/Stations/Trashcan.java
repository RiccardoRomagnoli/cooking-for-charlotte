package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Graphics.TrashcanGraphicComponent;
import it.unibo.oop18.cfc.Tile.TrashcanTile;
import it.unibo.oop18.cfc.Util.Position;

public class Trashcan extends AbstractStationObject{

    private final GraphicsComponent graphicComponent;

    public Trashcan(final Position position, final TrashcanTile trashcanTile) {
        super(position);
        this.graphicComponent = new TrashcanGraphicComponent(this, trashcanTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }
}
