package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.TomatoStationGraphicComponent;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.tile.TomatoStationTile;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where tomato is generated.
 *
 */
public class TomatoStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;

    /**
     * Instantiates a new {@link TomatoStation}.
     *
     * @param position          the {@link Position}
     * @param tomatoStationTile the {@link TomatoStationTile} to draw
     */
    public TomatoStation(final Position position, final TomatoStationTile tomatoStationTile) {
        super(position);
        this.graphicComponent = new TomatoStationGraphicComponent(this, tomatoStationTile);
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    /**
     * {@inheritDoc}
     */
    public void doAction(final World world) {
        if (!world.getPlayer().getItemInHand().isPresent()) {
            final IngredientImpl tomato = new IngredientImpl(world.getItemManager(), IngredientType.TOMATO);
            world.getPlayer().setItemInHand(tomato);
        }
    }
}
