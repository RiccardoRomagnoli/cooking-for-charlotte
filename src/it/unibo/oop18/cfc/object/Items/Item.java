package it.unibo.oop18.cfc.object.Items;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.util.Position;

public interface Item{

    void draw(Graphics2D g, Position p);

    void draw(Graphics2D g, Position p, int width, int height);
}
