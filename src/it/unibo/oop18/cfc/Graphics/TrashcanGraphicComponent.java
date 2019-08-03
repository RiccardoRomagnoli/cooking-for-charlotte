package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.Stations.Trashcan;
import it.unibo.oop18.cfc.Tile.TrashcanTile;

public class TrashcanGraphicComponent implements GraphicsComponent {
    private final Trashcan trashcan;
    private final TrashcanTile trashcanTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param trashcan     the logic of the door
     * @param trashcanTile door's sprite
     */
    public TrashcanGraphicComponent(final Trashcan trashcan, final TrashcanTile trashcanTile) {
        this.trashcan = trashcan;
        this.trashcanTile = trashcanTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(this.trashcanTile.getTiles().get(0).getImage(), AffineTransform
                .getTranslateInstance(this.trashcan.getPosition().getX(), this.trashcan.getPosition().getY()), null);
    }
}
