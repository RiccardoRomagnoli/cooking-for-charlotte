package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.manager.Content;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.RankingImpl;

/**
 * Menu manager class. Provide methods to manage the selection of options and
 * the printing of the options
 */
public class MenuState extends GameState {

    private BufferedImage bg;
    private BufferedImage food;
    private static final int STRING_POS = 350;
    private static final int IMAGE_POS = 280;
    private int currentOption;
    private final String[] options = { "START", "OPTIONS", "INFO", "RANKING NOOO", "QUIT" };
    private final int menuOptions = options.length;
    private final int[] dim = { 300, 360, 420, 480, 540 };

    /**
     * Menu state init.
     * 
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
        JukeBoxUtil.load("/SFX/menuresized.wav", "menuSong");
        if (!JukeBoxUtil.isPlaying("menuSong")) {
            JukeBoxUtil.loop("menuSong");
        } else {
            JukeBoxUtil.resume("menuSong");
        }

    }

    /**
     * {@inheritDoc}.
     */
    public void update() {

    }

    /**
     * {@inheritDoc}..
     *
     * @param g the g
     */
    public void draw(final Graphics2D g) {
        g.drawImage(bg, 0, 0, null);
        for (int i = 0; i < menuOptions; i++) {
            Content.drawString(g, options[i], STRING_POS, dim[i]);
        }
        g.drawImage(food, IMAGE_POS, dim[currentOption], null);
    }

    /**
     * Action to be performed when a menu entry is pressed.
     */
    private void selectOption() {
        final Graphics2D g = GameEngine.getG();
        if (currentOption == 0) {
            gsm.newGame();
            JukeBoxUtil.stop("menuSong");
        }
        if (currentOption == 1) {
            gsm.setState(GameStates.OPTION);
            gsm.draw(g);
        }
        if (currentOption == 2) {
            gsm.setState(GameStates.INFO);
            gsm.draw(g);
        }
        if (currentOption == 3) {
            gsm.setState(GameStates.RANKING);
            gsm.draw(g);
        }
        if (currentOption == 4) {
            JukeBoxUtil.stop("menuSong");
            JukeBoxUtil.closeResource();
            System.exit(0); // TODO. trovare un metodo meno brutale
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
