package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.TrashcanGraphicComponent;
import it.unibo.oop18.cfc.tile.TrashcanTile;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

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
            world.getPlayer().removeItemInHand();
            JukeBoxUtil.play("trash.wav");
        }
    }
}
