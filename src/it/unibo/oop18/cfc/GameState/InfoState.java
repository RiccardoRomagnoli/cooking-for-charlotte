package it.unibo.oop18.cfc.GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import it.unibo.oop18.cfc.Main.GameEngine;
import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Manager.GameStateManager;

/**
 * Info.
 */
public class InfoState extends GameState {

    private BufferedImage bg;

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
        bg = Content.MENUBG[0][0];
    }

    /**
     * {@inheritDoc}.
     */
    public void update() {
    }

    /**
     * {@inheritDoc}.
     * @param g basic graphics
     */
    public void draw(final Graphics2D g) {
        g.drawImage(bg, 0, 0, null);
        Content.drawString(g, "INFO", 400, 300);
        Content.drawString(g, "arrow keys : move", 100, 370);
        Content.drawString(g, "space : action", 200, 440);
        Content.drawString(g, "F1: return to menu", 100, 510);

        int fontSize = 25;
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));      
        g.setColor(Color.orange);
        g.drawString("Fai attenzione a comporre il piatto con gli ingredienti giusti", 50, 600);
        g.drawString("altrimenti dovrai buttare tutto nel cestino e ricominciare da capo!!", 50, 650);
    }

}
