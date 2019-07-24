// The main playing GameState.
// Contains everything you need for gameplay:
// Player, TileMap, Diamonds, etc.
// Updates and draws all game objects.

package it.unibo.oop18.cfc.GameState;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import it.unibo.oop18.cfc.Entity.Player;
import it.unibo.oop18.cfc.Entity.PlayerImpl;
import it.unibo.oop18.cfc.HUD.DownHud;
import it.unibo.oop18.cfc.HUD.TopHud;
import it.unibo.oop18.cfc.Main.GamePanel;
import it.unibo.oop18.cfc.Manager.Data;
import it.unibo.oop18.cfc.Manager.GameStateManager;
import it.unibo.oop18.cfc.Manager.Keys;
import it.unibo.oop18.cfc.TileMap.TileMap;
import it.unibo.oop18.cfc.Util.JukeBox;

public class PlayState extends GameState {

    // player
    private Player player;

    // tilemap
    private TileMap tileMap;

    // hud
    private TopHud tophud;
    private DownHud downhud;

    // events
    private boolean blockInput;
    private boolean eventStart;
    private boolean eventFinish;
    private int eventTick;

    // time
    private long ticks;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {

        // load map
        tileMap = new TileMap(64);
        tileMap.loadTiles("/Tilesets/tilesheet.png");
        tileMap.loadMap("/Maps/testmap1.map");

        // create player
        player = new PlayerImpl(tileMap);

        // initialize player
        player.setTilePosition(3, 7);
        player.setTotalPoints(1000);

        // load hud
        tophud = new TopHud(this);
        downhud = new DownHud(this, player.numPoints());

        // load music
        // JukeBox.load("/Music/bgmusic.mp3", "music1");
        // JukeBox.setVolume("music1", -10);
        // JukeBox.loop("music1", 1000, 1000, JukeBox.getFrames("music1") - 1000);
        // JukeBox.load("/Music/finish.mp3", "finish");
        // JukeBox.setVolume("finish", -10);

        // load sfx
        JukeBox.load("/SFX/collect.wav", "collect");
        JukeBox.load("/SFX/mapmove.wav", "mapmove");
        JukeBox.load("/SFX/tilechange.wav", "tilechange");
        JukeBox.load("/SFX/splash.wav", "splash");

        // start event
        // eventStart = true;
        // eventStart();

    }

    public void update() {

        // check keys
        handleInput();

        // check events

        // fine game
        if (0 == 2) {
            eventFinish = true;
            blockInput = true;
        }

        if (tileMap.isMoving()) {
            return;
        }

        // update player
        player.update();

        // time goes on
        ticks++;
    }

    public void draw(Graphics2D g) {

        // draw tilemap
        tileMap.draw(g);

        // draw player
        player.draw(g);

        // draw hud
        tophud.draw(g);
        downhud.draw(g);
    }

    public void handleInput() {
        if (Keys.isPressed(Keys.ESCAPE)) {
            JukeBox.stop("music1");
            gsm.setState(GameStates.PAUSE);
        }
        if (blockInput)
            return;
        if (Keys.isDown(Keys.LEFT))
            player.setLeft();
        if (Keys.isDown(Keys.RIGHT))
            player.setRight();
        if (Keys.isDown(Keys.UP))
            player.setUp();
        if (Keys.isDown(Keys.DOWN))
            player.setDown();
        if (Keys.isPressed(Keys.SPACE))
            player.setAction();
    }

    // Used to update time.
    public long getTicks() {
        return ticks;
    }
}
