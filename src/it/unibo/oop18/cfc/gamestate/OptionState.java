package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
/**
 * Option menu manager.
 */
public class OptionState extends GameState {

    private static final int STRING_POS = 80;
    private static final int IMAGE_POS = 20;
    private static final int FONT_HEIGTH = 50;
    private static final int FONT_LENGTH = 50;

    private BufferedImage bg;
    private BufferedImage food;
    private final String[] options = { "volume", "resolution", "quit" };
    private static List<Integer> volume = new ArrayList<Integer>(Arrays.asList(0, 15, 30, 45, 60, 75, 90, 100));
    private int lastVolIndex = 1;
    private int lastResIndex;
    private static List<String> resolution = new ArrayList<String>(Arrays.asList("1400x900", "800x600", "640x480"));
    private final int numOptions = options.length;
    private int currentOption;
    private final int[] dim = { 300, 360, 420, 480 };

    /**
     * Class constructor.
     * 
     * @param gsm game state
     */
    public OptionState(final GameStateManager gsm) {
        super(gsm, GameStates.OPTION);
    }

    /**
     * {@inheritDoc}.
     */
    public void init() {
        bg = ContentUtil.MENUBG[0][0];
        food = ContentUtil.FOOD[6][2];
    }

    /**
     * {@inheritDoc}.
     */
    public void update() {

    }

    /**
     * {@inheritDoc}.
     * 
     * @param g basic graphics
     */
    public void draw(final Graphics2D g) {
        g.drawImage(bg, 0, 0, null);
        for (int i = 0; i < numOptions; i++) {
            ContentUtil.drawString(g, options[i], STRING_POS, dim[i]);
        }
        g.drawImage(food, IMAGE_POS, dim[currentOption], null);
        g.drawRect(STRING_POS, dim[currentOption], FONT_HEIGTH * options[currentOption].length(), FONT_LENGTH);

        ContentUtil.drawString(g, volume.get(lastVolIndex).toString(), STRING_POS * 8 - 30, dim[0]);
        ContentUtil.drawString(g, resolution.get(lastResIndex), STRING_POS * 8 - 30, dim[1]);
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
     * Right button pressed. Increase the volume / resolution
     */
    public void increase() {
        JukeBoxUtil.play("menuoption");
        JukeBoxUtil.stop("menuSong");
        if (currentOption == 0 && lastVolIndex < volume.size() - 1) {
            lastVolIndex++;
            JukeBoxUtil.setVolume(volume.get(lastVolIndex));
        } else if (currentOption == 1 && lastResIndex < resolution.size() - 1) {
            lastResIndex++;
        }
        JukeBoxUtil.resume("menuSong");
    }

    /**
     * Left button pressed. Decrease Volume/Resolution
     */
    public void decrease() {
        JukeBoxUtil.play("menuoption");
        JukeBoxUtil.stop("menuSong");
        if (currentOption == 0 && lastVolIndex > 0) {
            lastVolIndex--;
            JukeBoxUtil.setVolume(volume.get(lastVolIndex));
        } else if (currentOption == 1 && lastResIndex > 0) {
            lastResIndex--;
        }
        JukeBoxUtil.resume("menuSong");
    }
}
