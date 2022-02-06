package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Before
    public void createBun() {
        bun = new Bun("булочка с кунжутом", 125);
    }

    @Test
    public void testGetName() {
        String actual = bun.getName();
        String expected = "булочка с кунжутом";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {
        float actual = bun.getPrice();
        float expected = 125;
        assertEquals(expected, actual, 0);
    }
}
