package it.unibo.oop18.cfc.util;

import java.awt.Graphics2D;

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

}
