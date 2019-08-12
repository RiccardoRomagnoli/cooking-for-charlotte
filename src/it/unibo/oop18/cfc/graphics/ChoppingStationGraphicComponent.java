package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.object.stations.ChoppingStation;
import it.unibo.oop18.cfc.sprite.LoadingSprite;
import it.unibo.oop18.cfc.tile.ChoppingStationTile;
import it.unibo.oop18.cfc.util.Position;

/**
 * The Class ChoppingStationGraphicComponent.
 */
public class ChoppingStationGraphicComponent implements GraphicsComponent {

    private static final int DIVISION_BY_ZERO_PROTECTION = 1;
    private static final int FRAME_DELAY = Math.round(GameEngine.FPS / 15) + DIVISION_BY_ZERO_PROTECTION;
    private static final int POSITION_X_INGREDIENT = 16;
    private static final int POSITION_Y_INGREDIENT = 2;
    private static final int DIM_INGREDIENT = 25;
    private static final int POSITION_X_BAR = 815;
    private static final int POSITION_Y_BAR = 680;
    private static final double WIDTH_BAR = 160.0;
    private static final int HEIGHT_BAR = 24;
    private final ChoppingStation choppingStation;
    private final ChoppingStationTile choppingStationTile;
    private final LoadingSprite loadingSprite;
    private int frame;
    private int updateFrame;

    /**
     * Instantiates a new {@link ChoppingStationGraphicComponent}.
     *
     * @param choppingStation     the {@link ChoppingStation}
     * @param choppingStationTile the {@link ChoppingStationTile} to draw
     * @param loadingSprite       the {@link LoadingSprite} to draw
     */
    public ChoppingStationGraphicComponent(final ChoppingStation choppingStation,
            final ChoppingStationTile choppingStationTile, final LoadingSprite loadingSprite) {
        this.choppingStation = choppingStation;
        this.loadingSprite = loadingSprite;
        this.choppingStationTile = choppingStationTile;
        this.frame = 0;
        this.updateFrame = 0;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        if (this.choppingStation.isCut()) {
            this.nextFrame();
            g.drawImage(this.choppingStationTile.getTiles().get(this.frame).getImage(),
                    AffineTransform.getTranslateInstance(this.choppingStation.getPosition().getX(),
                            this.choppingStation.getPosition().getY()),
                    null);
        } else {
            g.drawImage(this.choppingStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                    this.choppingStation.getPosition().getX(), this.choppingStation.getPosition().getY()), null);
        }
        if (this.choppingStation.getFood().isPresent()) {
            this.choppingStation.getFood().get().draw(g,
                    new Position(choppingStation.getPosition().getX() + POSITION_X_INGREDIENT,
                            choppingStation.getPosition().getY() + POSITION_Y_INGREDIENT),
                    DIM_INGREDIENT, DIM_INGREDIENT);
        }
        if (this.choppingStation.getFood().isPresent() && this.choppingStation.isCut()) {
            g.drawImage(loadingSprite.getLoadingSprite().get(0).getImage(), POSITION_X_BAR, POSITION_Y_BAR,
                    (int) ((WIDTH_BAR / (this.choppingStation.getFood().get().getIngredient().getTimeToCut() * 1000))
                            * this.choppingStation.getChoppingStationTimer().getTimeMillis()),
                    HEIGHT_BAR, null);

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
