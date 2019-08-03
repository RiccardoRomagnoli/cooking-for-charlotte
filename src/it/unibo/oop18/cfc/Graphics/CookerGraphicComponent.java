package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.Stations.Cooker;
import it.unibo.oop18.cfc.Tile.CookerTile;

public class CookerGraphicComponent implements GraphicsComponent{
    private final Cooker cooker;
    private final CookerTile cookerTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param door the logic of the door
     * @param doorSprite door's sprite
     */
    public CookerGraphicComponent(final Cooker cooker, final CookerTile cookerTile) {
        this.cooker = cooker;
        this.cookerTile = cookerTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        if (this.cooker.isCooked()) {
            g.drawImage(this.cookerTile.getTiles().get(1).getImage(),
                    AffineTransform.getTranslateInstance(this.cooker.getPosition().getX(), this.cooker.getPosition().getY()),
                    null);
        } else {
            g.drawImage(this.cookerTile.getTiles().get(0).getImage(),
                    AffineTransform.getTranslateInstance(this.cooker.getPosition().getX(), this.cooker.getPosition().getY()),
                    null);
        }
    }
}
