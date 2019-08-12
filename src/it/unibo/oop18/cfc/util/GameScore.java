package it.unibo.oop18.cfc.util;

/**
 * 
 * Interface of gamescore class. Contains the basic method to implement a
 * working game score
 */
public interface GameScore {

    /**
     * @return actual score.
     */
    int getScore();

    /**
     * @param scoreValue Points to be added or subtracted the actual score
     */
    void computeScore(int scoreValue);
}
