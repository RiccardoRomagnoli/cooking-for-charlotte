package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.Stations.Counter;
import it.unibo.oop18.cfc.Tile.CounterTile;

public class CounterGraphicComponent implements GraphicsComponent {
    private final Counter counter;
    private final CounterTile counterTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param counter       the logic of the door
     * @param counterTile door's sprite
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
        g.drawImage(this.counterTile.getTiles().get(0).getImage(), AffineTransform
                .getTranslateInstance(this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);

    }
}
