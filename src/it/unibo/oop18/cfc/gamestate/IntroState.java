package it.unibo.oop18.cfc.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.oop18.cfc.input.gamestate.IntroStateInput;
import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;

/**
 * The IntroState class that shows the intro.
 *
 */
public class IntroState extends GameState {

    private int alpha;
    private int ticks;

    private static final int FADE_IN = 60;
    private static final int LENGTH = 60;
    private static final int FADE_OUT = 60;
    private static final int CHAR_DIM = 255;

    /**
     * Constructor.
     * 
     * @param gsm {@link GameStateManager} instance
     */
    public IntroState(final GameStateManager gsm) {
        super(gsm, GameStates.INTRO);
        super.setInput(new IntroStateInput(this));
    }

    /**
     * {@inheritDoc}.
     */
    public void init() {
        ticks = 0;
    }

    /**
     * {@inheritDoc}.
     */
    public void update() {
        ticks++;
        if (ticks < FADE_IN) {
            alpha = (int) (CHAR_DIM - CHAR_DIM * (1.0 * ticks / FADE_IN));
            if (alpha < 0) {
                alpha = 0;
            }
        }
        if (ticks > FADE_IN + LENGTH) {
            alpha = (int) (CHAR_DIM * (1.0 * ticks - FADE_IN - LENGTH) / FADE_OUT);
            if (alpha > CHAR_DIM) {
                alpha = CHAR_DIM;
            }
        }
        if (ticks > FADE_IN + LENGTH + FADE_OUT) {
            getGsm().setState(GameStates.MENU);
        }
    }

    /**
     * {@inheritDoc}.
     */
    public void draw(final Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GameEngine.WIDTH, GameEngine.HEIGHT3);
        ContentUtil.drawIntro(g);
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(0, 0, GameEngine.WIDTH, GameEngine.HEIGHT3);
    }
}
