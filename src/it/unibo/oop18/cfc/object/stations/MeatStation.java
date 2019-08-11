package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.MeatStationGraphicComponent;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.tile.MeatStationTile;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where food is processed.
 *
 */
public class MeatStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;

    /**
     * Constructor method.
     * 
     * @param position        entity
     * @param meatStationTile image
     */
    public MeatStation(final Position position, final MeatStationTile meatStationTile) {
        super(position);
        this.graphicComponent = new MeatStationGraphicComponent(this, meatStationTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    @Override
    public void doAction(final World world) {
        if (!world.getPlayer().getItemInHand().isPresent()) {
            final IngredientImpl meat = new IngredientImpl(world.getItemManager(), IngredientType.MEAT);
            world.getPlayer().setItemInHand(meat);
        }
    }
}
