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
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Ingredient ingredient1;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Bun actual =  burger.bun;
        assertEquals(bun, actual);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0,1);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient);
        assertEquals(ingredients, burger.ingredients);
    }


    @Test
    public void getPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn(500.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(500.0f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        assertEquals(1500, actual, 0.0f);
    }

    @Test
    public void getReceiptTest(){
        Mockito.when(bun.getName()).thenReturn("Bulka");
        Mockito.when(ingredient.getName()).thenReturn("Cheese");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(500.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(500.0f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = "(==== Bulka ====)\r\n" +
                "= sauce Cheese =\r\n" +
                "(==== Bulka ====)\r\n" +
                "\r\n" +
                "Price: 1500,000000\r\n";

        assertEquals(expected, actual);
    }
}