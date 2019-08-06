// The main playing GameState.
// Contains everything you need for gameplay:
// Player, TileMap, Diamonds, etc.
// Updates and draws all game objects.

package it.unibo.oop18.cfc.GameState;

import java.awt.Graphics2D;
import java.io.IOException;

import it.unibo.oop18.cfc.HUD.DownHud;
import it.unibo.oop18.cfc.HUD.TopHud;
import it.unibo.oop18.cfc.Manager.GameStateManager;
import it.unibo.oop18.cfc.World.World;
import it.unibo.oop18.cfc.World.WorldImpl;


public class PlayState extends GameState {

    private World world;
    private TopHud topHud;
    private DownHud downHud;
    public PlayState(final GameStateManager gsm) {
        super(gsm, GameStates.PLAY);
    }

    public void init(){
        try {
            this.world = new WorldImpl();
            this.topHud = new TopHud(this);
            this.downHud = new DownHud(world);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        world.update();
    }

    public void draw(final Graphics2D g) {
        world.draw(g);
        topHud.draw(g);
        downHud.draw(g);
    }

    public World getWorld() {
        return this.world;
    }
}
