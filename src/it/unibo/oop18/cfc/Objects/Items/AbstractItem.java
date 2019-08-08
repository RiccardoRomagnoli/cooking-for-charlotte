package it.unibo.oop18.cfc.Objects.Items;

import it.unibo.oop18.cfc.Manager.ItemManager;

public abstract class AbstractItem implements Item {

    private final ItemManager itemManager;

    public AbstractItem(final ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public ItemManager getItemManager() {
        return this.itemManager;
    }
}
