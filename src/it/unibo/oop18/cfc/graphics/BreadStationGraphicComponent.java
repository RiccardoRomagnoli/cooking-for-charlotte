package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.stations.BreadStation;
import it.unibo.oop18.cfc.tile.BreadStationTile;

/**
 * The Class BreadStationGraphicComponent.
 */
public class BreadStationGraphicComponent implements GraphicsComponent {

    private final BreadStation breadStation;
    private final BreadStationTile breadStationTile;

    /**
     * Instantiates a new {@link BreadStationGraphicComponent}.
     *
     * @param breadStation     the {@link BreadStation}
     * @param breadStationTile the {@link BreadStationTile} to draw
     */
    public BreadStationGraphicComponent(final BreadStation breadStation, final BreadStationTile breadStationTile) {
        this.breadStation = breadStation;
        this.breadStationTile = breadStationTile;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        g.drawImage(this.breadStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.breadStation.getPosition().getX(), this.breadStation.getPosition().getY()), null);
    }
}
