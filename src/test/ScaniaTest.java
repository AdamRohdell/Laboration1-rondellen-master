package test;

import main.model.vehicles.transport.Scania;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaniaTest {

    @Test
    public void speedFactor() {
    }

    @Test
    public void turnLeft() {
    }

    @Test
    public void turnRight() {
    }

    @Test
    public void startEngine() {
        Scania c = new Scania();
        c.tipFlatbed(70);
        assertEquals(70, c.getFlatbed().getCurrentAngle(), 0);
        c.startEngine();
        assertEquals(0, c.getFlatbed().getCurrentAngle(), 0);
        c.tipFlatbed(70);
        assertEquals(0, c.getFlatbed().getCurrentAngle(), 0);
    }
}