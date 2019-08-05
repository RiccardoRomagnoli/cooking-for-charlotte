package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.Stations.LettuceStation;
import it.unibo.oop18.cfc.Tile.LettuceStationTile;

public class LettuceStationGraphicComponent implements GraphicsComponent {

    private final LettuceStation lettuceStation;
    private final LettuceStationTile lettuceStationTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param lettuceStation       the logic of the door
     * @param lettuceStationTile door's sprite
     */
    public LettuceStationGraphicComponent(final LettuceStation lettuceStation, final LettuceStationTile lettuceStationTile) {
        this.lettuceStation = lettuceStation;
        this.lettuceStationTile = lettuceStationTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(this.lettuceStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.lettuceStation.getPosition().getX(), this.lettuceStation.getPosition().getY()), null);
    }
}
