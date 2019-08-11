package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.stations.Trashcan;
import it.unibo.oop18.cfc.tile.TrashcanTile;

/**
 * The Class TrashcanGraphicComponent.
 */
public class TrashcanGraphicComponent implements GraphicsComponent {
    private final Trashcan trashcan;
    private final TrashcanTile trashcanTile;


    /**
     * Instantiates a new trashcan graphic component.
     *
     * @param trashcan the trashcan
     * @param trashcanTile the trashcan tile
     */
    public TrashcanGraphicComponent(final Trashcan trashcan, final TrashcanTile trashcanTile) {
        this.trashcan = trashcan;
        this.trashcanTile = trashcanTile;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        g.drawImage(this.trashcanTile.getTiles().get(0).getImage(), AffineTransform
                .getTranslateInstance(this.trashcan.getPosition().getX(), this.trashcan.getPosition().getY()), null);
    }
}
