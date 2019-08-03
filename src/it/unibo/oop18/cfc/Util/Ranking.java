package it.unibo.oop18.cfc.Util;

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
     * Print on the screen the first.
     */
    void printOnScreen();

    /**
     * Save rank on a csv formatted file.
     * 
     * @throws IOException
     */
    void saveRanking() throws IOException;

    /**
     * Load the rank from a csv formatted file.
     * 
     * @throws IOException
     */
    void loadRanking() throws IOException;
}
