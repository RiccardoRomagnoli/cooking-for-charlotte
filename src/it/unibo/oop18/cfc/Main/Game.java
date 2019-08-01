package it.unibo.oop18.cfc.Main;

import javax.swing.JFrame;

/**
 * Graphics basic class. Entry point of the game. this class loads up a JFrame
 * window and puts a GamePanel into it.
 */
public class Game {
    /**
     * Main.
     * 
     * @param args command line args
     */
    public static void main(final String[] args) {

        JFrame window = new JFrame("Cooking for Charlotte");
        window.add(new GamePanel());
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
