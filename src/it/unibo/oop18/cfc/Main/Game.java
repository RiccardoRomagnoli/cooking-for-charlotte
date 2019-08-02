// The entry point of the game.
// This class loads up a JFrame window and
// puts a GamePanel into it.

package it.unibo.oop18.cfc.Main;

import javax.swing.JFrame;

public class Game {

    public static void main(String[] args) {

        JFrame window = new JFrame("Cooking for Charlotte");

        window.add(new GameEngine());

        window.setResizable(false);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
