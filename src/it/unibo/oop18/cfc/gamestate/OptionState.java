package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.unibo.oop18.cfc.input.gamestate.OptionStateInput;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.SoundUtil;

/**
 * Option menu manager.
 */
public class OptionState extends GameState {

    private static final int STRING_POS = 250;
    private static final List<Integer> VOLUME = new ArrayList<Integer>(Arrays.asList(0, 15, 30, 45, 60, 75, 90, 100));
    private static final int POSITION_X_OPTION = 610;
    private static final int DIMENSION_FONT = 23;
    private static final String[] OPTION = { "Volume", "Resolution", "Quit" };
    private static final int[] POSITION_Y_OPTION = { 400, 450, 500 };

    private int lastVolIndex = 1;
    private int lastResIndex;
    private static List<String> resolution = new ArrayList<String>(Arrays.asList("1400x900", "800x600", "640x480"));
    private int currentOption;

    /**
     * Class constructor.
     * 
     * @param gsm game state
     */
    public OptionState(final GameStateManager gsm) {
        super(gsm, GameStates.OPTION);
        super.setInput(new OptionStateInput(this));
    }

    /**
     * {@inheritDoc}.
     */
    public void init() {
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
        ContentUtil.drawOptions(g);
        for (int i = 0; i < OPTION.length; i++) {
            ContentUtil.drawStringFont(g, STRING_POS, POSITION_Y_OPTION[i], OPTION[i]);
        }
        ContentUtil.drawBlueBar(g, STRING_POS - 10, POSITION_Y_OPTION[currentOption] + 4,
                OPTION[currentOption].length() * DIMENSION_FONT);
        ContentUtil.drawStringFont(g, POSITION_X_OPTION, POSITION_Y_OPTION[0], VOLUME.get(lastVolIndex).toString());
        ContentUtil.drawStringFont(g, POSITION_X_OPTION, POSITION_Y_OPTION[1], resolution.get(lastResIndex));
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
        if (currentOption < OPTION.length - 1) {
            JukeBoxUtil.play(SoundUtil.OPTION_SOUND);
            currentOption++;
        }
    }

    /**
     * Right button pressed. Increase the volume / resolution
     */
    public void increase() {
        JukeBoxUtil.play(SoundUtil.BUTTON_SOUND);
        JukeBoxUtil.stop(SoundUtil.MENU_SOUND);
        if (currentOption == 0 && lastVolIndex < VOLUME.size() - 1) {
            lastVolIndex++;
            JukeBoxUtil.setVolume(VOLUME.get(lastVolIndex));
        } else if (currentOption == 1 && lastResIndex < resolution.size() - 1) {
            lastResIndex++;
        }
        JukeBoxUtil.resume(SoundUtil.MENU_SOUND);
    }

    /**
     * Left button pressed. Decrease Volume/Resolution
     */
    public void decrease() {
        JukeBoxUtil.play(SoundUtil.BUTTON_SOUND);
        JukeBoxUtil.stop(SoundUtil.MENU_SOUND);
        if (currentOption == 0 && lastVolIndex > 0) {
            lastVolIndex--;
            JukeBoxUtil.setVolume(VOLUME.get(lastVolIndex));
        } else if (currentOption == 1 && lastResIndex > 0) {
            lastResIndex--;
        }
        JukeBoxUtil.resume(SoundUtil.MENU_SOUND);
    }
}
