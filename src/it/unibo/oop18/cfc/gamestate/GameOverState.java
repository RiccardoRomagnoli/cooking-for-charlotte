package it.unibo.oop18.cfc.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.manager.DataUtil;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;

/**
 * The Class GameOverState.
 */
public class GameOverState extends GameState {

    private Color color;
    private int rank;
    private long ticks;

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
        color = new Color(164, 198, 222);
        ticks = DataUtil.getTime();
        if (ticks < 3600) {
            rank = 1;
        } else if (ticks < 5400) {
            rank = 2;
        } else if (ticks < 7200) {
            rank = 3;
        } else {
            rank = 4;
        }
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

        ContentUtil.drawString(g, "finish time", 20, 36);

        final int minutes = (int) (ticks / 1800);
        final int seconds = (int) ((ticks / 30) % 60);
        if (minutes < 10) {
            if (seconds < 10) {
                ContentUtil.drawString(g, "0" + minutes + ":0" + seconds, 44, 48);
            } else {
                ContentUtil.drawString(g, "0" + minutes + ":" + seconds, 44, 48);
            }
        } else {
            if (seconds < 10) {
                ContentUtil.drawString(g, minutes + ":0" + seconds, 44, 48);
            } else {
                ContentUtil.drawString(g, minutes + ":" + seconds, 44, 48);
            }
        }

        ContentUtil.drawString(g, "rank", 48, 66);
        if (rank == 1) {
            ContentUtil.drawString(g, "3 stelle michelin", 20, 78);
        } else if (rank == 2) {
            ContentUtil.drawString(g, "2 stella michelin", 24, 78);
        } else if (rank == 3) {
            ContentUtil.drawString(g, "1 stella michelin", 32, 78);
        } else if (rank == 4) {
            ContentUtil.drawString(g, "lavapiatti", 8, 78);
        }

        ContentUtil.drawString(g, "press any key", 12, 110);
    }
}
