package it.unibo.oop18.cfc.object.Items;

import it.unibo.oop18.cfc.manager.ItemManager;

public abstract class AbstractItem implements Item {

    private final ItemManager itemManager;

    public AbstractItem(final ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public ItemManager getItemManager() {
        return this.itemManager;
    }
}
