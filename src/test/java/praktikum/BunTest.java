package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Before
    public void createBun() {
        bun = new Bun("black bun", 125);
    }

    @Test
    public void testGetName() {
        String actual = bun.getName();
        String expected = "black bun";
        assertEquals("Incorrect bun", expected, actual);
    }

    @Test
    public void testGetPrice() {
        float actual = bun.getPrice();
        float expected = 125;
        assertEquals("Incorrect price", expected, actual, 0);
    }
}
