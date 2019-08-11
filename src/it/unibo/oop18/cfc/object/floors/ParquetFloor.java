package it.unibo.oop18.cfc.object.floors;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.ParquetFloorGraphicComponent;
import it.unibo.oop18.cfc.object.items.Item;
import it.unibo.oop18.cfc.tile.ParquetFloorTile;
import it.unibo.oop18.cfc.tilemap.TileType;
import it.unibo.oop18.cfc.util.Position;

public class ParquetFloor extends AbstractFloorObject {

    private final GraphicsComponent graphicComponent;
    private Optional<Item> item;

    public ParquetFloor(final Position position, final ParquetFloorTile parquetFloorTile) {
        super(position);
        this.item = Optional.empty();
        this.graphicComponent = new ParquetFloorGraphicComponent(this, parquetFloorTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    public Optional<Item> getItem() {
        return item;
    }

    public void setItem(final Item item) {
        this.item = Optional.ofNullable(item);
    }

}
