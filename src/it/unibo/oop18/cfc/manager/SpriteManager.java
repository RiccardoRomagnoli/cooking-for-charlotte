package it.unibo.oop18.cfc.manager;

import java.io.IOException;

import it.unibo.oop18.cfc.sprite.PlayerSprites;
import it.unibo.oop18.cfc.sprite.SpriteSheet;

/**
 * The Class SpriteManager.
 */
public class SpriteManager {

    private final PlayerSprites playerSprites;

    /**
     * Instantiates a new {@link SpriteManager}.
     *
     * @param path the path of the player sprite image
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public SpriteManager(final String path) throws IOException {
        final SpriteSheet ss = new SpriteSheet(path);
        this.playerSprites = new PlayerSprites(ss);
    }

    /**
     * Gets the player sprites.
     *
     * @return the {@link PlayerSprites}
     */
    public PlayerSprites getPlayerSprites() {
        return playerSprites;
    }

}
