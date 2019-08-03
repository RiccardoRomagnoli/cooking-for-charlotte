package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.Graphics.CounterGraphicComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Objects.Items.Item;
import it.unibo.oop18.cfc.Tile.CounterTile;
import it.unibo.oop18.cfc.Util.Position;

public class Counter extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    private Optional<Item> item;

    public Counter(final Position position, final CounterTile counterTile) {
        super(position);
        this.item = Optional.empty();
        this.graphicComponent = new CounterGraphicComponent(this, counterTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    public Optional<Item> getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = Optional.ofNullable(item);
    }

}
