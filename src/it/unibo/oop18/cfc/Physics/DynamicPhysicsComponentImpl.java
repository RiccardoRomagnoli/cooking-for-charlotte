package it.unibo.oop18.cfc.Physics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.TileMap.Tile;
import it.unibo.oop18.cfc.TileMap.TileMap;

public class DynamicPhysicsComponentImpl implements DynamicPhysicsComponent{
	
	private static final int STEP_LENGHT = 4 * 3;
			
	// dimensions
    protected int width;
    protected int height;
    protected int cwidth;
    protected int cheight;

    // position
    protected int x;
    protected int y;
    protected int xdest;
    protected int ydest;
    protected int rowTile;
    protected int colTile;

    // movement
    protected boolean moving;
    protected boolean left;
    protected boolean right;
    protected boolean up;
    protected boolean down;

    // attributes
    protected int moveSpeed;

    // tilemap
    protected TileMap tileMap;
    protected int tileSize;

    // animation
    protected Animation animation;
    protected Direction currentDirection;
    
    // sprites
    private BufferedImage[] downSprites;
    private BufferedImage[] leftSprites;
    private BufferedImage[] rightSprites;
    private BufferedImage[] upSprites;
    private BufferedImage[] stopSprite;
    


    public DynamicPhysicsComponentImpl(TileMap tm) {
    	width = 64;
    	height = 64;

      	moveSpeed = 2;
      	
        tileMap = tm;
        tileSize = tileMap.getTileSize();
        animation = new AnimationImpl();
        
        downSprites = Content.PLAYER[0];
        leftSprites = Content.PLAYER[1];
        rightSprites = Content.PLAYER[2];
        upSprites = Content.PLAYER[3];
        //to do
        stopSprite = Content.PLAYER[0];
        
        //to do
        animation.setAnimation(Direction.STOP, stopSprite, 0);
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public int getRow() {
        return rowTile;
    }

    public int getCol() {
        return colTile;
    }

    public void setPosition(int i1, int i2) {
        x = i1;
        y = i2;
        xdest = x;
        ydest = y;
    }

    public void setTilePosition(int i1, int i2) {
        y = i1 * tileSize + tileSize / 2;
        x = i2 * tileSize + tileSize / 2;
        xdest = x;
        ydest = y;
    }
    
    public void stop() {
    	
    }

    public void move(Direction dir) {
    	currentDirection = dir;
    }

    public void update() {
    	
        // update animation
        animation.update();

    }

    // Draws the entity.
    public void draw(Graphics2D g) {
        g.drawImage(animation.getImage(), x - width / 2, y - height / 2 + 128, null);
    }
}
