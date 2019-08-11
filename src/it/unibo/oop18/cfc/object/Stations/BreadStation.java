package it.unibo.oop18.cfc.object.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.BreadStationGraphicComponent;
import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.object.Items.IngredientImpl;
import it.unibo.oop18.cfc.object.Items.IngredientType;
import it.unibo.oop18.cfc.tile.BreadStationTile;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where food is processed.
 *
 */
public class BreadStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    /**
     * Constructor method.
     * @param position entity
     * @param breadStationTile image
     */
    public BreadStation(final Position position, final BreadStationTile breadStationTile) {
        super(position);
        this.graphicComponent = new BreadStationGraphicComponent(this, breadStationTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    @Override
    public void doAction(final World world) {
        if (!world.getPlayer().getItemInHand().isPresent()) {
            final IngredientImpl bread = new IngredientImpl(world.getItemManager(), IngredientType.BREAD);
            world.getPlayer().setItemInHand(bread);
        }
    }
}