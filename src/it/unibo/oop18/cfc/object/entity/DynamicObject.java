package it.unibo.oop18.cfc.object.entity;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.object.GameObject;
import it.unibo.oop18.cfc.physics.DynamicPhysicsComponent;
import it.unibo.oop18.cfc.world.World;

/**
 * Interface for moving object.
 */
public interface DynamicObject extends GameObject {

    /**
     * Process input entity.
     */
    void update();

    /**
     * Gets the entity's physics.
     * 
     * @return a physics component.
     */
    DynamicPhysicsComponent getPhysics();

    /**
     * Gets the world.
     * 
     * @return world that contains {@code AbstractEntity}
     */
    World getWorld();

    /**
     * Renders object's sprite.
     * 
     * @param g component that draw the sprite
     */
    void draw(Graphics2D g);

}
