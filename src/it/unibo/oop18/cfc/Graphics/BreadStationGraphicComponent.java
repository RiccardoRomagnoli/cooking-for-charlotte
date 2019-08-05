package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.Stations.BreadStation;
import it.unibo.oop18.cfc.Tile.BreadStationTile;

public class BreadStationGraphicComponent implements GraphicsComponent {

    private final BreadStation breadStation;
    private final BreadStationTile breadStationTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param breadStation       the logic of the door
     * @param breadStationTile door's sprite
     */
    public BreadStationGraphicComponent(final BreadStation breadStation, final BreadStationTile breadStationTile) {
        this.breadStation = breadStation;
        this.breadStationTile = breadStationTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(this.breadStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.breadStation.getPosition().getX(), this.breadStation.getPosition().getY()), null);
    }
}
