package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.TomatoStationGraphicComponent;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientType;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Tile.TomatoStationTile;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

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
            final IngredientImpl tomato = new IngredientImpl(IngredientType.TOMATO);
            world.addItem(tomato);
            world.getPlayer().setItemInHand(tomato);
        }
    }

}
