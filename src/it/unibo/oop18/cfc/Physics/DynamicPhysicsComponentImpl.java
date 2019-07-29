package it.unibo.oop18.cfc.Physics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.TileMap.Tile;
import it.unibo.oop18.cfc.TileMap.TileMap;

public class DynamicPhysicsComponentImpl implements DynamicPhysicsComponent{
	
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
    private BufferedImage stopSprite;
    


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
        stopSprite = Content.PLAYER[0][0];
        
        //to do
        animation.setFrame(stopSprite);
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
    	animation.setFrame(stopSprite);
    }

    public void moveLeft() {
        if (moving)
            return;
        left = true;
        moving = validateNextPosition();
    }

    public void moveRight() {
        if (moving)
            return;
        right = true;
        moving = validateNextPosition();
    }

    public void moveUp() {
        if (moving)
            return;
        up = true;
        moving = validateNextPosition();
    }

    public void moveDown() {
        if (moving)
            return;
        down = true;
        moving = validateNextPosition();
    }

    // Returns whether or not the entity can
    // move into the next position.
    public boolean validateNextPosition() {

        if (moving)
            return true;

        rowTile = y / tileSize;
        colTile = x / tileSize;

        if (left) {
            if (colTile == 0 || tileMap.getType(rowTile, colTile - 1) != Tile.NORMAL) {
                return false;
            } else {
                xdest = x - tileSize;
            }
        }
        if (right) {
            if (colTile == tileMap.getNumCols() || tileMap.getType(rowTile, colTile + 1) != Tile.NORMAL) {
                return false;
            } else {
                xdest = x + tileSize;
            }
        }
        if (up) {
            if (rowTile == 0 || tileMap.getType(rowTile - 1, colTile) != Tile.NORMAL) {
                return false;
            } else {
                ydest = y - tileSize;
            }
        }
        if (down) {
            if (rowTile == tileMap.getNumRows() - 1 || tileMap.getType(rowTile + 1, colTile) != Tile.NORMAL) {
                return false;
            } else {
                ydest = y + tileSize;
            }
        }
        return true;
    }

    // Calculates the destination coordinates.
    public void getNextPosition() {

        if (left && x > xdest)
            x -= moveSpeed;
        else
            left = false;
        if (left && x < xdest)
            x = xdest;

        if (right && x < xdest)
            x += moveSpeed;
        else
            right = false;
        if (right && x > xdest)
            x = xdest;

        if (up && y > ydest)
            y -= moveSpeed;
        else
            up = false;
        if (up && y < ydest)
            y = ydest;

        if (down && y < ydest)
            y += moveSpeed;
        else
            down = false;
        if (down && y > ydest)
            y = ydest;

    }
    
    /**
     * @param i
     * @param bi
     * @param d
     */
    private void setAnimation(final Direction dir, final BufferedImage[] bi, final int delay) {
        currentDirection = dir;
        animation.setFrames(bi);
        animation.setDelay(delay);
    }

    public void update() {
    	
        if (down) {
            if (currentDirection != Direction.DOWN) {
                setAnimation(Direction.DOWN, downSprites, 10);
            }
        }
        if (left) {
            if (currentDirection != Direction.LEFT) {
                setAnimation(Direction.LEFT, leftSprites, 10);
            }
        }
        if (right) {
            if (currentDirection != Direction.RIGHT) {
                setAnimation(Direction.RIGHT, rightSprites, 10);
            }
        }
        if (up) {
            if (currentDirection != Direction.UP) {
                setAnimation(Direction.UP, upSprites, 10);
            }
        }

        // get next position
        if (moving)
            getNextPosition();

        // check stop moving
        if (x == xdest && y == ydest) {
            left = right = up = down = moving = false;
            rowTile = y / tileSize;
            colTile = x / tileSize;
        }

        // update animation
        animation.update();

    }

    // Draws the entity.
    public void draw(Graphics2D g) {
        g.drawImage(animation.getImage(), x - width / 2, y - height / 2 + 128, null);
    }
}
