package it.unibo.oop18.cfc.util;

/**
 * Class to keep tracking of the gamescore.
 */
public class GameScoreImpl implements GameScore {

    private static final int START = 0;
    private int score;

    /**
     * Constructor of gamescore class. Set inital score to 0
     */
    public GameScoreImpl() {
        super();
        this.score = GameScoreImpl.START;
    }

    /**
     * {@inheritDoc}
     */
    public int getScore() {
        return this.score;
    }

    /**
     * {@inheritDoc}
     */
    public void computeScore(final int scoreValue) {
        this.score = this.score + scoreValue;
    }

}
