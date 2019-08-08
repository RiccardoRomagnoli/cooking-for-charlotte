package it.unibo.oop18.cfc.Objects.Items;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Util.Position;

public interface Item{

    void draw(Graphics2D g, Position p);

    void draw(Graphics2D g, Position p, int width, int height);
}
