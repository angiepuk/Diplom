import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void test_first_ingredient_type() {
        Ingredient ingredient = new Ingredient(SAUCE, "Lina", 1);
        IngredientType actual = ingredient.getType();
        assertEquals(actual, SAUCE);
    }
    @Test
    public void test_get_name(){
        Ingredient ingredient = new Ingredient(SAUCE, "Lina", 1);
        String actual = ingredient.getName();
        assertEquals(actual, "Lina");
    }
    @Test
    public void test_get_price(){
        Ingredient ingredient = new Ingredient(SAUCE, "Lina", 1);
        float actual = ingredient.getPrice();
        assertEquals(actual, 1, 0.0f);
    }
}
