package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.RankingImpl;

/**
 * The Class GameOverState.
 */
public class GameOverState extends GameState {

    private static final int STRING_COL = 220;
    private static final int STRING_ROW = 500;
    private static final int SMALL_PADDING = 50;
    private static final int BIG_PADDING = 350;
    private int finalScore;
    private char[] choice = "_ _ _ _ _ _ _ _ _ _".toCharArray();
    private int index;
    private final RankingImpl ranking;


    /**
     * GameOverState constructor.
     * 
     * @param gsm gamestate
     */
    public GameOverState(final GameStateManager gsm) {
        super(gsm, GameStates.GAMEOVER);
        ranking = new RankingImpl();
    }

    /**
     * {@inheritDoc}
     */
    public void init() {
        super.getGsm().getPlayState().getWorld().stopTimers();
        finalScore = super.getGsm().getPlayState().getWorld().getScoreManager().getScore();
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
        if (finalScore >= 0) {
            ContentUtil.drawMenu(g);
            ContentUtil.drawStringFont(g, STRING_COL, STRING_ROW - 100, "Insert your name:");
            ContentUtil.drawArrowDown(g, STRING_COL + (index * 20), STRING_ROW - 50, 30, 30);
            ContentUtil.drawStringFont(g, STRING_COL + 10, STRING_ROW, String.valueOf(choice), 30f);
            ContentUtil.drawArrowUp(g, STRING_COL + (index * 20), STRING_ROW + 5, 30, 30);
            ContentUtil.drawStringFont(g, STRING_COL + BIG_PADDING, STRING_ROW,
                    String.format("Points: %d", finalScore));
        }
        g.drawString("Press enter to save", STRING_COL + BIG_PADDING, STRING_ROW + SMALL_PADDING);
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
                choice[index * 2] = '_';
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
                choice[index * 2] = '_';
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
        ranking.addPlacement(getName(), finalScore);
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
