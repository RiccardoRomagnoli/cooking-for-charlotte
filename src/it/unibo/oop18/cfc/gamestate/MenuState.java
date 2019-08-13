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

    private static final int STRING_POS = 350;
    private static final int IMAGE_POS = 280;
    private int currentOption;
    private final String[] options = { "START", "OPTIONS", "INFO", "RANKING", "QUIT" };
    private final int menuOptions = options.length;
    private final int[] dim = { 300, 360, 420, 480, 540 };

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
        JukeBoxUtil.load("/SFX/collect.wav", "collect");
        JukeBoxUtil.load("/SFX/menuoption.wav", "menuoption");
        JukeBoxUtil.load("/SFX/menuSong.wav", "menuSong");
        if (!JukeBoxUtil.isPlaying("menuSong")) {
            JukeBoxUtil.loop("menuSong");
        } else {
            JukeBoxUtil.resume("menuSong");
        }
        JukeBoxUtil.stop("themeSong");
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
        ContentUtil.drawFood(g, IMAGE_POS, dim[currentOption]);
        for (int i = 0; i < menuOptions; i++) {
            ContentUtil.drawString(g, options[i], STRING_POS, dim[i]);
        }
    }

    /**
     * Action to be performed when a menu entry is pressed.
     */
    private void selectOption() {
        final Graphics2D g = GameEngine.getG();
        if (currentOption == 0) {
            getGsm().newGame();
            JukeBoxUtil.stop("menuSong");
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
            JukeBoxUtil.stop("menuSong");
            JukeBoxUtil.closeResource();
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
