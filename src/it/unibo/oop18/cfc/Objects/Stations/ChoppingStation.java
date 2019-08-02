package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Graphics.StationObjectGraphicComponent;
import it.unibo.oop18.cfc.Objects.Items.DishImpl;
import it.unibo.oop18.cfc.TileMap.Tile;
import it.unibo.oop18.cfc.Util.GameTimer;
import it.unibo.oop18.cfc.Util.Position;

public class ChoppingBoard extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    private GameTimer timer;
    private Optional<DishImpl> food;

    /**
     * Creates a generic {@code Station}.
     * 
     * @param position block's position
     * @param tile   block's sprite
     */
    public ChoppingBoard(final Position position, final Tile tile) {
        super(position);
        this.food = Optional.empty();
        timer = new GameTimer();
        this.graphicComponent = new StationObjectGraphicComponent(this, tile);
    }

    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    public Optional<DishImpl> getFood() {
        return this.food;
    }

    public Optional<DishImpl> takeItem() {
        final Optional<DishImpl> f = food;
        this.food = Optional.empty();
        return f;
    };

    public void setItem(DishImpl f) {
        this.food = Optional.ofNullable(f);
        this.timer.start();
    };

    public void update() {

    }

    public boolean isCut() {
        return false;
    }
}
