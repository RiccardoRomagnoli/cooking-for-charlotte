package it.unibo.oop18.cfc.util;

import java.awt.Graphics2D;
import java.util.Map;

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
     * Load rank from a csv formatted file.
     */
    void loadRanking();

    /**
     * Print point on screen.
     * 
     * @param g graphics
     */
    void printOnScreen(Graphics2D g);

    /**
     * Save the rank to file.
     */
    void saveRanking();

    /**
     * Set the path of the rank.
     * 
     * @param path rank
     */
    void setPath(String path);

    /**
     * Return map.
     * 
     * @return actual rank map
     */
    Map<String, Integer> getRanked();

}
