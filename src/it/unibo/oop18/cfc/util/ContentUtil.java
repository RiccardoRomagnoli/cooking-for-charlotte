package it.unibo.oop18.cfc.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageIO;

import it.unibo.oop18.cfc.gamestate.InfoState;
import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.world.WorldImpl;

/**
 * Loads and splits all sprites on start up. The sprites can easily be accessed
 * as they are public and static.
 */
public final class ContentUtil {

    private static final Image MENUBG = loadImage("/HUD/menu.png", 1024, 768);
    private static final Image TOPBAR = loadImage("/HUD/topbar.png", 1024, 128);
    private static final Image DOWNBAR = loadImage("/HUD/downbar.png", 1024, 128);
    private static final Image BLUEBAR = loadImage("/HUD/bluebar.png", 153, 5);
    private static final Image ARROWUP = loadImage("/HUD/arrowUp.png", 50, 50);
    private static final Image ARROWDOWN = loadImage("/HUD/arrowDown.png", 50, 50);
    private static final BufferedImage[][] FONT = loadBufferedImage("/HUD/font.png", 50, 50);
    private static final BufferedImage[][] LOADBAR = loadBufferedImage("/Sprites/loadbar.png", 30, 20);

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
     * TODO.
     * 
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
     * @param g graphic to be printed
     * @param s String to be printed
     * @param x Pos
     * @param y Pos
     */
    public static void drawStringFont(final Graphics2D g, final int x, final int y, final String s) {
        Font myFont = null;
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, InfoState.class.getResourceAsStream("/HUD/seguibl.ttf"));
            myFont = myFont.deriveFont(WorldImpl.FONT_SIZE);
            g.setFont(myFont);
            g.setColor(Color.BLACK);
            g.drawString(s, x, y);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Draw.
     * 
     * @param g graphic to be printed
     * @param s String to be printed
     * @param x Pos
     * @param y Pos
     * @param fontSize The font size
     */
    public static void drawStringFont(final Graphics2D g, final int x, final int y, final String s, final float fontSize) {
        Font myFont = null;
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, InfoState.class.getResourceAsStream("/HUD/seguibl.ttf"));
            myFont = myFont.deriveFont(fontSize);
            g.setFont(myFont);
            g.setColor(Color.BLACK);
            g.drawString(s, x, y);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Draw.
     * 
     * @param g      graphic to be printed
     * @param str    String to be printed
     * @param x      Pos
     * @param y      Pos
     * @param width  width
     * @param height height
     */
    public static void drawString(final Graphics2D g, final String str, final int x, final int y, final int width,
            final int height) {
        final String s = str.toUpperCase(Locale.getDefault());
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
        g.drawImage(MENUBG, 0, 0, null);
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
