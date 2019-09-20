package happyapp.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathTest {
    MathHelper mathHelper = new MathHelper();

    @Test
    public void testIfNumberIsNotNull() {
        assertNotNull(mathHelper.getRandomInt(1, 7));
    }
}
