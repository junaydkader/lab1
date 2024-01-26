import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert.*;

import java.awt.*;

public class CarTest extends TestCase {

    Saab95 saab95;
    Volvo240 volvo240;

    @BeforeEach
    public void setUp() throws Exception {
        saab95 = new Saab95();
        volvo240 = new Volvo240();
        super.setUp();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMove() {
        saab95.gas(0.5);
        saab95.move();
        assertEquals(saab95.getX(), 0.625 );
        assertEquals(saab95.getY(), 0.0);
    }

    @Test
    public void testTurnLeft() {
        saab95.turnLeft();
        assertEquals(saab95.getAngle(), Math.PI/2);
    }
    @Test
    public void testIntCurrSpeed() {

        assertTrue(saab95.getCurrentSpeed() >= 0 && saab95.getCurrentSpeed() <= saab95.getEnginePower() );
    }
    
    @Test
    public void testTurnRight() {
        saab95.turnRight();
        assertEquals(saab95.getAngle(), -Math.PI/2);
    }

    @Test
    public void testGetNrDoors() {
        assertEquals(saab95.getNrDoors(), 2);
    }

    @Test
    public void testGetEnginePower() {
        assertEquals(saab95.getEnginePower(), 125.0);
    }
    @Test
    public void testGetCurrentSpeed() {
        assertEquals(saab95.getCurrentSpeed(), 0.0);
    }
    @Test
    public void testGetColor() {
        assertEquals(saab95.getColor(), Color.red);
    }
    @Test
    public void testSetColor() {
        saab95.setColor(Color.black);
        assertEquals(saab95.getColor(), Color.black);
    }
    @Test
    public void testStartEngine() {
        saab95.startEngine();
        assertEquals(saab95.getCurrentSpeed(), 0.1);
    }
    @Test
    public void testStopEngine() {
        saab95.stopEngine();
        assertEquals(saab95.getCurrentSpeed(), 0.0);
    }

    @Test
    public void testIncrementSpeed() {
        saab95.gas(1);
        assertEquals(saab95.getCurrentSpeed(), 1.25);
    }
    @Test
    public void testDecrementSpeed() {
        saab95.gas(1);
        saab95.brake(0.5);
        assertEquals(saab95.getCurrentSpeed(), 0.625);
    }
    @Test
    public void testGas() {
        saab95.gas(1);
        assertEquals(saab95.getCurrentSpeed(), 1.25);

    }

    @Test
    public void testBrake() {
        saab95.brake(1);
        assertEquals(saab95.getCurrentSpeed(), 0.0);

    }

    @Test
    public void testException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> saab95.brake(-1));
    }




}