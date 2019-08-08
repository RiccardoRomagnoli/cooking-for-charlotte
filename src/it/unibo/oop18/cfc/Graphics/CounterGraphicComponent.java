package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.PlateImpl;
import it.unibo.oop18.cfc.Objects.Stations.Counter;
import it.unibo.oop18.cfc.Tile.CounterTile;

public class CounterGraphicComponent implements GraphicsComponent {
    private final Counter counter;
    private final CounterTile counterTile;

    /**
     * Creates a CounterGraphicComponent
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
        if (this.counter.getPosition().getX() == 0 || this.counter.getPosition().getX() == 960) {
            if (this.counter.getPosition().getY() == 576) {
                g.drawImage(this.counterTile.getTiles().get(2).getImage(), AffineTransform.getTranslateInstance(
                        this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);
            } else {
                g.drawImage(this.counterTile.getTiles().get(1).getImage(), AffineTransform.getTranslateInstance(
                        this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);
            }
        } else {
            g.drawImage(this.counterTile.getTiles().get(0).getImage(), AffineTransform
                    .getTranslateInstance(this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);
        }

        if (this.counter.getItem().isPresent()) {
            this.counter.getItem().get().draw(g, this.counter.getPosition());
        }
    }
}
