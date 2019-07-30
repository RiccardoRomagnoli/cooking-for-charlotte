package it.unibo.oop18.cfc.Objects.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ItemImpl implements Item {

    private BufferedImage sprite;
    private final int width;
    private final int height;
    private static final int DIMITEM = 50;
    private int x;
    private int y;

    public ItemImpl(BufferedImage s) {
        this.width = DIMITEM;
        this.height = DIMITEM;
        this.sprite = s;
    }

    public void draw(Graphics2D g) {
        g.drawImage(sprite, x - width / 2, y - height / 2, null);
    }

}
