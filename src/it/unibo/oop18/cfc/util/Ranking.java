package it.unibo.oop18.cfc.util;

import java.io.IOException;

/**
 * 
 * Interface for the ranking class.
 *
 */
public interface Ranking {

    /**
     * Add a row in the rank file.
     * 
     * @param points gained in the game
     * 
     * @param player name of the gamer
     */
    void addPlacement(String player, int points);

    /**
     * Save rank on a csv formatted file.
     * 
     * @throws IOException
     */
    void saveRanking() throws IOException;

}
