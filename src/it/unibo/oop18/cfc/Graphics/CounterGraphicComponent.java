package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Tile.TileSheet;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.Main.GameEngine;
import it.unibo.oop18.cfc.Objects.Stations.Counter;
import it.unibo.oop18.cfc.Tile.CounterTile;

public class CounterGraphicComponent implements GraphicsComponent {
    private final Counter counter;
    private final CounterTile counterTile;

    private static final int POSITION_X_ITEM = 8;
    private static final int POSITION_Y_ITEM = -2;
    private static final int HEIGHT_ITEM = 30;
    private static final int WIDTH_ITEM = 30;
    private static final int POSITION_X_ITEM1 = 5;
    private static final int POSITION_Y_ITEM1 = 13;

    /** 
     * Creates a CounterGraphicComponent.
     * 
     * @param counter Object Station
     * @param counterTile Tile of the Station
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
                g.drawImage(this.counterTile.getTiles().get(2).getImage(), AffineTransform.getTranslateInstance(
                        this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);

            } else {
                g.drawImage(this.counterTile.getTiles().get(1).getImage(), AffineTransform.getTranslateInstance(
                        this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);
                if (this.counter.getItem().isPresent()) {
                    this.counter.getItem().get().draw(g,
                            new Position(counter.getPosition().getX() + POSITION_X_ITEM1,
                                    counter.getPosition().getY() + POSITION_Y_ITEM1),
                            WIDTH_ITEM, HEIGHT_ITEM);
                }
            }
        } else {
            g.drawImage(this.counterTile.getTiles().get(0).getImage(), AffineTransform
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
