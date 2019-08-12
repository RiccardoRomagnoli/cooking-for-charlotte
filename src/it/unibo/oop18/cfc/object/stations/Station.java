package it.unibo.oop18.cfc.object.stations;

import it.unibo.oop18.cfc.world.World;

/**
 * The Interface Station.
 */
public interface Station {

    /**
     * Do the station action when space bar is released.
     *
     * @param world the {@link World}
     */
    void doAction(World world);
}
