package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Orders.Order;
import it.unibo.oop18.cfc.Orders.OrderImpl;

public class OrderGraphicComponent implements GraphicsComponent {
    
    private final Order order;

    public OrderGraphicComponent(Order order) {
        this.order = order;
    }

    @Override
    public void draw(Graphics2D g) {

    }

}
