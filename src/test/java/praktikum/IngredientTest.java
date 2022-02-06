package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient;
    IngredientType sauce = IngredientType.SAUCE;

    @Before
    public void createIngredient() {
        ingredient = new Ingredient(sauce, "цезарь", 60);
    }

    @Test
    public void testGetName() {
        String actual = ingredient.getName();
        String expected = "цезарь";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {
        float actual = ingredient.getPrice();
        float expected = 60;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testGetType(){
        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(expected, actual);
    }
}
