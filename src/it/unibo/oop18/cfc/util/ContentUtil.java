package it.unibo.oop18.cfc.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import it.unibo.oop18.cfc.main.GameEngine;

/**
 * Loads and splits all sprites on start up. The sprites can easily be accessed
 * as they are public and static.
 */
public final class ContentUtil {

    private static final Image MENUBG = loadImage("/HUD/menu.png", 1024, 768);
    private static final Image TOPBAR = loadImage("/HUD/topbar.png", 1024, 128);
    private static final Image DOWNBAR = loadImage("/HUD/downbar.png", 1024, 128);
    private static final BufferedImage[][] FOOD = loadBufferedImage("/Sprites/Food.png", 50, 50);
    private static final BufferedImage[][] FONT = loadBufferedImage("/HUD/font.png", 50, 50);

    private ContentUtil() {

    }

    /**
     * @param s ..
     * @param w ..
     * @param h ..
     * @return ..
     */
    public static Image loadImage(final String s, final int w, final int h) {
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
     * @param s ..
     * @param w ..
     * @param h ..
     * @return ..
     */
    public static BufferedImage[][] loadBufferedImage(final String s, final int w, final int h) {
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
     * Draw.
     * 
     * @param g   graphic to be printed
     * @param str String to be printed
     * @param x   Pos
     * @param y   Pos
     */
    public static void drawString(final Graphics2D g, final String str, final int x, final int y) {
        drawString(g, str, x, y, FONT[0][0].getWidth(), FONT[0][0].getHeight());
    }

    /**
     * Draw.
     * 
     * @param g   graphic to be printed
     * @param str String to be printed
     * @param x   Pos
     * @param y   Pos
     * @param width   width
     * @param height  height
     */
    public static void drawString(final Graphics2D g, final String str, final int x, final int y, final int width,
            final int height) {
        final String s = str.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if(c == 47) c = 36; // slash
            if (c == 58) {
                c = 26; // colon
            }
            if (c == 32) {
                c = 28; // space
            }
            if (c >= 48 && c <= 57) {
                c -= 32; // numbers
            }
            if (c >= 65 && c <= 90) {
                c -= 32; // letters
            }
            final int row = c / FONT[0].length;
            final int col = c % FONT[0].length;
            g.drawImage(FONT[row][col], x + width * i, y, width, height, null);
        }
    }
    
    /**
     * Draw food in specific location.
     * 
     * @param g {@link Graphics2D} the screen
     * @param x the x position to draw
     * @param y the y position to draw
     */
    public static void drawFood(final Graphics2D g, final int x, final int y) {
        g.drawImage(FOOD[6][2], x, y, null);
    }
    
    /**
     * Draw menu.
     * 
     * @param g {@link Graphics2D} the screen
     */
    public static void drawMenu(Graphics2D g) {
        g.drawImage(MENUBG, 0, 0, null);
    }
    
    /**
     * Draw top hud.
     * 
     * @param g {@link Graphics2D} the screen
     */
    public static void drawTopHud(Graphics2D g) {
        g.drawImage(TOPBAR, 0, 0, null);

    }

    /**
     * Draw bot hud.
     * 
     * @param g {@link Graphics2D} the screen
     */
    public static void drawBotHud(Graphics2D g) {
        g.drawImage(DOWNBAR, 0, GameEngine.HEIGHT2, null);
    }
}
