package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.JukeBoxUtil;

/**
 * The Class GameOverState.
 */
public class GameOverState extends GameState {

    private static final int STRING_COL = 230;
    private static final int STRING_ROW = 500;
    private static final int SMALL_PADDING = 50;
    private static final int BIG_PADDING = 350;
    private static final int ARROW_DIM = 30;
    private static final int ARROWUP_Y_OFFSET = -50;
    private static final int ARROWDOWN_Y_OFFSET = 5;
    private static final int ARROW_X_OFFSET = -4;
    private static final int TEXTDISTANCE = 30;
    private int finalScore;
    private char[] choice = "AAAAAAAAAA".toCharArray();
    private int index;

    /**
     * GameOverState constructor.
     * 
     * @param gsm gamestate
     */
    public GameOverState(final GameStateManager gsm) {
        super(gsm, GameStates.GAMEOVER);
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
            ContentUtil.drawRank(g);
            ContentUtil.drawStringFont(g, STRING_COL, STRING_ROW - 100, "Insert your name:");
            ContentUtil.drawArrowDown(g, STRING_COL + (index * TEXTDISTANCE) + ARROW_X_OFFSET,
                    STRING_ROW + ARROWUP_Y_OFFSET, ARROW_DIM, ARROW_DIM);
            for (int i = 0; i < choice.length; i++) {
                ContentUtil.drawStringFont(g, STRING_COL + (i * TEXTDISTANCE), STRING_ROW, String.valueOf(choice[i]));
            }
            ContentUtil.drawArrowUp(g, STRING_COL + (index * TEXTDISTANCE) + ARROW_X_OFFSET,
                    STRING_ROW + ARROWDOWN_Y_OFFSET, ARROW_DIM, ARROW_DIM);
            ContentUtil.drawStringFont(g, STRING_COL + BIG_PADDING, STRING_ROW,
                    String.format("Points: %d", finalScore));
        }
        g.drawString("Press enter to save", STRING_COL + BIG_PADDING, STRING_ROW + SMALL_PADDING);
    }

    /**
     * Change letter with next.
     */
    public void goUp() {
        if (choice[index] < 'Z') {
            choice[index]++;
        } else {
            choice[index] = 'A';
        }
    }

    /**
     * Change letter with prev.
     */
    public void goDown() {
        if (choice[index] > 'A') {
            choice[index]--;
        } else {
            choice[index] = 'Z';
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
        if (index < choice.length - 1) {
            index++;
        }
    }

    /**
     * Save the ranking and exit.
     */
    public void save() {
        super.getGsm().getRankState().getRanking().addPlacement(String.valueOf(choice), finalScore);
    }
}
