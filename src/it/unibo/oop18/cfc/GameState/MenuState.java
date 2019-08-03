// The main menu GameState.

package it.unibo.oop18.cfc.GameState;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Manager.GameStateManager;
import it.unibo.oop18.cfc.Util.JukeBoxUtil;

/**
 * Menu manager class. Provide methods to manage the selection of options and
 * the printing of the options
 */
public class MenuState extends GameState {

    private BufferedImage bg;
    private BufferedImage food;
    //private final int height = GamePanel.HEIGHT;
    private final int stringPos = 350;
    private final int imagePos = 280;
    private int currentOption = 0;
    private String[] options = { "START", "OPTIONS", "INFO", "QUIT" };

    private int menuOptions = options.length;

    private int[] dim = { 300, 360, 420, 480 };

    /**
     * Menu state init.
     * @param gsm game state manager
     */
    public MenuState(final GameStateManager gsm) {
        super(gsm, GameStates.MENU);
    }

    /**
     * Initialize the menu screen and load the sounds.
     */
    public void init() {
        bg = Content.MENUBG[0][0];
        food = Content.FOOD[6][2];
        JukeBoxUtil.load("/SFX/collect.wav", "collect");
        JukeBoxUtil.load("/SFX/menuoption.wav", "menuoption");
    }

    /**
     * 
     */
    public void update() {
        // handleInput();
    }

    /**
     * Print the main menu on screen.
     * 
     * @param g is the image to be printed
     */
    public void draw(final Graphics2D g) {

        g.drawImage(bg, 0, 0, null);

        for (int i = 0; i < menuOptions; i++) {
            Content.drawString(g, options[i], stringPos, dim[i]);
        }
        g.drawImage(food, imagePos, dim[currentOption], null);

    }

    /**
     * Action to be performed when a menu entry is pressed.
     */
    private void selectOption() {
        if (currentOption == 0) {
            gsm.newGame();
        }
        if (currentOption == 3) {
            System.exit(0);
        }
    }

    /**
     * Up botton pressed.
     */
    public void goUp() {
        if (currentOption > 0) {
            JukeBoxUtil.play("menuoption");
            currentOption--;
        }
    }

    /**
     * Down button pressed.
     */
    public void goDown() {
        if (currentOption < options.length - 1) {
            JukeBoxUtil.play("menuoption");
            currentOption++;
        }
    }

    /**
     * Enter button pressed.
     */
    public void select() {
        JukeBoxUtil.play("collect");
        selectOption();
    }

}
