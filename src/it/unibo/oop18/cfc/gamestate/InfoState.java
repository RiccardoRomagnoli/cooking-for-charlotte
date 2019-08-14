package it.unibo.oop18.cfc.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.world.WorldImpl;

/**
 * Infostate class.
 */
public class InfoState extends GameState {

    /**
     * Class constructor.
     * 
     * @param gsm game state
     */
    public InfoState(final GameStateManager gsm) {
        super(gsm, GameStates.INFO);
    }

    /**
     * {@inheritDoc}.
     */
    public void init() {
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
        ContentUtil.drawMenu(g);
        ContentUtil.drawString(g, "INFO", 400, 300);
        ContentUtil.drawString(g, "arrow keys : move", 100, 370);
        ContentUtil.drawString(g, "space : action", 200, 440);
        ContentUtil.drawString(g, "F1: return to menu", 100, 510);

        ContentUtil.drawStringFont(g, 50, 650, "Fai attenzione a comporre il piatto con gli ingredienti giusti");
        ContentUtil.drawStringFont(g, 50, 700, "altrimenti dovrai buttare tutto nel cestino e ricominciare da capo!!");

    }

}
