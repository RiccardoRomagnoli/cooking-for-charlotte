package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.Floors.ParquetFloor;
import it.unibo.oop18.cfc.tile.ParquetFloorTile;

public class ParquetFloorGraphicComponent implements GraphicsComponent {

    private final ParquetFloor parquetFloor;
    private final ParquetFloorTile parquetFloorTile;

    public ParquetFloorGraphicComponent(final ParquetFloor parquetFloor, final ParquetFloorTile parquetFloorTile) {
        this.parquetFloor = parquetFloor;
        this.parquetFloorTile = parquetFloorTile;
    }

    @Override
    public void draw(Graphics2D g) {
        if(this.parquetFloor.isLeftFloor() == true) {
            g.drawImage(this.parquetFloorTile.getTiles().get(0).getImage(), AffineTransform
                    .getTranslateInstance(this.parquetFloor.getPosition().getX(), this.parquetFloor.getPosition().getY()), null);

        }else {
            g.drawImage(this.parquetFloorTile.getTiles().get(1).getImage(), AffineTransform
                    .getTranslateInstance(this.parquetFloor.getPosition().getX(), this.parquetFloor.getPosition().getY()), null);

        }
    }
}
