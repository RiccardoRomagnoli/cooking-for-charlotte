package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.WashbasinGraphicComponent;
import it.unibo.oop18.cfc.object.items.PlateImpl;
import it.unibo.oop18.cfc.tile.WashbasinTile;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Managing of the place where plate is washed.
 */
public class Washbasin extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;


    /**
     * Instantiates a new {@link Washbasin}.
     *
     * @param position the {@link Position}
     * @param washbasinTile the {@link WashbasinTile}
     */
    public Washbasin(final Position position, final WashbasinTile washbasinTile) {
        super(position);
        this.graphicComponent = new WashbasinGraphicComponent(this, washbasinTile);
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
        if (world.getPlayer().getItemInHand().isPresent()
                && world.getPlayer().getItemInHand().get() instanceof PlateImpl) {
            ((PlateImpl) world.getPlayer().getItemInHand().get()).wash();
            JukeBoxUtil.play("trash.wav");
        }
    }
}
