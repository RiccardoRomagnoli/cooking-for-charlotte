package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.Graphics.ChoppingStationGraphicComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Tile.ChoppingStationTile;
import it.unibo.oop18.cfc.Util.GameTimer;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

public class ChoppingStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    private GameTimer timer;
    private Optional<IngredientImpl> food;

    /**
     * Creates a generic {@code Station}.
     * 
     * @param position block's position
     * @param choppingStationTile   block's tile
     */
    public ChoppingStation(final Position position, final ChoppingStationTile choppingStationTile) {
        super(position);
        this.food = Optional.empty();
        timer = new GameTimer();
        this.graphicComponent = new ChoppingStationGraphicComponent(this, choppingStationTile);
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

    public boolean isCut() {
        return false;
    }

    @Override
    public void doAction(World world) {
        // TODO Auto-generated method stub
        
    }
}
