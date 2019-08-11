// The GameEngine is the drawing canvas.
// It contains the game loop which
// keeps the game moving forward.
// This class is also the one that grabs key events.

package it.unibo.oop18.cfc.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import it.unibo.oop18.cfc.input.KeyInput;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.tile.TileSheet;

/**
 * The GameEngine is the class that contains the game loop and keep all moving
 * forward.
 */
@SuppressWarnings("serial")
public class GameEngine extends JPanel implements Runnable {

    /**
     * Window width.
     */
    public static final int WIDTH = 1024;
    /**
     * Window gamemap height.
     */
    public static final int HEIGHT = 512;
    /**
     * Top and bot hud height.
     */
    public static final int HUDHEIGHT = 128;
    /**
     * Top + Gamemap height.
     */
    public static final int HEIGHT2 = HEIGHT + HUDHEIGHT;
    /**
     * All window height.
     */
    public static final int HEIGHT3 = HEIGHT2 + HUDHEIGHT;
    /**
     * Top bound in pixel.
     */
    public static final int TOP_BOUND_IN_PIXEL = HUDHEIGHT + TileSheet.TILE_SIZE_IN_GAME;
    /**
     * Left bound in pixel.
     */
    public static final int LEFT_BOUND_IN_PIXEL = TileSheet.TILE_SIZE_IN_GAME;
    /**
     * Right bound in pixel.
     */
    public static final int RIGHT_BOUND_IN_PIXEL = WIDTH - (2 * TileSheet.TILE_SIZE_IN_GAME);
    /**
     * Down bound in pixel.
     */
    public static final int DOWN_BOUND_IN_PIXEL = HEIGHT;

    /**
     * Scale rate for graphic.
     */
    public static final int SCALE = 1;
    /**
     * FPS of game.
     */
    public static final int FPS = 30;

    private Thread thread;
    private boolean running;
    private final int targetTime = 1000 / FPS;
    private BufferedImage image;
    private static Graphics2D g;
    private GameStateManager gsm;

    /**
     * Create our JPanel for the game.
     */
    public GameEngine() {
        super();
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT3 * SCALE));
        setFocusable(true);
        requestFocus();
    }

    /**
     * Add notify to our JPanel.
     */
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * Main method that run the game and loop the update and draw of all components.
     */
    public void run() {

        init();

        long start;
        long elapsed;
        long wait;

        while (running) {

            start = System.currentTimeMillis();

            update();
            draw();
            drawToScreen();

            elapsed = System.currentTimeMillis() - start;

            wait = targetTime - elapsed / 1000;
            if (wait < 0) {
                wait = targetTime;
            }
            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Initialize the {@link GameStateManager} and add a KeyListener from
     * {@link KeyInput}.
     */
    private void init() {
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT3, 1);
        g = (Graphics2D) image.getGraphics();
        gsm = new GameStateManager();
        super.addKeyListener(new KeyInput(gsm));
    }

    private void update() {
        gsm.update();
    }

    private void draw() {
        gsm.draw(g);
    }

    private void drawToScreen() {
        final Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT3 * SCALE, null);
        g2.dispose();
    }

    /**
     * Gets the g.
     *
     * @return g
     */
    public static Graphics2D getG() {
        return g;
    }

}
