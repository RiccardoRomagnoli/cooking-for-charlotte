package it.unibo.oop18.cfc.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.RankingImpl;
import it.unibo.oop18.cfc.world.WorldImpl;

/**
 * The Class GameOverState.
 */
public class GameOverState extends GameState {

    // private Color color;
    private static final int STRING_COL = 220;
    private static final int STRING_ROW = 500;
    private static final int SMALL_PADDING = 50;
    private static final int BIG_PADDING = 350;
    private int finalScore;
    private Font myFont;
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
            try {
                myFont = Font.createFont(Font.TRUETYPE_FONT, InfoState.class.getResourceAsStream("/HUD/comicsans.ttf"));
                myFont = myFont.deriveFont(WorldImpl.FONT_SIZE);
                g.setFont(myFont);
                g.setColor(Color.DARK_GRAY);
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawString("Insert your name:", STRING_COL, STRING_ROW - 100);
            g.drawString(String.valueOf(choice), STRING_COL, STRING_ROW); //
            g.drawString(String.format("Points: %d", finalScore), STRING_COL + BIG_PADDING, STRING_ROW);
        }
        g.drawString("press any key", STRING_COL + BIG_PADDING, STRING_ROW + SMALL_PADDING);
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
