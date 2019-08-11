package it.unibo.oop18.cfc.object.entity;

import java.util.Optional;

import it.unibo.oop18.cfc.input.PlayerInputComponent;
import it.unibo.oop18.cfc.object.items.Item;
import it.unibo.oop18.cfc.util.Position;

public interface Player extends DynamicObject {
    
    void increasePoints();

    int getPoints();
    
    int getTotalPoints();
    
    void setTotalPoints(int i);
    
    int getLifes();

    void decLifes();
    
    Optional<Item> getItemInHand();

    void setItemInHand(Item i);

    void removeItemInHand();
    
    boolean isCutting();
    
    void setCutAction(boolean b);
    
    /**
     * Gets the player's input component.
     *
     * @return {@link PlayerInputComponent}
     */
    PlayerInputComponent getInput();
    
    void doAction();

    void cutIngredient();

    Position getNextPosition();

}
