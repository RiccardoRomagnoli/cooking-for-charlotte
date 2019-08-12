package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.RankingImpl;

/**
 * Infostate class.
 */
public class RankState extends GameState {

    private BufferedImage bg;

    /**
     * Class constructor.
     * 
     * @param gsm game state
     */
    public RankState(final GameStateManager gsm) {
        super(gsm, GameStates.RANKING);
    }

    /**
     * {@inheritDoc}.
     */
    public void init() {
        bg = ContentUtil.MENUBG[0][0];
    }

    /**
     * {@inheritDoc}.
     */
    public void update() {
    }

    /**
     * {@inheritDoc}.
     * 
     * @param g basic graphics
     * @throws IOException
     */
    public void draw(final Graphics2D g) {
        g.drawImage(bg, 0, 0, null);
        RankingImpl.printOnScreen(g);
    }
}
