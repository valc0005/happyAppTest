package happyapp.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class HappyTest {
    @Test
    public void NotNullTest() {

        MathHelper thing = new MathHelper();

        assertNotNull("Verify that thing is NOT null", thing.getRandomInt(1, 10));

    }
}
