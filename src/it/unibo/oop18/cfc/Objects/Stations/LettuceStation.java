package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Graphics.LettuceStationGraphicComponent;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientType;
import it.unibo.oop18.cfc.Tile.LettuceStationTile;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

/**
 * Managing of the place where food is processed.
 *
 */
public class LettuceStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    /**
     * Constructor method.
     * @param position entity
     * @param lettuceStationTile image
     */
    public LettuceStation(final Position position, final LettuceStationTile lettuceStationTile) {
        super(position);
        this.graphicComponent = new LettuceStationGraphicComponent(this, lettuceStationTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    @Override
    public void doAction(final World world) {
        if (!world.getPlayer().getItemInHand().isPresent()) {
            final IngredientImpl lettuce = new IngredientImpl(world.getItemManager(), IngredientType.LETTUCE);
            world.getPlayer().setItemInHand(lettuce);
        }
    }

}
