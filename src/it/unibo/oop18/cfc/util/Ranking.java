package it.unibo.oop18.cfc.util;

/**
 * Manage the ranking.
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
     */
    void saveRanking();

    /**
     * Load rank from a csv formatted file.
     */
    void loadRanking();

}
