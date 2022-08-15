import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void test_name() {
        Bun bun = new Bun("Lada", 12);
        String actual = bun.getName();
        assertEquals(actual, "Lada");
    }

    @Test
    public void test_price() {
        Bun bun = new Bun("Lada", 12);
        float actual = bun.getPrice();
        assertEquals(actual, 12,  0.0f);
    }
}