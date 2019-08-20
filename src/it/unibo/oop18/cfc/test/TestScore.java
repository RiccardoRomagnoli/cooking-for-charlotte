package it.unibo.oop18.cfc.test;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import it.unibo.oop18.cfc.util.GameScoreImpl;
import it.unibo.oop18.cfc.util.Ranking;
import it.unibo.oop18.cfc.util.RankingImpl;


/**
 * Test the functionality of the ranking. It test the assigment of points to the
 * player, the loading of old ranking to the hasmap and the input output
 */
public class TestScore {

    private static final int SCORE_1 = 50;
    private static final int SCORE_2 = 42;
    private static final int SCORE_3 = 666;
    private static final int SCORE_4 = 1984;

    /**
     * Test the correct generation of an order.
     *
     */
    @Test
    public void scoreTest() {
        final GameScoreImpl score = new GameScoreImpl();
        score.computeScore(0);
        Assert.assertTrue(score.getScore() == 0);
        score.computeScore(SCORE_1);
        score.computeScore(SCORE_1);
        score.computeScore(-SCORE_1 * 2);
        Assert.assertTrue(score.getScore() == 0);
    }

    /**
     * Test the correct generation of an order.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testRanking() throws IOException {
        final Ranking rankTest = new RankingImpl();
        rankTest.setPath("unitTestRank.txt");

        rankTest.addPlacement("ReadyPlayer1", SCORE_2);
        rankTest.addPlacement("FearOfTheBest", SCORE_3);
        rankTest.addPlacement("DemoGorgon", SCORE_4);
        //rankTest.saveRanking();
        rankTest.loadRanking();
        Assert.assertTrue(rankTest.getRanked().containsKey("ReadyPlayer1")
                && rankTest.getRanked().containsKey("FearOfTheBest") && rankTest.getRanked().containsKey("DemoGorgon"));
        Assert.assertTrue(rankTest.getRanked().containsValue(SCORE_2) && rankTest.getRanked().containsValue(SCORE_3)
                && rankTest.getRanked().containsValue(SCORE_4));
        final File f = new File("unitTestRank.txt");
        final boolean x = f.delete();
        final boolean y = f.createNewFile();
        Assert.assertTrue(x && y);
    }
}
