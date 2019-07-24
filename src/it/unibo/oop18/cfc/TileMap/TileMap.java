package it.unibo.oop18.cfc.TileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import it.unibo.oop18.cfc.Main.GamePanel;

/**
 * This class create and edit the tilemap.
 */
public class TileMap {

    // position
    private int x;
    private int y;
    private int xdest;
    private int ydest;
    private int speed;
    private boolean moving;

    // bounds
    private int xmin;
    private int ymin;
    private int xmax;
    private int ymax;

    // map
    private int[][] map;
    private int tileSize;
    private int numRows;
    private int numCols;
    private int width;
    private int height;

    // tileset
    private BufferedImage tileset;
    private int numTilesCols;
    private int numTilesRows;
    private Tile[][] tiles;

    // drawing
    private int numRowsToDraw;
    private int numColsToDraw;

    /**
     * Constructor of the class. Set the tilesize, the speed and calculate the rows
     * and cols of the tilemap
     * 
     * @param tileSize The size of the tile
     */
    public TileMap(final int tileSize) {
        this.tileSize = tileSize;
        numRowsToDraw = GamePanel.HEIGHT / tileSize;
        numColsToDraw = GamePanel.WIDTH / tileSize;
        speed = 4;
    }

    /**
     * Load all the tiles into the tiles matrix.
     * 
     * @param s The name of the file with tiles
     */
    public void loadTiles(final String s) {

        try {

            tileset = ImageIO.read(getClass().getResourceAsStream(s));
            numTilesCols = tileset.getWidth() / tileSize;
            numTilesRows = tileset.getHeight() / tileSize;
            tiles = new Tile[numTilesRows][numTilesCols];

            BufferedImage subimage;

            for (int row = 0; row < numTilesRows; row++) {
                for (int col = 0; col < numTilesCols; col++) {
                    subimage = tileset.getSubimage(col * tileSize, row * tileSize, tileSize, tileSize);
                    if (row == 0) {
                        tiles[row][col] = new Tile(subimage, Tile.NORMAL);
                    } else if (row == numTilesRows - 1) {
                        tiles[row][col] = new Tile(subimage, Tile.BLOCKED);
                    } else {
                        tiles[row][col] = new Tile(subimage, col + row * numTilesRows);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Load the map of the game based of the bitmap.
     * 
     * @param s The name of the file with the bitmap
     */
    public void loadMap(final String s) {

        try {

            final InputStream in = getClass().getResourceAsStream(s);
            final BufferedReader br = new BufferedReader(new InputStreamReader(in));

            numCols = Integer.parseInt(br.readLine());
            numRows = Integer.parseInt(br.readLine());
            map = new int[numRows][numCols];
            width = numCols * tileSize;
            height = numRows * tileSize;

            xmin = GamePanel.WIDTH - width;
            xmin = -width;
            xmax = 0;
            ymin = GamePanel.HEIGHT - height;
            ymin = -height;
            ymax = 0;

            final String delims = "\\s+";
            for (int row = 0; row < numRows; row++) {
                final String line = br.readLine();
                final String[] tokens = line.split(delims);
                for (int col = 0; col < numCols; col++) {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return tileSize
     */
    public int getTileSize() {
        return tileSize;
    }

    /**
     * @return x
     */
    public int getx() {
        return x;
    }

    /**
     * @return y
     */
    public int gety() {
        return y;
    }

    /**
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return numRows
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * @return numCols
     */
    public int getNumCols() {
        return numCols;
    }

    /**
     * @param row the row of the tile
     * @param col the col of the tile
     * @return the type of the tile at position row col
     */
    public int getType(final int row, final int col) {
        final int rc = map[row][col];
        final int r = rc / numTilesCols;
        final int c = rc % numTilesCols;
        return tiles[r][c].getType();
    }

    /**
     * @param row the row of the tile
     * @param col the col of the tile
     * @return the index of the bitmap at position row col
     */
    public int getIndex(final int row, final int col) {
        return map[row][col];
    }

    /**
     * @return if the map is moving
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     * @param row   the row of the tile
     * @param col   the col of the tile
     * @param index set the tile of the map at position row col
     */
    public void setTile(final int row, final int col, final int index) {
        map[row][col] = index;
    }

    /**
     * @param i1 the number of the tile that need to be replaced
     * @param i2 the new number in the bitmap
     */
    public void replace(final int i1, final int i2) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (map[row][col] == i1) {
                    map[row][col] = i2;
                }
            }
        }
    }

    /**
     * @param x the new position of the map at coord x
     * @param y the new position of the map at coord y
     */
    public void setPosition(final int x, final int y) {
        xdest = x;
        ydest = y;
    }

    /**
     * @param x the istant position of the map at coord x
     * @param y the istant position of the map at coord y
     */
    public void setPositionImmediately(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     */
    public void fixBounds() {
        if (x < xmin) {
            x = xmin;
        }

        if (y < ymin) {
            y = ymin;
        }

        if (x > xmax) {
            x = xmax;
        }

        if (y > ymax) {
            y = ymax;
        }

    }

    /**
     * 
     */
    public void update() {
        if (x < xdest) {
            x += speed;
            if (x > xdest) {
                x = xdest;
            }
        }
        if (x > xdest) {
            x -= speed;
            if (x < xdest) {
                x = xdest;
            }
        }
        if (y < ydest) {
            y += speed;
            if (y > ydest) {
                y = ydest;
            }
        }
        if (y > ydest) {
            y -= speed;
            if (y < ydest) {
                y = ydest;
            }
        }

        fixBounds();

        if (x != xdest || y != ydest) {
            moving = true;
        } else {
            moving = false;
        }

    }

    /**
     * @param g the element that need to be drawn
     */
    public void draw(final Graphics2D g) {

        for (int row = 0; row < numRowsToDraw; row++) {

            if (row >= numRows) {
                break;
            }

            for (int col = 0; col < numColsToDraw; col++) {

                if (col >= numCols) {
                    break;
                }
                if (map[row][col] == 0) {
                    continue;
                }

                final int rc = map[row][col];
                final int r = rc / numTilesCols;
                final int c = rc % numTilesCols;

                g.drawImage(tiles[r][c].getImage(), x + col * tileSize, y + row * tileSize + GamePanel.HUDHEIGHT, null);

            }

        }

    }

}
