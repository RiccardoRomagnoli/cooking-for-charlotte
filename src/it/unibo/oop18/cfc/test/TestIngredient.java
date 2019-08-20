package it.unibo.oop18.cfc.test;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.IngredientState;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.world.World;
import it.unibo.oop18.cfc.world.WorldImpl;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

/**
 * This class test some Ingredient features like .
 */
public class TestIngredient {

    /**
     * This class test some ingredient features, such the creation and the state
     * changing.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testIngredientCreation() throws IOException {
          final World world = new WorldImpl(new GameStateManager()); 
          final ItemManager im = world.getItemManager();
          // creation of the ingredients
          final IngredientImpl bread = new IngredientImpl(im, IngredientType.BREAD);
          final IngredientImpl lettuce = new IngredientImpl(im, IngredientType.LETTUCE);
          final IngredientImpl tomato = new IngredientImpl(im, IngredientType.TOMATO);
          final IngredientImpl meat = new IngredientImpl(im, IngredientType.MEAT);
          final IngredientImpl cookedMeat = new IngredientImpl(im, IngredientType.MEAT, IngredientState.PERFECT);
          //testing the right creation
          Assert.assertTrue(bread.getState() == IngredientState.RAW);
          Assert.assertTrue(lettuce.getState() == IngredientState.RAW);
          Assert.assertTrue(tomato.getState() == IngredientState.RAW);
          Assert.assertTrue(meat.getState() == IngredientState.RAW);
          Assert.assertTrue(cookedMeat.getState() == IngredientState.PERFECT);
          //testing that the states change right 
          bread.changeState(IngredientState.CHOPPED);
          lettuce.changeState(IngredientState.CHOPPED);
          tomato.changeState(IngredientState.CHOPPED);
          meat.changeState(IngredientState.PERFECT);
          Assert.assertTrue(bread.getState() == IngredientState.CHOPPED);
          Assert.assertTrue(lettuce.getState() == IngredientState.CHOPPED);
          Assert.assertTrue(tomato.getState() == IngredientState.CHOPPED);
          Assert.assertTrue(meat.getState() == IngredientState.PERFECT);
    }
}
