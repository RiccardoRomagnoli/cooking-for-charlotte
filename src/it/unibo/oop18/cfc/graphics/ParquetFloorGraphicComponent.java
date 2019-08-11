package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.Floors.ParquetFloor;
import it.unibo.oop18.cfc.tile.ParquetFloorTile;

/**
 * The Class ParquetFloorGraphicComponent.
 */
public class ParquetFloorGraphicComponent implements GraphicsComponent {

    private final ParquetFloor parquetFloor;
    private final ParquetFloorTile parquetFloorTile;

    /**
     * Instantiates a new parquet floor graphic component.
     *
     * @param parquetFloor the parquet floor
     * @param parquetFloorTile the parquet floor tile
     */
    public ParquetFloorGraphicComponent(final ParquetFloor parquetFloor, final ParquetFloorTile parquetFloorTile) {
        this.parquetFloor = parquetFloor;
        this.parquetFloorTile = parquetFloorTile;
    }


    /**
     * {@inheritDoc}.
     *
     * @param g the g
     */
    public void draw(final Graphics2D g) {
        if(this.parquetFloor.isLeftFloor()) {
            g.drawImage(this.parquetFloorTile.getTiles().get(0).getImage(), AffineTransform
                    .getTranslateInstance(this.parquetFloor.getPosition().getX(), this.parquetFloor.getPosition().getY()), null);

        }else {
            g.drawImage(this.parquetFloorTile.getTiles().get(1).getImage(), AffineTransform
                    .getTranslateInstance(this.parquetFloor.getPosition().getX(), this.parquetFloor.getPosition().getY()), null);

        }
    }
}
