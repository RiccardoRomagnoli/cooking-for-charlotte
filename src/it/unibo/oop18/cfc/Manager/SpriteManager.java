package it.unibo.oop18.cfc.Manager;

import java.io.IOException;

import it.unibo.oop18.cfc.Sprite.PlayerSprites;
import it.unibo.oop18.cfc.Sprite.SpriteSheet;

public class SpriteManager {

    private final PlayerSprites playerSprites;
    
    public SpriteManager(final String path) throws IOException {
        final SpriteSheet ss = new SpriteSheet(path);
        this.playerSprites = new PlayerSprites(ss);
    }
    
    /**
     * @return the playerSprite
     */
    public PlayerSprites getPlayerSprites() {
        return playerSprites;
    }

}
