// The main playing GameState.
// Contains everything you need for gameplay:
// Player, TileMap, Diamonds, etc.
// Updates and draws all game objects.

package it.unibo.oop18.cfc.GameState;

import java.awt.Graphics2D;
import java.io.IOException;

import it.unibo.oop18.cfc.Manager.GameStateManager;
import it.unibo.oop18.cfc.World.WorldImpl;


public class PlayState extends GameState {

    private WorldImpl world;

    public PlayState(GameStateManager gsm) {
        super(gsm, GameStates.PLAY);
    }



    public void init(){
        try {
            this.world = new WorldImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        world.update();
    }

    public void draw(Graphics2D g) {
        world.draw(g);
    }
}
