package it.unibo.oop18.cfc.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import it.unibo.oop18.cfc.GameState.GameState;
import it.unibo.oop18.cfc.GameState.GameStates;
import it.unibo.oop18.cfc.GameState.MenuState;
import it.unibo.oop18.cfc.GameState.OptionState;
import it.unibo.oop18.cfc.GameState.PlayState;
import it.unibo.oop18.cfc.Manager.GameStateManager;
import it.unibo.oop18.cfc.Objects.Entity.PlayerImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.PlateImpl;
import it.unibo.oop18.cfc.Physics.Direction;
import it.unibo.oop18.cfc.Util.JukeBoxUtil;

/**
 * KeyInput that implements {@link KeyListener} to manage the running state
 * input.
 */
public class KeyInput implements KeyListener {

    private GameState currentState;
    private final GameStateManager gsm;
    private PlayerImpl player;

    /**
     * Pair where a direction value is assigned to a boolean value.
     * TODO. non so cosa faccia sta roba, qualcuno aggiusti la javadoc
     */
    public Map<Integer, Boolean> keys;

    /**
     * Creates {@code KeyInput}.
     * 
     * @param gsm state manager used to set state Pause
     */
    public KeyInput(final GameStateManager gsm) {
        this.gsm = gsm;
        keys = new HashMap<>();
        keys.put(KeyEvent.VK_LEFT, false);
        keys.put(KeyEvent.VK_RIGHT, false);
        keys.put(KeyEvent.VK_UP, false);
        keys.put(KeyEvent.VK_DOWN, false);
    }

    /**
     * TODO.
     * 
     * @param pl .
     */
    public void setPlayer(final PlayerImpl pl) {
        this.player = pl;
    }

    /**
     * It generates a {@link Direction} when specific key is pressed and call
     * specific method on specific Game State.
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        currentState = gsm.getCurrentGameState();
        switch (currentState.getGameStateName()) {
        case PLAY:
            this.player = ((PlayState) currentState).getWorld().getPlayer();
            playKeyInput(e);
            break;
        case INTRO:
            introKeyInput(e);
            break;
        case GAMEOVER:
            gameOverKeyInput(e);
            break;
        case MENU:
            menuKeyInput(e);
            break;
        case PAUSE:
            pauseKeyInput(e);
            break;
        case INFO:
            infoKeyInput(e);
            break;
        case OPTION:
            optionKeyInput(e);
            break;
        default:
            break;
        }
    }

    private void optionKeyInput(final KeyEvent e) {
        gsm.setState(GameStates.OPTION);
        final OptionState option = (OptionState) currentState;
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            option.goUp();
            break;
        case KeyEvent.VK_DOWN:
            option.goDown();
            break;
        case KeyEvent.VK_RIGHT:
            option.increase();
            break;
        case KeyEvent.VK_LEFT:
            option.decrease();
            break;
        default:
            break;
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gsm.setState(GameStates.MENU);
            JukeBoxUtil.play("collect");
        }
    }

    // key pressed during play state
    private void playKeyInput(final KeyEvent e) {
        final Optional<Direction> way;
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
            way = Optional.ofNullable(Direction.LEFT);
            break;
        case KeyEvent.VK_DOWN:
            way = Optional.ofNullable(Direction.DOWN);
            break;
        case KeyEvent.VK_RIGHT:
            way = Optional.ofNullable(Direction.RIGHT);
            break;
        case KeyEvent.VK_UP:
            way = Optional.ofNullable(Direction.UP);
            break;
        case KeyEvent.VK_SPACE:
            this.doAction();
            way = Optional.empty();
            break;
        case KeyEvent.VK_P:
        case KeyEvent.VK_ESCAPE:
            JukeBoxUtil.stop("music1");
            this.launchPause();
        default:
            way = Optional.empty();
            break;
        }
        if (keys.keySet().contains(e.getKeyCode())) {
            keys.put(e.getKeyCode(), true);
        }
        this.moveEntity(way);
    }

    // key pressed during intro state
    private void introKeyInput(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gsm.setState(GameStates.MENU);
            JukeBoxUtil.play("collect");
        }
    }

    // key pressed during game over state
    private void gameOverKeyInput(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gsm.setState(GameStates.MENU);
            JukeBoxUtil.play("collect");
        }
    }

    // key pressed during menu state
    private void menuKeyInput(final KeyEvent e) {
        final MenuState menu = (MenuState) currentState;
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            menu.goUp();
            break;
        case KeyEvent.VK_DOWN:
            menu.goDown();
            break;
        case KeyEvent.VK_ENTER:
            menu.select();
        default:
            break;
        }
    }

    // key pressed during pause state
    private void pauseKeyInput(final KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_ESCAPE:
        case KeyEvent.VK_P:
            gsm.setState(GameStates.PLAY);
            JukeBoxUtil.resumeLoop("music1");
            break;
        case KeyEvent.VK_F1:
            gsm.setState(GameStates.MENU);
            break;
        default:
            break;
        }
    }

    private void infoKeyInput(final KeyEvent e) {
        gsm.setState(GameStates.MENU);
    }

    /**
     * It stops the player when a key button is released. If more than one key is
     * pressed, on release the player continues to move to the current key being
     * pressed
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        if (gsm.getCurrentGameState().getGameStateName() == GameStates.PLAY) {
            if (keys.keySet().contains(e.getKeyCode())) {
                keys.put(e.getKeyCode(), false);
            }
            if (keys.values().stream().filter(k -> k == true).count() == 1) {
                keys.keySet().forEach(k -> {
                    if (keys.get(k)) {
                        this.moveEntity(Optional.of(keyToDir(k)));
                    }
                });

            }
            handleStopPlayer(e);
        }
    }

    @Override
    public void keyTyped(final KeyEvent e) {

    }

    private void launchPause() {
        this.gsm.setState(GameStates.PAUSE);
    }

    private void moveEntity(final Optional<Direction> way) {
        if (way.isPresent()) {
            this.player.getInput().move(way.get());
        }
    }

    private void doAction() {
        this.player.getInput().doAction();
    }

    private void handleStopPlayer(final KeyEvent e) {
        if (keys.values().stream().filter(k -> k == true).count() == 0 && keys.keySet().contains(e.getKeyCode())) {
            this.player.getInput().stop();
        }
    }

    private Direction keyToDir(final Integer k) {
        Direction dir = Direction.STOP;
        switch (k) {
        case KeyEvent.VK_DOWN:
            dir = Direction.DOWN;
            break;
        case KeyEvent.VK_UP:
            dir = Direction.UP;
            break;
        case KeyEvent.VK_LEFT:
            dir = Direction.LEFT;
            break;
        case KeyEvent.VK_RIGHT:
            dir = Direction.RIGHT;
            break;
        default:
            break;
        }
        return dir;
    }

}
