package it.unibo.oop18.cfc.test;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import it.unibo.oop18.cfc.util.GameScoreImpl;

/**
 * TODO .
 *
 *
 */
public class TestScore {

    private static final int SCORE_1 = 50;

    /**
     * Test the correct generation of an order.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void scoreTest() throws IOException {
        final GameScoreImpl score = new GameScoreImpl();
        score.computeScore(0);
        Assert.assertTrue(score.getScore() == 0);
        score.computeScore(SCORE_1);
        score.computeScore(SCORE_1);
        score.computeScore(-SCORE_1 * 2);
        Assert.assertTrue(score.getScore() == 0);
    }

    /**
     * @exception Exception gamescore setted but not created
     */
    @Test(expected = Exception.class)
    public void scoreTestExceptions() throws Exception {
        final GameScoreImpl score = new GameScoreImpl();
        Assert.assertTrue(score.getScore() == 0);
        score.getScore();
    }
}
