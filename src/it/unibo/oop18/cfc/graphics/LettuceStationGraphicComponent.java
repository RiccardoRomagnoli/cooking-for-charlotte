package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.stations.LettuceStation;
import it.unibo.oop18.cfc.tile.LettuceStationTile;

/**
 * The Class LettuceStationGraphicComponent.
 */
public class LettuceStationGraphicComponent implements GraphicsComponent {

    private final LettuceStation lettuceStation;
    private final LettuceStationTile lettuceStationTile;

    /**
     * Instantiates a new {@link LettuceStationGraphicComponent}.
     *
     * @param lettuceStation     the {@link LettuceStation}
     * @param lettuceStationTile the {@link LettuceStationTile} to draw
     */
    public LettuceStationGraphicComponent(final LettuceStation lettuceStation,
            final LettuceStationTile lettuceStationTile) {
        this.lettuceStation = lettuceStation;
        this.lettuceStationTile = lettuceStationTile;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        g.drawImage(this.lettuceStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.lettuceStation.getPosition().getX(), this.lettuceStation.getPosition().getY()), null);
    }
}
