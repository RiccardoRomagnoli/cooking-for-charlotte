package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.JukeBoxUtil;

/**
 * Menu manager class. Provide methods to manage the selection of options and
 * the printing of the options
 */
public class MenuState extends GameState {

    private int currentOption;
    private final String[] options = { "START", "OPTIONS", "INFO", "RANKING", "QUIT" };
    private final int menuOptions = options.length;
    /**
     * Enter button press sound.
     */
    public static final String BUTTON_SOUND = "collect";
    /**
     * Menu main sound.
     */
    public static final String MENU_SOUND = "menuSong";
    /**
     * Theme sound.
     */
    public static final String THEME_SOUND = "themeSong";
    /**
     * Menu Option sound.
     */
    public static final String OPTION_SOUND = "menuoption";

    private final int[] posy = { 350, 400, 450, 500, 550 };
    private final int[] posx = { 465, 445, 475, 442, 475 };

    /**
     * Menu state init.
     * 
     * @param gsm {@link GameStateManager}
     */
    public MenuState(final GameStateManager gsm) {
        super(gsm, GameStates.MENU);
    }

    /**
     * Initialize the menu screen and load the sounds.
     */
    public void init() {
        JukeBoxUtil.load("/SFX/collect.wav", BUTTON_SOUND);
        JukeBoxUtil.load("/SFX/menuoption.wav", OPTION_SOUND);
        JukeBoxUtil.load("/SFX/menuSong.wav", MENU_SOUND);
        if (!JukeBoxUtil.isPlaying(MENU_SOUND)) {
            JukeBoxUtil.loop(MENU_SOUND);
        } else {
            JukeBoxUtil.resume(MENU_SOUND);
        }
        JukeBoxUtil.stop(THEME_SOUND);
    }

    /**
     * {@inheritDoc}.
     */
    public void update() {

    }

    /**
     * {@inheritDoc}..
     */
    public void draw(final Graphics2D g) {
        ContentUtil.drawMenu(g);
        // ContentUtil.drawFood(g, IMAGE_POS, posy[currentOption]);
        for (int i = 0; i < menuOptions; i++) {
            // ContentUtil.drawString(g, options[i], STRING_POS, dim[i]);
            ContentUtil.drawStringFont(g, posx[i], posy[i], options[i]);
            ContentUtil.drawBlueBar(g, posx[currentOption] - 10, posy[currentOption] + 4,
                    options[currentOption].length() * 23, 5);
        }
    }

    /**
     * Action to be performed when a menu entry is pressed.
     */
    private void selectOption() {
        final Graphics2D g = GameEngine.getG();
        if (currentOption == 0) {
            getGsm().newGame();
            JukeBoxUtil.stop(MENU_SOUND);
        }
        if (currentOption == 1) {
            getGsm().setState(GameStates.OPTION);
            getGsm().draw(g);
        }
        if (currentOption == 2) {
            getGsm().setState(GameStates.INFO);
            getGsm().draw(g);
        }
        if (currentOption == 3) {
            getGsm().setState(GameStates.RANKING);
            getGsm().draw(g);
        }
        if (currentOption == 4) {
            JukeBoxUtil.stop(MENU_SOUND);
            System.exit(0);
        }
    }

    /**
     * Up botton pressed.
     */
    public void goUp() {
        if (currentOption > 0) {
            JukeBoxUtil.play(OPTION_SOUND);
            currentOption--;
        }
    }

    /**
     * Down button pressed.
     */
    public void goDown() {
        if (currentOption < options.length - 1) {
            JukeBoxUtil.play(OPTION_SOUND);
            currentOption++;
        }
    }

    /**
     * Enter button pressed.
     */
    public void select() {
        JukeBoxUtil.play(BUTTON_SOUND);
        selectOption();
    }
}
