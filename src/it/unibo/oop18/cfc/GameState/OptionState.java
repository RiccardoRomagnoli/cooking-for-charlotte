package it.unibo.oop18.cfc.GameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.unibo.oop18.cfc.Main.GameEngine;
import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Manager.GameStateManager;
import it.unibo.oop18.cfc.Util.JukeBoxUtil;

/**
 * Option menu manager.
 * 
 *
 */
public class OptionState extends GameState {

    private Color color;
    private static List<Integer> volume = new ArrayList<Integer>(Arrays.asList(0, 15, 30, 45, 60, 75, 90, 100));
    private static List<String> resolution = new ArrayList<String>(Arrays.asList("1920x1080", "800*600", "1024*512"));
    private static int initialVolume = volume.get(volume.size() - 1);
    private static String initialResolution = resolution.get(resolution.size() - 1);
    private static int volumeIndex = volume.size();
    private static int resolutionIndex = resolution.size();
    private static int actualVolume = volume.get(volume.size() - 1);
    private static String actualResolution = resolution.get(resolution.size() - 1);

    /**
     * Class constructor.
     * 
     * @param gsm game state
     */
    public OptionState(final GameStateManager gsm) {
        super(gsm, GameStates.OPTION);
    }

    /**
     * Init class.
     */
    public void init() {

    }

    /**
     * Update class. Nothing has to be done until it is on this menu
     */
    public void update() {
    }

    /**
     * Draw elements on the option screen.
     * 
     * @param g basic graphics
     */
    public void draw(final Graphics2D g) {
        // Resolution and audio volume
        color = new Color(164, 198, 222);
        g.setColor(color);
        g.fillRect(0, 0, GameEngine.WIDTH, GameEngine.HEIGHT2);

        Content.drawString(g, "VOLUME", 400, 200);

        Content.drawString(g, Integer.toString(actualVolume), 400, 270);

        Content.drawString(g, "RESOLUTION", 200, 200);

        Content.drawString(g, resolution.get(resolutionIndex), 200, 270);

        Content.drawString(g, "F1: return to menu", 120, 410);

    }

    /**
     * When i press the right/left button i can increase/decrease the resolution
     * When i press the up/down button i can increase/decrease the volume
     * 
     */

    /**
     * Up botton pressed. Increase volume
     */
    public static void increaseVolume() {
        JukeBoxUtil.play("menuoption");
        if (volumeIndex < volume.size()) {
            volumeIndex--;
            actualVolume = volume.get(volumeIndex-1);
        }
    }

    /**
     * Down button pressed. Decrease volume
     */
    public static void decreaseVolume() {
        JukeBoxUtil.play("menuoption");
        if (volumeIndex > 0) {
            volumeIndex--;
            actualVolume = volume.get(volumeIndex-1);
        }
    }

    /**
     * Left botton pressed. Decrease resolution
     */
    public void decreaseResolution() {
        JukeBoxUtil.play("menuoption");
        if (resolutionIndex <= 0) {
            resolutionIndex = resolution.size();
        } else {
            resolutionIndex--;
        }
        setActualResolution(resolution.get(resolutionIndex-1));
    }

    /**
     * Rigth button pressed. Increase resolution
     */
    public static void increaseResolution() {
        JukeBoxUtil.play("menuoption");
        if (resolutionIndex >= resolution.size()) {
            resolutionIndex = 0;
        } else {
            resolutionIndex--;
        }
        setActualResolution(resolution.get(resolutionIndex-1));
    }
    
    public static List<Integer> getVolume() {
        return volume;
    }

    public static void setVolume(final List<Integer> volume) {
        OptionState.volume = volume;
    }

    public static int getInitialVolume() {
        return initialVolume;
    }

    public static void setInitialVolume(final int initialVolume) {
        OptionState.initialVolume = initialVolume;
    }

    public static String getInitialResolution() {
        return initialResolution;
    }

    public static void setInitialResolution(final String initialResolution) {
        OptionState.initialResolution = initialResolution;
    }

    public static String getActualResolution() {
        return actualResolution;
    }

    public static void setActualResolution(final String actualResolution) {
        OptionState.actualResolution = actualResolution;
    }
}
