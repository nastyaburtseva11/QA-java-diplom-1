package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Mock
    Ingredient ingredient;
    @Mock
    List<Ingredient> ingredients;

    @Test
    public void testAddIngredient() {
        burger.ingredients = ingredients;
        burger.addIngredient(ingredient);
        Mockito.verify(burger.ingredients).add(ingredient);
    }

    @Test
    public void testRemoveIngredient() {
        burger.ingredients = ingredients;
        burger.removeIngredient(2);
        Mockito.verify(burger.ingredients).remove(2);
    }

    @Test
    public void testMoveIngredient() {
        burger.ingredients = ingredients;
        burger.moveIngredient(2, 1);
        Mockito.verify(burger.ingredients).add(1, ingredients.remove(2));
    }

    @Test
    public void testGetPrice() {
        List<Ingredient> ingredients = new ArrayList<>();
        burger.ingredients = ingredients;
        ingredients.add(ingredient);
        ingredients.add(ingredient);
        ingredients.add(ingredient);
        burger.bun = bun;

        float bunPrice = 20F;
        float ingredientPrice = 10F;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        for (int i = 0; i < ingredients.size(); i++) {
            Mockito.when(ingredients.get(i).getPrice()).thenReturn(ingredientPrice);
        }
        float expectedPrice = (bunPrice * 2) + (3 * ingredientPrice);
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }
    @Test
    public void testGetReceipt(){
        String bunName = "red bun";
        float bunPrice = 100.000000f;
        IngredientType ingredientType = SAUCE;
        String ingredientName = "chili sauce";
        float ingredientPrice = 200.000000f;
        burger.bun = bun;
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        String actualReceipt = burger.getReceipt();
        StringBuilder stringBuildReceipt = new StringBuilder(String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bunName, ingredientType.toString().toLowerCase(), ingredientName, bunName,
                (bunPrice * 2 + ingredientPrice)));
        String expectedReceipt = stringBuildReceipt.toString();
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}
