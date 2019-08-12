package it.unibo.oop18.cfc.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.orders.OrdersManagerImpl;
import it.unibo.oop18.cfc.util.GameScoreImpl;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.RankingImpl;

/**
 * The Class GameOverState.
 */
public class GameOverState extends GameState {

    private Color color;
    private static final int STRING_COL = 50;
    private final GameScoreImpl finalScore = new GameScoreImpl();
    private Font myFont;
    private char[] choice = "_ _ _ _ _ _ _ _ _ _".toCharArray();
    private int index;
    private RankingImpl ranking;

    /**
     * GameOverState constructor.
     * 
     * @param gsm gamestate
     */
    public GameOverState(final GameStateManager gsm) {
        super(gsm, GameStates.GAMEOVER);
        finalScore.computeScore(OrdersManagerImpl.getScore());
        try {
            ranking = new RankingImpl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    public void init() {
        color = new Color(164, 198, 222);
        JukeBoxUtil.stop("themeSong");
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
        if (finalScore.getScore() >= 0) { // TODO togliere e mettere score.min
            g.setColor(color);
            g.fillRect(0, 0, GameEngine.WIDTH, GameEngine.HEIGHT2);
            g.drawString("Insert your name:", STRING_COL, 150);
            try {
                myFont = Font.createFont(Font.TRUETYPE_FONT, InfoState.class.getResourceAsStream("/HUD/comicsans.ttf"));
                myFont = myFont.deriveFont(30f);
                g.setFont(myFont);
                g.setColor(Color.orange);
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawString(String.valueOf(choice), STRING_COL, 300); //
        }
        g.drawString("press any key", STRING_COL, 420);
    }

    /**
     * Change letter with next.
     */
    public void goUp() {
        if (choice[index * 2] == '_') {
            choice[index * 2] = 'A';
        } else {
            if (choice[index * 2] < 90) {
                choice[index * 2]++;
            } else {
                choice[index * 2] = 'A';
            }
        }

    }

    /**
     * Change letter with prev.
     */
    public void goDown() {
        if (choice[index * 2] == '_') {
            choice[index * 2] = 'Z';
        } else {
            if (choice[index * 2] > 65) {
                choice[index * 2]--;
            } else {
                choice[index * 2] = 'Z';
            }
        }
    }

    /**
     * Change letter position.
     */
    public void goLeft() {
        if (index > 0) {
            index--;
        }
    }

    /**
     * Change letter position.
     */
    public void goRight() {
        if (index < choice.length / 2) {
            index++;
        }
    }

    /**
     * Save the ranking and exit.
     */
    public void save() {
        ranking.addPlacement(getName(), OrdersManagerImpl.getScore());
        ranking.saveRanking();
    }

    /**
     * Return the name of the player.
     * 
     * @return player's name
     */
    public String getName() {
        return String.valueOf(choice).replaceAll(" ", "").replaceAll("_", "");
    }
}
