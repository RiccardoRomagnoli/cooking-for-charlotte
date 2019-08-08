package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Graphics.TrashcanGraphicComponent;
import it.unibo.oop18.cfc.Objects.Items.Item;
import it.unibo.oop18.cfc.Tile.TrashcanTile;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

public class Trashcan extends AbstractStationObject{

    private final GraphicsComponent graphicComponent;

    public Trashcan(final Position position, final TrashcanTile trashcanTile) {
        super(position);
        this.graphicComponent = new TrashcanGraphicComponent(this, trashcanTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    @Override
    public void doAction(World world) {
        if (world.getPlayer().getItemInHand().isPresent()) {
            Item i = world.getPlayer().getItemInHand().get();
            world.getPlayer().removeItemInHand();
        }
    }
}
