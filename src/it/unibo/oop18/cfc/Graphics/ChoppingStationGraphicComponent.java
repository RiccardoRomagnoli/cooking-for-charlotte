package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Main.GameEngine;
import it.unibo.oop18.cfc.Objects.Stations.ChoppingStation;
import it.unibo.oop18.cfc.Tile.ChoppingStationTile;
import it.unibo.oop18.cfc.Tile.TileSheet;
import it.unibo.oop18.cfc.Util.Position;


public class ChoppingStationGraphicComponent implements GraphicsComponent {

    private static final int DIVISION_BY_ZERO_PROTECTION = 1;
    private static final int FRAME_DELAY = Math.round(GameEngine.FPS / 15) + DIVISION_BY_ZERO_PROTECTION;

    private final ChoppingStation choppingStation;
    private final ChoppingStationTile choppingStationTile;
    private int frame;
    private int updateFrame;
    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param choppingStation the logic of the door
     * @param choppingStationTile door's sprite
     */
    public ChoppingStationGraphicComponent(final ChoppingStation choppingStation, final ChoppingStationTile choppingStationTile) {
        this.choppingStation = choppingStation;
        this.choppingStationTile = choppingStationTile;
        this.frame = 0;
        this.updateFrame = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        if (this.choppingStation.isCut()) {
            this.nextFrame();
            g.drawImage(this.choppingStationTile.getTiles().get(this.frame).getImage(),
                    AffineTransform.getTranslateInstance(this.choppingStation.getPosition().getX(), this.choppingStation.getPosition().getY()),
                    null);
        } else {
            g.drawImage(this.choppingStationTile.getTiles().get(0).getImage(),
                    AffineTransform.getTranslateInstance(this.choppingStation.getPosition().getX(), this.choppingStation.getPosition().getY()),
                    null);
        }
        if (this.choppingStation.getFood().isPresent()) {
            this.choppingStation.getFood().get().draw(g,
                    new Position(choppingStation.getPosition().getX() + TileSheet.TILE_SIZE_IN_GAME / 4,
                            choppingStation.getPosition().getY() + 28/2 - 25/2),
                    25, 25);
        }
    }

    private void nextFrame() {
        this.updateFrame++;
        if (this.updateFrame % FRAME_DELAY == 0) {
            this.frame++;
            this.updateFrame = 0;
            this.frame = this.frame >= this.choppingStationTile.getTilesNumber() ? 1 : this.frame;
        }
    }

}
