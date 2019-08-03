package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.GameObject;
import it.unibo.oop18.cfc.Objects.Stations.FoodStation;
import it.unibo.oop18.cfc.Objects.Stations.PlateStation;
import it.unibo.oop18.cfc.Tile.FoodStationTile;
import it.unibo.oop18.cfc.Tile.PlateStationTile;
import it.unibo.oop18.cfc.Tile.Tile;

/**
 * This class represents still object's graphic component and models
 * {@link GraphicsComponent}.
 */
public class PlateStationGraphicComponent implements GraphicsComponent {
    private final PlateStation plateStation;
    private final PlateStationTile plateStationTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param plateStation     the logic of the door
     * @param plateStationTile door's sprite
     */
    public PlateStationGraphicComponent(final PlateStation plateStation, final PlateStationTile plateStationTile) {
        this.plateStation = plateStation;
        this.plateStationTile = plateStationTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(this.plateStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.plateStation.getPosition().getX(), this.plateStation.getPosition().getY()), null);
    }
}
