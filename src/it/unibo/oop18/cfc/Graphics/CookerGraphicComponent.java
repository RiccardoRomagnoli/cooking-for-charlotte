package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Main.GameEngine;
import it.unibo.oop18.cfc.Objects.Stations.Cooker;
import it.unibo.oop18.cfc.Tile.CookerTile;

public class CookerGraphicComponent implements GraphicsComponent {
    
    private static final int DIVISION_BY_ZERO_PROTECTION = 1;
    private static final int FRAME_DELAY = Math.round(GameEngine.FPS / 30) + DIVISION_BY_ZERO_PROTECTION;
    
    private final Cooker cooker;
    private final CookerTile cookerTile;
    private int frame;
    private int updateFrame;
    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param cooker the logic of the door
     * @param cookerTile door's sprite
     */
    public CookerGraphicComponent(final Cooker cooker, final CookerTile cookerTile) {
        this.cooker = cooker;
        this.cookerTile = cookerTile;
        this.frame = 0;
        this.updateFrame = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        if (this.cooker.isCooked()) {
            this.nextFrame();
            g.drawImage(this.cookerTile.getTiles().get(this.frame).getImage(), AffineTransform
                    .getTranslateInstance(this.cooker.getPosition().getX(), this.cooker.getPosition().getY()), null);
        } else {
            g.drawImage(this.cookerTile.getTiles().get(0).getImage(), AffineTransform
                    .getTranslateInstance(this.cooker.getPosition().getX(), this.cooker.getPosition().getY()), null);
        }
    }

    private void nextFrame() {
        this.updateFrame++;
        if (this.updateFrame % FRAME_DELAY == 0) {
            this.frame++;
            this.updateFrame = 0;
            this.frame = this.frame >= this.cookerTile.getTilesNumber() ? 0 : this.frame;
        }
    }

}
