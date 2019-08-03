package it.unibo.oop18.cfc.GameState;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Main.GameEngine;
import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Manager.GameStateManager;

/**
 * 
 * 
 *
 */
public class InfoState extends GameState {

    private Color color;

    /**
     * Class constructor.
     * 
     * @param gsm game state
     */
    public InfoState(final GameStateManager gsm) {
        super(gsm, GameStates.INFO);
    }

    /**
     * Init class.
     */
    public void init() {

    }

    /**
     * Update class. Nothing has to be done until it is on this menu
     */
    public void update() {
    }

    /**
     * Draw elements on the info screen.
     * 
     * @param g basic graphics
     */
    public void draw(final Graphics2D g) {
        color = new Color(164, 198, 222);
        g.setColor(color);
        g.fillRect(0, 0, GameEngine.WIDTH, GameEngine.HEIGHT2);
        Content.drawString(g, "INFO", 400, 200);

        Content.drawString(g, "arrow keys : move", 120, 270);

        Content.drawString(g, "space : action", 200, 340);

        Content.drawString(g, "F1: return to menu", 120, 410);
    }

}
