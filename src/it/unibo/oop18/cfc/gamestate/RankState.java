package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.Ranking;
import it.unibo.oop18.cfc.util.RankingImpl;

/**
 * Infostate class.
 */
public class RankState extends GameState {

    private Ranking ranking;
    /**
     * Class constructor.
     * 
     * @param gsm game state
     */
    public RankState(final GameStateManager gsm) {
        super(gsm, GameStates.RANKING);
    }

    /**
     * {@inheritDoc}.
     */
    public void init() {
        ranking = new RankingImpl();
    }

    /**
     * {@inheritDoc}.
     */
    public void update() {
    }

    /**
     * {@inheritDoc}.
     * 
     * @param g basic graphics
     * @throws IOException
     */
    public void draw(final Graphics2D g) {
        ContentUtil.drawMenu(g);
        ranking.printOnScreen(g);
    }

    /**
     * Get ranking Instance.
     * @return ranking Instance
     */
    public Ranking getRanking() {
        return ranking;
    }
}
