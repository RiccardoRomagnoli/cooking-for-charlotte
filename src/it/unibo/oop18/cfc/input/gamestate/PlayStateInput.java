package it.unibo.oop18.cfc.input.gamestate;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import it.unibo.oop18.cfc.gamestate.GameState;
import it.unibo.oop18.cfc.gamestate.GameStates;
import it.unibo.oop18.cfc.gamestate.PlayState;
import it.unibo.oop18.cfc.physics.Direction;
import it.unibo.oop18.cfc.util.JukeBoxUtil;


/**
 * Play State Input Class.
 *
 */
public class PlayStateInput implements GameStateInput {

    private final PlayState playState;
    /**
     * Pair where a direction value is assigned to a boolean value.
     */
    private final Map<Integer, Boolean> keys;

    /**
     * Create a Game State Input.
     * @param playState related state
     */
    public PlayStateInput(final GameState playState) {
        this.playState = (PlayState) playState;
        keys = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    public void processInputPressed(final KeyEvent e) {
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
        case KeyEvent.VK_Q:// TODO : da togliere solo per debug
            this.playState.getGsm().setState(GameStates.GAMEOVER);
            way = Optional.empty();
            break;
        case KeyEvent.VK_SPACE:
            cutIngredient(true);
            way = Optional.empty();
            break;
        case KeyEvent.VK_P:
        case KeyEvent.VK_ESCAPE:
            JukeBoxUtil.stop("themeSong");
            resetKeys();
            this.playState.getGsm().requestPauseState();
        default:
            way = Optional.empty();
            break;
        }
        if (keys.keySet().contains(e.getKeyCode())) {
            keys.put(e.getKeyCode(), true);
        }
        this.moveEntity(way);
    }

    /**
     * {@inheritDoc}
     */
    public void processInputReleased(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.cutIngredient(false);
            this.doAction();
        }
        if (keys.keySet().contains(e.getKeyCode())) {
            keys.put(e.getKeyCode(), false);
        }
        if (keys.values().stream().filter(k -> k).count() == 1) {
            keys.keySet().forEach(k -> {
                if (keys.get(k)) {
                    this.moveEntity(Optional.of(keyToDir(k)));
                }
            });
        }
        handleStopPlayer(e);
    }

    /**
     * Clear any unwanted configurations.
     */
    public void resetKeys() {
        this.keys.put(KeyEvent.VK_LEFT, false);
        this.keys.put(KeyEvent.VK_RIGHT, false);
        this.keys.put(KeyEvent.VK_UP, false);
        this.keys.put(KeyEvent.VK_DOWN, false);
        this.keys.put(KeyEvent.VK_SPACE, false);
    }

    private void cutIngredient(final boolean cut) {
        this.playState.getWorld().getPlayer().setCutAction(cut);
    }
    private void moveEntity(final Optional<Direction> way) {
        if (way.isPresent()) {
            this.playState.getWorld().getPlayer().getInput().move(way.get());
        }
    }

    private void doAction() {
        this.playState.getWorld().getPlayer().getInput().doAction();
    }

    private void handleStopPlayer(final KeyEvent e) {
        if (keys.values().stream().filter(k -> k).count() == 0 && keys.keySet().contains(e.getKeyCode())) {
            this.playState.getWorld().getPlayer().getInput().stop();
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
