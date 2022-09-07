import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testName() {
        Bun bun = new Bun("Lada", 12);
        String actual = bun.getName();
        assertEquals("Lada", actual);
    }

    @Test
    public void testPrice() {
        Bun bun = new Bun("Lada", 12);
        float actual = bun.getPrice();
        assertEquals(12, actual,0.0f);
    }
}