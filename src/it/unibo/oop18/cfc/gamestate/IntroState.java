package it.unibo.oop18.cfc.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.manager.GameStateManager;

/**
 * The IntroState class that shows the intro.
 *
 */
public class IntroState extends GameState {


    private BufferedImage logo;
    private int alpha;
    private int ticks;


    private static final int FADE_IN = 60;
    private static final int LENGTH = 60;
    private static final int FADE_OUT = 60;
    private static final int CHAR_DIM = 255;

    /**
     * Constructor.
     * @param gsm gamestate instance
     */
    public IntroState(final GameStateManager gsm) {
        super(gsm, GameStates.INTRO);
    }

    /**
     * {@inheritDoc}.
     */
    public void init() {
        ticks = 0;
        try {
            logo = ImageIO.read(getClass().getResourceAsStream("/Logo/icon.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            gsm.setState(GameStates.MENU);
        }
    }

    /**
     * {@inheritDoc}.
     * @param g basic graphics
     */
    public void draw(final Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GameEngine.WIDTH, GameEngine.HEIGHT3);
        g.drawImage(logo, 0, 0, GameEngine.WIDTH, GameEngine.HEIGHT3, null);
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(0, 0, GameEngine.WIDTH, GameEngine.HEIGHT3);
    }
}
