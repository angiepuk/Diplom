import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void testFirstIngredientType() {
        Ingredient ingredient = new Ingredient(SAUCE, "Lina", 1);
        IngredientType actual = ingredient.getType();
        assertEquals(SAUCE, actual);
    }
    @Test
    public void testGetName(){
        Ingredient ingredient = new Ingredient(SAUCE, "Lina", 1);
        String actual = ingredient.getName();
        assertEquals("Lina", actual);
    }
    @Test
    public void testGetPrice(){
        Ingredient ingredient = new Ingredient(SAUCE, "Lina", 1);
        float actual = ingredient.getPrice();
        assertEquals(1, actual,0.0f);
    }
}
