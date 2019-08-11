package it.unibo.oop18.cfc.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.manager.Content;
import it.unibo.oop18.cfc.manager.DataUtil;
import it.unibo.oop18.cfc.manager.GameStateManager;

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

        Content.drawString(g, "finish time", 20, 36);

        final int minutes = (int) (ticks / 1800);
        final int seconds = (int) ((ticks / 30) % 60);
        if (minutes < 10) {
            if (seconds < 10) {
                Content.drawString(g, "0" + minutes + ":0" + seconds, 44, 48);
            } else {
                Content.drawString(g, "0" + minutes + ":" + seconds, 44, 48);
            }
        } else {
            if (seconds < 10) {
                Content.drawString(g, minutes + ":0" + seconds, 44, 48);
            } else {
                Content.drawString(g, minutes + ":" + seconds, 44, 48);
            }
        }

        Content.drawString(g, "rank", 48, 66);
        if (rank == 1) {
            Content.drawString(g, "3 stelle michelin", 20, 78);
        } else if (rank == 2) {
            Content.drawString(g, "2 stella michelin", 24, 78);
        } else if (rank == 3) {
            Content.drawString(g, "1 stella michelin", 32, 78);
        } else if (rank == 4) {
            Content.drawString(g, "lavapiatti", 8, 78);
        }

        Content.drawString(g, "press any key", 12, 110);

    }
}