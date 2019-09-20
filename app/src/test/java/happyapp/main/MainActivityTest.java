package happyapp.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {
    MainActivity mainActivity = new MainActivity();

    @Test
    public void testRun() {
        assertNotNull(mainActivity);
    }
}