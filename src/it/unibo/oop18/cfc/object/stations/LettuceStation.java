package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.LettuceStationGraphicComponent;
import it.unibo.oop18.cfc.object.Items.IngredientImpl;
import it.unibo.oop18.cfc.object.Items.IngredientType;
import it.unibo.oop18.cfc.tile.LettuceStationTile;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where food is processed.
 *
 */
public class LettuceStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;

    /**
     * Instantiates a new lettuce station.
     *
     * @param position the position
     * @param lettuceStationTile the lettuce station tile
     */
    public LettuceStation(final Position position, final LettuceStationTile lettuceStationTile) {
        super(position);
        this.graphicComponent = new LettuceStationGraphicComponent(this, lettuceStationTile);
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
            final IngredientImpl lettuce = new IngredientImpl(world.getItemManager(), IngredientType.LETTUCE);
            world.getPlayer().setItemInHand(lettuce);
        }
    }

}
