package it.unibo.oop18.cfc.test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import it.unibo.oop18.cfc.util.GameScoreImpl;
import it.unibo.oop18.cfc.util.RankingImpl;

/**
 * TODO .
 *
 *
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
     * @exception Exception gamescore setted but not created
     */
    @Test(expected = Exception.class)
    public void scoreTestExceptions() throws Exception {
        final GameScoreImpl score = new GameScoreImpl();
        Assert.assertTrue(score.getScore() == 0);
        score.getScore();
    }

    /**
     * Test the correct generation of an order.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testRanking() throws IOException {
        final RankingImpl rankTest = new RankingImpl();
        RankingImpl.setPath("unitTestRank.txt");

        rankTest.addPlacement("ReadyPlayer1", SCORE_2);
        rankTest.addPlacement("FearOfTheBest", SCORE_3);
        rankTest.addPlacement("DemoGorgon", SCORE_4);
        rankTest.saveRanking();
        rankTest.loadRanking();
        final Map<String, Integer> testMap = RankingImpl.getRanked();
        Assert.assertTrue(testMap.containsKey("ReadyPlayer1") && testMap.containsKey("FearOfTheBest")
                && testMap.containsKey("DemoGorgon"));
        Assert.assertTrue(
                testMap.containsValue(SCORE_2) && testMap.containsValue(SCORE_3) && testMap.containsValue(SCORE_4));
        final File f = new File("unitTestRank.txt");
        final boolean x = f.delete();
        final boolean y = f.createNewFile();
        Assert.assertTrue(x && y); // TODO
    }

    /**
     * This test should launch exception because file is not present.
     * 
     * @throws Exception for input file
     */
    @Test(expected = Exception.class)
    public void testRankingExceptions() throws Exception {
        final RankingImpl rankTest = new RankingImpl();
        RankingImpl.setPath("notPresentFile.txt");
        rankTest.saveRanking();
        rankTest.loadRanking();
    }
}
