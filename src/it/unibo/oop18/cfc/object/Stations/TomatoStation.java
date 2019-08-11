package it.unibo.oop18.cfc.object.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.TomatoStationGraphicComponent;
import it.unibo.oop18.cfc.object.Items.IngredientImpl;
import it.unibo.oop18.cfc.object.Items.IngredientType;
import it.unibo.oop18.cfc.tile.TomatoStationTile;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where food is processed.
 *
 */
public class TomatoStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    /**
     * Constructor method.
     * @param position entity
     * @param tomatoStationTile image
     */
    public TomatoStation(final Position position, final TomatoStationTile tomatoStationTile) {
        super(position);
        this.graphicComponent = new TomatoStationGraphicComponent(this, tomatoStationTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    @Override
    public void doAction(final World world) {
        if (!world.getPlayer().getItemInHand().isPresent()) {
            final IngredientImpl tomato = new IngredientImpl(world.getItemManager(), IngredientType.TOMATO);
            world.getPlayer().setItemInHand(tomato);
        }
    }
}
