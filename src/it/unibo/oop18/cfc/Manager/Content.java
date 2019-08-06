package it.unibo.oop18.cfc.Manager;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * Loads and splits all sprites on start up. The sprites can easily be accessed
 * as they are public and static.
 * TODO We should change class name
 */
public class Content {

    public static final BufferedImage[][] MENUBG = load("/HUD/menu.png", 1024, 768);
    public static final BufferedImage[][] TOPBAR = load("/HUD/topbar.png", 1024, 128);
    public static final BufferedImage[][] DOWNBAR = load("/HUD/downbar.png", 1024, 128);
    public static final BufferedImage[][] FOOD = load("/Sprites/Food.png", 50, 50);

    public static BufferedImage[][] font = load("/HUD/font.png", 50, 50);

    public static final BufferedImage[][] load(final String s, final int w, final int h) {
        BufferedImage[][] ret;
        try {
            BufferedImage spritesheet = ImageIO.read(Content.class.getResourceAsStream(s));
            int width = spritesheet.getWidth() / w;
            int height = spritesheet.getHeight() / h;
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
            final int row = c / font[0].length;
            final int col = c % font[0].length;
            g.drawImage(font[row][col], x + 50 * i, y, null);
        }
    }

}
