import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Volvo240Test extends TestCase {

    Volvo240 volvo240;

    @BeforeEach
    public void setUp() throws Exception {
        volvo240 = new Volvo240();
        super.setUp();
    }
    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testSpeedFactor() {
        assertEquals(volvo240.speedFactor(), 100 * 0.01 * 1.25);
    }
}