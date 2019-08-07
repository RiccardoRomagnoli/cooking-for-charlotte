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
        if (this.counter.getItem().isPresent()) {
            if (this.counter.getItem().get() instanceof PlateImpl) {
                g.drawImage(this.counterTile.getTiles().get(1).getImage(), AffineTransform.getTranslateInstance(
                        this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);

            } else if (this.counter.getItem().get() instanceof IngredientImpl) {
                switch (((IngredientImpl) this.counter.getItem().get()).getIngredient()) {
                case BREAD:
                    g.drawImage(this.counterTile.getTiles().get(2).getImage(), AffineTransform.getTranslateInstance(
                            this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);
                    break;
                case MEAT:
                    g.drawImage(this.counterTile.getTiles().get(3).getImage(), AffineTransform.getTranslateInstance(
                            this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);
                    break;
                case TOMATO:
                    g.drawImage(this.counterTile.getTiles().get(5).getImage(), AffineTransform.getTranslateInstance(
                            this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);
                    break;
                case LETTUCE:
                    g.drawImage(this.counterTile.getTiles().get(4).getImage(), AffineTransform.getTranslateInstance(
                            this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);
                    break;
                default:
                    break;
                }
            }
        } else {
            g.drawImage(this.counterTile.getTiles().get(0).getImage(), AffineTransform
                    .getTranslateInstance(this.counter.getPosition().getX(), this.counter.getPosition().getY()), null);
        }
    }
}
