package it.unibo.oop18.cfc.object.stations;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.WashbasinGraphicComponent;
import it.unibo.oop18.cfc.object.items.PlateImpl;
import it.unibo.oop18.cfc.tile.WashbasinTile;
import it.unibo.oop18.cfc.util.GameTimer;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

public class Washbasin extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    private GameTimer timer;
    private Optional<PlateImpl> plate;

    /**
     * Creates a generic {@code Station}.
     * 
     * @param position block's position
     * @param tile   block's tile
     */
    public Washbasin(final Position position, final WashbasinTile washbasinTile) {
        super(position);
        this.plate = Optional.empty();
        this.timer = new GameTimer();
        this.graphicComponent = new WashbasinGraphicComponent(this, washbasinTile);
    }

    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    public Optional<PlateImpl> getPlate() {
        return this.plate;
    }

    public Optional<PlateImpl> takeItem() {
        final Optional<PlateImpl> p = plate;
        this.plate = Optional.empty();
        return p;
    };

    public void setItem(PlateImpl p) {
        this.plate = Optional.ofNullable(p);
        timer.start();
    };

    public void update() {

    }

    public boolean isWashed() {
        return false;
    }

    public void doAction(World world) {
        if (world.getPlayer().getItemInHand().isPresent() &&
                world.getPlayer().getItemInHand().get() instanceof PlateImpl) {
            ((PlateImpl) world.getPlayer().getItemInHand().get()).wash();
        }
    }
}

