package it.unibo.oop18.cfc.Objects.Blocks;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Objects.AbstractGameObject;
import it.unibo.oop18.cfc.TileMap.Tile;
import it.unibo.oop18.cfc.Util.Position;

/**
 * This class manages a block.
 */
public class Block extends AbstractGameObject {

    private final Tile sprite;
    /**
     * Creates a generic {@code Block}.
     * 
     * @param breakable the possibility to break the block
     * @param position block's position
     * @param sprite block's sprite
     */
    public Block(final Position position, final Tile sprite) {
        super(position);
        this.sprite = sprite;
    }
}
