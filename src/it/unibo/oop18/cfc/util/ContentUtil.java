package it.unibo.oop18.cfc.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import it.unibo.oop18.cfc.gamestate.InfoState;
import it.unibo.oop18.cfc.main.GameEngine;

/**
 * Loads and splits all sprites on start up. The sprites can easily be accessed
 * as they are public and static.
 */
public final class ContentUtil {

    private static final float FONT_SIZE = 30f;
    private static final Image MENU = loadImage("/HUD/menu.png", 1024, 768);
    private static final Image OPTIONS = loadImage("/HUD/options.png", 1024, 768);
    private static final Image INFO = loadImage("/HUD/menu.png", 1024, 768);
    private static final Image RANK = loadImage("/HUD/rank.png", 1024, 768);
    private static final Image PAUSE = loadImage("/HUD/pause.png", 1024, 768);
    private static final Image TOPBAR = loadImage("/HUD/topbar.png", 1024, 128);
    private static final Image DOWNBAR = loadImage("/HUD/downbar.png", 1024, 128);
    private static final Image BLUEBAR = loadImage("/HUD/bluebar.png", 153, 5);
    private static final Image ARROWUP = loadImage("/HUD/arrowUp.png", 50, 50);
    private static final Image ARROWDOWN = loadImage("/HUD/arrowDown.png", 50, 50);
    private static final BufferedImage[][] LOADBAR = loadBufferedImage("/Sprites/loadbar.png", 30, 20);
    private static final Font MYFONT = initFont("/HUD/seguibl.ttf", FONT_SIZE);

    private ContentUtil() {

    }

    /**
     * Load an {@link Image} from a String path with specific width and height.
     * 
     * @param s the String of the path
     * @param w the width to be printed
     * @param h .. the height to be printed
     * @return the image or null if there is an error
     */
    private static Image loadImage(final String s, final int w, final int h) {
        Image ret;
        try {
            ret = ImageIO.read(ContentUtil.class.getResource(s)).getScaledInstance(w, h, Image.SCALE_SMOOTH);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading graphics.");
            System.exit(0);
        }
        return null;
    }

    /**
     * Load the font for the game.
     * 
     * @param s the path of the file with font
     * @param size the size of the font
     * 
     * @return the font of the game
     */
    private static Font initFont(final String s, final float size) {
        Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, InfoState.class.getResourceAsStream(s));
            font = font.deriveFont(size);
            return font;
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Load a {@link BufferedImage} from a String path with specific width and
     * height for each element.
     * 
     * @param s the String of the path
     * @param w the width of a single element
     * @param h .. the height of a single element
     * @return the image or null if there is an error
     */
    private static BufferedImage[][] loadBufferedImage(final String s, final int w, final int h) {
        BufferedImage[][] ret;
        try {
            final BufferedImage spritesheet = ImageIO.read(ContentUtil.class.getResourceAsStream(s));
            final int width = spritesheet.getWidth() / w;
            final int height = spritesheet.getHeight() / h;
            ret = new BufferedImage[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    ret[i][j] = spritesheet.getSubimage(j * w, i * h, w, h);
                }
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading graphics.");
            System.exit(0);
        }
        return null;
    }

    /**
     * Draw a String in specific position.
     * 
     * @param g graphic of the screen
     * @param s String to be printed
     * @param x the x position to start draw
     * @param y the y position to start draw
     */
    public static void drawStringFont(final Graphics2D g, final int x, final int y, final String s) {
        g.setFont(MYFONT);
        g.setColor(Color.BLACK);
        g.drawString(s, x, y);
    }

    /**
     * Draw a String in specific position with specific font size.
     * 
     * @param g graphic of the screen
     * @param s String to be printed
     * @param x the x position to start draw
     * @param y the y position to start draw
     * @param c the color of the String
     */
    public static void drawStringFont(final Graphics2D g, final int x, final int y, final String s, final Color c) {
        g.setFont(MYFONT);
        g.setColor(c);
        g.drawString(s, x, y);
    }

    /**
     * Draw a blue bar in specific location.
     * 
     * @param g     {@link Graphics2D} the screen
     * @param x     the x position to draw
     * @param y     the y position to draw
     * @param width the width of the bar
     */
    public static void drawBlueBar(final Graphics2D g, final int x, final int y, final int width) {
        g.drawImage(BLUEBAR.getScaledInstance(width, BLUEBAR.getHeight(null), Image.SCALE_SMOOTH), x, y, null);
    }

    /**
     * Draw load bar in specific location.
     * 
     * @param g      {@link Graphics2D} the screen
     * @param x      the x position to draw
     * @param y      the y position to draw
     * @param width  the width of the bar
     * @param height the height of the bar
     * @param color  the color of the bar
     */
    public static void drawLoadBar(final Graphics2D g, final int x, final int y, final int width, final int height,
            final int color) {
        g.drawImage(LOADBAR[0][color].getScaledInstance(width, height, Image.SCALE_SMOOTH), x, y, null);
    }

    /**
     * Draw menu.
     * 
     * @param g {@link Graphics2D} the screen
     */
    public static void drawMenu(final Graphics2D g) {
        g.drawImage(MENU, 0, 0, null);
    }

    /**
     * Draw options.
     * 
     * @param g {@link Graphics2D} the screen
     */
    public static void drawOptions(final Graphics2D g) {
        g.drawImage(OPTIONS, 0, 0, null);
    }

    /**
     * Draw info.
     * 
     * @param g {@link Graphics2D} the screen
     */
    public static void drawInfo(final Graphics2D g) {
        g.drawImage(INFO, 0, 0, null);
    }

    /**
     * Draw rank.
     * 
     * @param g {@link Graphics2D} the screen
     */
    public static void drawRank(final Graphics2D g) {
        g.drawImage(RANK, 0, 0, null);
    }

    /**
     * Draw pause.
     * 
     * @param g {@link Graphics2D} the screen
     */
    public static void drawPause(final Graphics2D g) {
        g.drawImage(PAUSE, 0, 0, null);
    }

    /**
     * Draw top hud.
     * 
     * @param g {@link Graphics2D} the screen
     */
    public static void drawTopHud(final Graphics2D g) {
        g.drawImage(TOPBAR, 0, 0, null);

    }

    /**
     * Draw bot hud.
     * 
     * @param g {@link Graphics2D} the screen
     */
    public static void drawBotHud(final Graphics2D g) {
        g.drawImage(DOWNBAR, 0, GameEngine.HEIGHT2, null);
    }

    /**
     * Draw load bar in specific location.
     * 
     * @param g      {@link Graphics2D} the screen
     * @param x      the x position to draw
     * @param y      the y position to draw
     * @param width  the width of the bar
     * @param height the height of the bar
     */
    public static void drawArrowUp(final Graphics2D g, final int x, final int y, final int width, final int height) {
        g.drawImage(ARROWUP.getScaledInstance(width, height, Image.SCALE_SMOOTH), x, y, null);
    }

    /**
     * Draw load bar in specific location.
     * 
     * @param g      {@link Graphics2D} the screen
     * @param x      the x position to draw
     * @param y      the y position to draw
     * @param width  the width of the bar
     * @param height the height of the bar
     */
    public static void drawArrowDown(final Graphics2D g, final int x, final int y, final int width, final int height) {
        g.drawImage(ARROWDOWN.getScaledInstance(width, height, Image.SCALE_SMOOTH), x, y, null);
    }
}
