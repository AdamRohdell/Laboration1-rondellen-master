package test;

import main.model.vehicles.transport.CarFerry;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarFerryTest {

    @Test
    public void raiseRamp() {
        CarFerry ferry = new CarFerry();
        assertEquals(0, ferry.ramp.getCurrentAngle(), 0 );
        ferry.raiseRamp();
        assertEquals(1, ferry.ramp.getCurrentAngle(), 0 );
    }

    @Test
    public void lowerRamp() {
        CarFerry ferry = new CarFerry();
        ferry.raiseRamp();
        assertEquals(1, ferry.ramp.getCurrentAngle(), 0 );
        ferry.lowerRamp();
        assertEquals(0, ferry.ramp.getCurrentAngle(), 0 );
    }

    @Test
    public void gas() {
    }

    @Test
    public void brake() {
    }
}