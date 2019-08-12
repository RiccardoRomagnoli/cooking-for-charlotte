package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.object.items.IngredientState;
import it.unibo.oop18.cfc.object.stations.Cooker;
import it.unibo.oop18.cfc.sprite.LoadingSprite;
import it.unibo.oop18.cfc.tile.CookerTile;
import it.unibo.oop18.cfc.util.Position;

/**
 * The Class CookerGraphicComponent.
 */
public class CookerGraphicComponent implements GraphicsComponent {

    private static final int DIVISION_BY_ZERO_PROTECTION = 1;
    private static final int FRAME_DELAY = Math.round(GameEngine.FPS / 30) + DIVISION_BY_ZERO_PROTECTION;

    private static final int POSITION_X_INGREDIENT = 33;
    private static final int POSITION_Y_INGREDIENT = 3;
    private static final int DIM_INGREDIENT = 20;
    private static final int POSITION_X_BAR = 19;
    private static final int POSITION_Y_BAR = 46;
    private static final double WIDTH_BAR = 28.0;
    private static final int HEIGHT_BAR = 6;

    private final Cooker cooker;
    private final CookerTile cookerTile;
    private final LoadingSprite loadingSprite;
    private int frame;
    private int updateFrame;

    /**
     * Instantiates a new cooker graphic component.
     *
     * @param cooker        the cooker
     * @param cookerTile    the cooker tile
     * @param loadingSprite the loading sprite
     */
    public CookerGraphicComponent(final Cooker cooker, final CookerTile cookerTile, final LoadingSprite loadingSprite) {
        this.cooker = cooker;
        this.cookerTile = cookerTile;
        this.loadingSprite = loadingSprite;
        this.frame = 0;
        this.updateFrame = 0;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        if (this.cooker.isCooking()) {
            this.nextFrame();
            g.drawImage(this.cookerTile.getTiles().get(this.frame).getImage(), AffineTransform
                    .getTranslateInstance(this.cooker.getPosition().getX(), this.cooker.getPosition().getY()), null);
        } else {
            g.drawImage(this.cookerTile.getTiles().get(0).getImage(), AffineTransform
                    .getTranslateInstance(this.cooker.getPosition().getX(), this.cooker.getPosition().getY()), null);
        }
        if (this.cooker.getFood().isPresent()) {
            this.cooker.getFood().get().draw(g, new Position(cooker.getPosition().getX() + POSITION_X_INGREDIENT,
                    cooker.getPosition().getY() + POSITION_Y_INGREDIENT), DIM_INGREDIENT, DIM_INGREDIENT);
        }
        if (this.cooker.getFood().isPresent() && this.cooker.isCooking()) {
            if (this.cooker.getFood().get().getState() == IngredientState.CHOPPED) {
                g.drawImage(loadingSprite.getLoadingSprite().get(1).getImage(),
                        (int) this.cooker.getPosition().getX() + POSITION_X_BAR,
                        (int) this.cooker.getPosition().getY() + POSITION_Y_BAR,
                        (int) ((WIDTH_BAR / (this.cooker.getFood().get().getIngredient().getTimeToCook() * 1000))
                                * this.cooker.getCookerTimer().getTimeMillis()),
                        HEIGHT_BAR, null);
            } else if (this.cooker.getFood().get().getState() == IngredientState.PERFECT) {
                g.drawImage(loadingSprite.getLoadingSprite().get(2).getImage(),
                        (int) this.cooker.getPosition().getX() + POSITION_X_BAR,
                        (int) this.cooker.getPosition().getY() + POSITION_Y_BAR,
                        (int) ((WIDTH_BAR / (5 * 1000)) * (this.cooker.getCookerTimer().getTimeMillis()
                                - (this.cooker.getFood().get().getIngredient().getTimeToCook() * 1000))),
                        HEIGHT_BAR, null);
            } else if (this.cooker.getFood().get().getState() == IngredientState.BURNED) {
                g.drawImage(loadingSprite.getLoadingSprite().get(3).getImage(),
                        (int) this.cooker.getPosition().getX() + POSITION_X_BAR,
                        (int) this.cooker.getPosition().getY() + POSITION_Y_BAR,
                        (int) ((WIDTH_BAR / (5 * 1000)) * (this.cooker.getCookerTimer().getTimeMillis()
                                - (this.cooker.getFood().get().getIngredient().getTimeToCook() * 1000) - 5000)),
                        HEIGHT_BAR, null);
            }
        }
    }

    private void nextFrame() {
        this.updateFrame++;
        if (this.updateFrame % FRAME_DELAY == 0) {
            this.frame++;
            this.updateFrame = 0;
            this.frame = this.frame >= this.cookerTile.getTilesNumber() ? 1 : this.frame;
        }
    }

}
