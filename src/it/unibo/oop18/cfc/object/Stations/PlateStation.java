package it.unibo.oop18.cfc.object.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.PlateStationGraphicComponent;
import it.unibo.oop18.cfc.object.Items.PlateImpl;
import it.unibo.oop18.cfc.tile.PlateStationTile;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

public class PlateStation extends AbstractStationObject{

    private final GraphicsComponent graphicComponent;
    
    public PlateStation(final Position position, final PlateStationTile plateStationTile) {
        super(position);
        this.graphicComponent = new PlateStationGraphicComponent(this, plateStationTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    @Override
    public void doAction(final World world) {
        if (!world.getPlayer().getItemInHand().isPresent()) {
            final PlateImpl plate = new PlateImpl(world.getItemManager());
            world.getPlayer().setItemInHand(plate);
        }
    }

}
