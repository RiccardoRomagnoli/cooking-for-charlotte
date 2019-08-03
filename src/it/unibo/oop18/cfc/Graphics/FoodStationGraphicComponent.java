package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.Stations.FoodStation;
import it.unibo.oop18.cfc.Tile.FoodStationTile;

public class FoodStationGraphicComponent implements GraphicsComponent {
    private final FoodStation foodStation;
    private final FoodStationTile foodStationTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param foodStation       the logic of the door
     * @param foodStationTile door's sprite
     */
    public FoodStationGraphicComponent(final FoodStation foodStation, final FoodStationTile foodStationTile) {
        this.foodStation = foodStation;
        this.foodStationTile = foodStationTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(this.foodStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.foodStation.getPosition().getX(), this.foodStation.getPosition().getY()), null);
    }
}
