package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.floors.ParquetFloor;
import it.unibo.oop18.cfc.tile.ParquetFloorTile;
import it.unibo.oop18.cfc.tile.TileSheet;
import it.unibo.oop18.cfc.tilemap.TileType;

/**
 * The Class ParquetFloorGraphicComponent.
 */
public class ParquetFloorGraphicComponent implements GraphicsComponent {

    private final ParquetFloor parquetFloor;
    private final ParquetFloorTile parquetFloorTile;

    /**
     * Instantiates a new parquet floor graphic component.
     *
     * @param parquetFloor     the parquet floor
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
        if (this.parquetFloor.getPosition().getX() % (TileSheet.TILE_SIZE_IN_GAME * 2) == 0) {
            g.drawImage(this.parquetFloorTile.getTiles().get(TileType.PARQUETRIGHTFLOOR.getPosX()).getImage(),
                    AffineTransform.getTranslateInstance(this.parquetFloor.getPosition().getX(),
                            this.parquetFloor.getPosition().getY()),
                    null);

        } else {
            g.drawImage(this.parquetFloorTile.getTiles().get(TileType.PARQUETLEFTFLOOR.getPosX()).getImage(),
                    AffineTransform.getTranslateInstance(this.parquetFloor.getPosition().getX(),
                            this.parquetFloor.getPosition().getY()),
                    null);
        }
    }
}
