package it.unibo.oop18.cfc.object.items;

import it.unibo.oop18.cfc.manager.ItemManager;

/**
 * The Class AbstractItem.
 */
public abstract class AbstractItem implements Item {

    private final ItemManager itemManager;

    /**
     * Instantiates a new {@link AbstractItem}.
     *
     * @param itemManager the {@link ItemManager} where the sprite are
     */
    public AbstractItem(final ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    /**
     * Gets the {@link ItemManager}.
     *
     * @return the {@link ItemManager}
     */
    public ItemManager getItemManager() {
        return this.itemManager;
    }
}
