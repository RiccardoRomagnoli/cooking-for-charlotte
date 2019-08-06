package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.MeatStationGraphicComponent;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientType;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Tile.MeatStationTile;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

/**
 * Managing of the place where food is processed.
 *
 */
public class MeatStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    /**
     * Constructor method.
     * @param position entity
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
            final IngredientImpl meat = new IngredientImpl(IngredientType.MEAT);
            world.addItem(meat);
            world.getPlayer().setItemInHand(meat);
        }
   }
}
