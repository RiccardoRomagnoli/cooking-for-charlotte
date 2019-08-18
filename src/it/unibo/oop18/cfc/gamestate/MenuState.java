package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.SoundUtil;

/**
 * Menu manager class. Provide methods to manage the selection of options and
 * the printing of the options
 */
public class MenuState extends GameState {

    private static final int DIMENSION_FONT = 23;
    private int currentOption;
    private final String[] options = { "START", "OPTIONS", "INFO", "RANKING", "QUIT" };
    private final int menuOptions = options.length;
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
        JukeBoxUtil.load(SoundUtil.BUTTON_PATH, SoundUtil.BUTTON_SOUND);
        JukeBoxUtil.load(SoundUtil.OPTION_PATH, SoundUtil.OPTION_SOUND);
        JukeBoxUtil.load(SoundUtil.MENU_PATH, SoundUtil.MENU_SOUND);
        if (!JukeBoxUtil.isPlaying(SoundUtil.MENU_SOUND)) {
            JukeBoxUtil.loop(SoundUtil.MENU_SOUND);
        } else {
            JukeBoxUtil.resume(SoundUtil.MENU_SOUND);
        }
        JukeBoxUtil.stop(SoundUtil.THEME_SOUND);
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
        for (int i = 0; i < menuOptions; i++) {
            ContentUtil.drawStringFont(g, posx[i], posy[i], options[i]);
            ContentUtil.drawBlueBar(g, posx[currentOption] - 10, posy[currentOption] + 4,
                    options[currentOption].length() * DIMENSION_FONT);
        }
    }

    /**
     * Action to be performed when a menu entry is pressed.
     */
    private void selectOption() {
        if (currentOption == 0) {
            getGsm().newGame();
            JukeBoxUtil.stop(SoundUtil.MENU_SOUND);
        }
        if (currentOption == 1) {
            getGsm().setState(GameStates.OPTION);
        }
        if (currentOption == 2) {
            getGsm().setState(GameStates.INFO);
        }
        if (currentOption == 3) {
            getGsm().setState(GameStates.RANKING);
        }
        if (currentOption == 4) {
            JukeBoxUtil.stop(SoundUtil.MENU_SOUND);
            Runtime.getRuntime().exit(0);
        }
    }

    /**
     * Up botton pressed.
     */
    public void goUp() {
        if (currentOption > 0) {
            JukeBoxUtil.play(SoundUtil.OPTION_SOUND);
            currentOption--;
        }
    }

    /**
     * Down button pressed.
     */
    public void goDown() {
        if (currentOption < options.length - 1) {
            JukeBoxUtil.play(SoundUtil.OPTION_SOUND);
            currentOption++;
        }
    }

    /**
     * Enter button pressed.
     */
    public void select() {
        JukeBoxUtil.play(SoundUtil.BUTTON_SOUND);
        selectOption();
    }
}
