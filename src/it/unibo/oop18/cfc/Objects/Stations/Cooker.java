package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.Graphics.CookerGraphicComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Tile.CookerTile;
import it.unibo.oop18.cfc.Util.GameTimer;
import it.unibo.oop18.cfc.Util.Position;

public class Cooker extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    private GameTimer timer;
    private Optional<IngredientImpl> food;

    /**
     * Creates a generic {@code Station}.
     * 
     * @param position block's position
     * @param cookerTile   block's tile
     */
    public Cooker(final Position position, final CookerTile cookerTile) {
        super(position);
        this.food = Optional.empty();
        this.timer = new GameTimer();
        this.graphicComponent = new CookerGraphicComponent(this, cookerTile);
    }

    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    public Optional<IngredientImpl> getFood() {
        return this.food;
    }

    public Optional<IngredientImpl> takeItem() {
        final Optional<IngredientImpl> f = food;
        this.food = Optional.empty();
        return f;
    };

    public void setItem(IngredientImpl f) {
        this.food = Optional.ofNullable(f);
        this.timer.start();
    };

    public void update() {

    }

    public boolean isCooked() {
        return false;
    }
}
