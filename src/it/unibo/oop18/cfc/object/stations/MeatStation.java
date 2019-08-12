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
 * Managing of the place where meat is generated.
 *
 */
public class MeatStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;


    /**
     * Instantiates a new {@link MeatStation}.
     *
     * @param position the {@link Position}
     * @param meatStationTile the {@link MeatStationTile} to draw
     */
    public MeatStation(final Position position, final MeatStationTile meatStationTile) {
        super(position);
        this.graphicComponent = new MeatStationGraphicComponent(this, meatStationTile);
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
            final IngredientImpl meat = new IngredientImpl(world.getItemManager(), IngredientType.MEAT);
            world.getPlayer().setItemInHand(meat);
        }
    }
}
