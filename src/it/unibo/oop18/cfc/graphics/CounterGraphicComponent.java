package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.object.stations.Counter;
import it.unibo.oop18.cfc.tile.CounterTile;
import it.unibo.oop18.cfc.tile.TileSheet;
import it.unibo.oop18.cfc.tilemap.TileType;
import it.unibo.oop18.cfc.util.Position;

/**
 * The Class CounterGraphicComponent.
 */
public class CounterGraphicComponent implements GraphicsComponent {
    private final Counter counter;
    private final CounterTile counterTile;

    private static final int POSITION_X_ITEM = 18;
    private static final int POSITION_Y_ITEM = -2;
    private static final int HEIGHT_ITEM = 30;
    private static final int WIDTH_ITEM = 30;
    private static final int POSITION_X_ITEM1 = 15;
    private static final int POSITION_Y_ITEM1 = 13;


    /**
     * Instantiates a new counter graphic component.
     *
     * @param counter the counter
     * @param counterTile the counter tile
     */
    public CounterGraphicComponent(final Counter counter, final CounterTile counterTile) {
        this.counter = counter;
        this.counterTile = counterTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        if (this.counter.getPosition().getX() == 0 || this.counter.getPosition().getX() == GameEngine.WIDTH - TileSheet.TILE_SIZE_IN_GAME) {
            if (this.counter.getPosition().getY() == GameEngine.HEIGHT2 - TileSheet.TILE_SIZE_IN_GAME) {
                g.drawImage(this.counterTile.getTiles().get(TileType.EDGECOUNTER.getPosX()).getImage(), AffineTransform.getTranslateInstance(
                        this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);

            } else {
                g.drawImage(this.counterTile.getTiles().get(TileType.BOARDERCOUNTER.getPosX()).getImage(), AffineTransform.getTranslateInstance(
                        this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);
                if (this.counter.getItem().isPresent()) {
                    this.counter.getItem().get().draw(g,
                            new Position(counter.getPosition().getX() + POSITION_X_ITEM1,
                                    counter.getPosition().getY() + POSITION_Y_ITEM1),
                            WIDTH_ITEM, HEIGHT_ITEM);
                }
            }
        } else {
            g.drawImage(this.counterTile.getTiles().get(TileType.COUNTER.getPosX()).getImage(), AffineTransform
                    .getTranslateInstance(this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);
            if (this.counter.getItem().isPresent()) {
                this.counter.getItem().get().draw(g,
                        new Position(counter.getPosition().getX() + POSITION_X_ITEM,
                                counter.getPosition().getY() + POSITION_Y_ITEM),
                        WIDTH_ITEM, HEIGHT_ITEM);
            }
        }
    }
}
