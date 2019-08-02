package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.Stations.ChoppingStation;
import it.unibo.oop18.cfc.Tile.ChoppingStationTile;


public class ChoppingStationGraphicComponent implements GraphicsComponent{
    private final ChoppingStation choppingStation;
    private final ChoppingStationTile choppingStationTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param door the logic of the door
     * @param doorSprite door's sprite
     */
    public ChoppingStationGraphicComponent(final ChoppingStation choppingStation, final ChoppingStationTile choppingStationTile) {
        this.choppingStation = choppingStation;
        this.choppingStationTile = choppingStationTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        if (this.choppingStation.isCut()) {
            g.drawImage(this.choppingStationTile.getTiles().get(0).getImage(),
                    AffineTransform.getTranslateInstance(this.choppingStation.getPosition().getX(), this.choppingStation.getPosition().getY()),
                    null);
        } else {
            g.drawImage(this.choppingStationTile.getTiles().get(1).getImage(),
                    AffineTransform.getTranslateInstance(this.choppingStation.getPosition().getX(), this.choppingStation.getPosition().getY()),
                    null);
        }
    }
}
