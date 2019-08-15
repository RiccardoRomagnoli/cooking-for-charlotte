package it.unibo.oop18.cfc.gamestate;


import java.awt.Graphics2D;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;

/**
 * Infostate class.
 */
public class InfoState extends GameState implements Runnable {

    private int x, y, flag;

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
        x = 30;
        y = 630;
        flag = 1;

        // creating thread
        final Thread t = new Thread(this, "MyThread");

        // start thread
        t.start();
    }

    /**
     * {@inheritDoc}.
     */
    public void update() {
        x = x + 10 * flag;
        if (x > 150) {
            flag = -1;
        }
        if (x < 0) {
            flag = 1;
        }
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
        ContentUtil.drawStringFont(g, x, y, "Fai attenzione a comporre il piatto con gli ingredienti giusti");
        ContentUtil.drawStringFont(g, x, y + 40, "altrimenti dovrai buttare tutto e ricominciare da capo!!");
    }

    /**
     * Run. {@inheritDoc}
     */
    public void run() {
        while (true) {
            update();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
    }

}
