// The entry point of the game.
// This class loads up a JFrame window and
// puts a GamePanel into it.

package it.unibo.oop18.cfc.main;

import javax.swing.JFrame;
import it.unibo.oop18.cfc.util.ContentUtil;

/**
 * Graphics basic class. Entry point of the game. this class loads up a JFrame
 * window and puts a GamePanel into it.
 */
public final class Game {

    private Game() {

    }

    /**
     * Main.
     * 
     * @param args command line args
     */
    public static void main(final String[] args) {

        final JFrame window = new JFrame("Cooking for Charlotte");
        window.setIconImage(ContentUtil.ICON);
        window.add(new GameEngine());
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
