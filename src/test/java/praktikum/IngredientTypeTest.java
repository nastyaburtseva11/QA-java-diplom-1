package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class IngredientTypeTest {


    private final String type;
    private final boolean expected;

    public IngredientTypeTest(String type, boolean expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"SAUCE", true},
                {"FILLING", true},
                {"", false},
                {"BUN", false}
        };
    }

    @Test
    public void testIngredientType() {
        boolean actual = true;
        try {
            String actualType = IngredientType.valueOf(type).toString();
            Assert.assertEquals(type, actualType);
        } catch (IllegalArgumentException e) {
            actual = false;
        }
        Assert.assertEquals("Incorrect ingredient type", expected, actual);
    }

}
