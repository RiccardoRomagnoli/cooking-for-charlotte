package it.unibo.oop18.cfc.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.orders.OrdersManagerImpl;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.GameScoreImpl;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.RankingImpl;

/**
 * The Class GameOverState.
 */
public class GameOverState extends GameState {

    // private Color color;
    private static final int STRING_COL = 220;
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
        finalScore.computeScore(IngredientImpl.getScore());
        ranking = new RankingImpl();
    }

    /**
     * {@inheritDoc}
     */
    public void init() {
        super.getGsm().getPlayState().getWorld().stopTimers();
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
            ContentUtil.drawMenu(g);
            g.drawString("Insert your name:", STRING_COL, 300);
            try {
                myFont = Font.createFont(Font.TRUETYPE_FONT, InfoState.class.getResourceAsStream("/HUD/comicsans.ttf"));
                myFont = myFont.deriveFont(30f);
                g.setFont(myFont);
                g.setColor(Color.DARK_GRAY);
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawString(String.valueOf(choice), STRING_COL, 500); //
            g.drawString(String.format("Points: %d", IngredientImpl.getScore()), STRING_COL + 350, 500);
        }
        g.drawString("press any key", STRING_COL, 700);
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
        ranking.addPlacement(getName(), IngredientImpl.getScore());
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
