package it.unibo.oop18.cfc.Objects.Items;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import it.unibo.oop18.cfc.Util.Position;

public class AbstractItem implements Item {

    private BufferedImage sprite;
    private static final int DIMITEM = 50;
    private Position position;

    public AbstractItem(Position position, BufferedImage s) {
        this.sprite = s;
        this.position = position;
    }

    public void draw(Graphics2D g) {
        g.drawImage(sprite, (int) position.getX() - DIMITEM / 2, (int) position.getY() - DIMITEM / 2, null);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Rectangle2D getBounds() {
        // TODO Auto-generated method stub
        return new Rectangle2D.Double(this.getPosition().getX(), this.getPosition().getY(), DIMITEM, DIMITEM);
    }

    public void getType() {
        
    };
}
