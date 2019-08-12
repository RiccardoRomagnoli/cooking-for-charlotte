package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.BreadStationGraphicComponent;
import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.tile.BreadStationTile;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where bread is generated.
 *
 */
public class BreadStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;

    /**
     * Instantiates a new {@link BreadStation}.
     *
     * @param position         the {@link Position}
     * @param breadStationTile the {@link BreadStationTile} to draw
     */
    public BreadStation(final Position position, final BreadStationTile breadStationTile) {
        super(position);
        this.graphicComponent = new BreadStationGraphicComponent(this, breadStationTile);
    }

    /**
     * {@inheritDoc}.
     */
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    /**
     * {@inheritDoc}.
     */
    public void doAction(final World world) {
        if (!world.getPlayer().getItemInHand().isPresent()) {
            final IngredientImpl bread = new IngredientImpl(world.getItemManager(), IngredientType.BREAD);
            world.getPlayer().setItemInHand(bread);
        }
    }
}
