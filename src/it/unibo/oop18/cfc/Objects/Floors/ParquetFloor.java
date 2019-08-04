package it.unibo.oop18.cfc.Objects.Floors;

import java.awt.Graphics2D;
import java.util.Optional;

import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Graphics.ParquetFloorGraphicComponent;
import it.unibo.oop18.cfc.Objects.Items.Item;
import it.unibo.oop18.cfc.Tile.ParquetFloorTile;
import it.unibo.oop18.cfc.Util.Position;

public class ParquetFloor extends AbstractFloorObject {

    private final GraphicsComponent graphicComponent;
    private Optional<Item> item;
    private final boolean leftFloor;

    public ParquetFloor(final Position position, final ParquetFloorTile parquetFloorTile, final boolean leftFloor) {
        super(position);
        this.item = Optional.empty();
        this.leftFloor = leftFloor;
        this.graphicComponent = new ParquetFloorGraphicComponent(this, parquetFloorTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

    /**
     * @return the leftFloor
     */
    public boolean isLeftFloor() {
        return leftFloor;
    }

    public Optional<Item> getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = Optional.ofNullable(item);
    }

}
