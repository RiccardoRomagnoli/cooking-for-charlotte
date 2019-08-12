package it.unibo.oop18.cfc.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.orders.OrdersManagerImpl;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.DataUtil;
import it.unibo.oop18.cfc.util.GameScoreImpl;

/**
 * The Class GameOverState.
 */
public class GameOverState extends GameState {

    private Color color;
    private int rank;
    private static final int STRING_COL = 50;
    private GameScoreImpl finalScore = new GameScoreImpl();

    /**
     * GameOverState constructor.
     * 
     * @param gsm gamestate
     */
    public GameOverState(final GameStateManager gsm) {
        super(gsm, GameStates.GAMEOVER);
        finalScore.computeScore(OrdersManagerImpl.getScore());
    }

    /**
     * {@inheritDoc}
     */
    public void init() {
        color = new Color(164, 198, 222);
    }

    /**
     * {@inheritDoc}
     */
    public void update() {
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {

        g.setColor(color);
        g.fillRect(0, 0, GameEngine.WIDTH, GameEngine.HEIGHT2);

        ContentUtil.drawString(g, "GAME OVER", STRING_COL, 150);
        if (finalScore.getScore() >= 500) {
            ContentUtil.drawString(g, "3 stelle michelin", STRING_COL, 300);
        } else if (finalScore.getScore() >= 200 &&  finalScore.getScore() < 500) {
            ContentUtil.drawString(g, "2 stella michelin", STRING_COL, 300);
        } else if (finalScore.getScore() >= 100 &&  finalScore.getScore() < 200) {
            ContentUtil.drawString(g, "1 stella michelin", STRING_COL, 300);
        } else if (finalScore.getScore() < 100) {
            ContentUtil.drawString(g, "lavapiatti", STRING_COL, 300);
        }

        ContentUtil.drawString(g, "press any key", STRING_COL, 420);
    }
}
