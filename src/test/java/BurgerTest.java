import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Test
    public void setBuns_test() {
        Bun bun = new Bun("Bulka", 12);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Bun actual =  burger.bun;
        assertEquals(actual.name, "Bulka");
    }

    @Test
    public void addIngredient_test() {
        Ingredient ingredient = new Ingredient(SAUCE, "Cheese", 2);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        assertEquals(burger.ingredients, ingredients);

    }

    @Test
    public void removeIngredient_test(){
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "Cheese", 2);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient_test() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "Cheese", 1);
        Ingredient ingredient1 = new Ingredient(SAUCE, "Cheese", 2);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0,1);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient);
        assertEquals(burger.ingredients, ingredients);
    }

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Test
    public void getPrice_test(){
        //Ingredient ingredient = new Ingredient(SAUCE, "Cheese", 2);
        Mockito.when(bun.getPrice()).thenReturn(500.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(500.0f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        assertEquals(actual, 1500, 0.0f);
    }

    @Test
    public void getReceipt_test(){
        Bun bun = new Bun("Bulka", 12);
        Ingredient ingredient = new Ingredient(SAUCE, "Cheese", 2);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        System.out.println(burger.getReceipt());
        String actual = burger.getReceipt();
        String expected = "(==== Bulka ====)\r\n" +
                "= sauce Cheese =\r\n" +
                "(==== Bulka ====)\r\n" +
                "\r\n" +
                "Price: 26,000000\r\n";

        assertEquals(expected, actual);
    }
}
