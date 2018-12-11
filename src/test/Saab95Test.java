package test;

import main.model.vehicles.cars.Saab95;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Saab95Test {

    @Test
    public void setTurboOn() {
        Saab95 c = new Saab95();
         c.setTurboOn();
         assertTrue(c.getTurboStatus());
    }

    @Test
    public void setTurboOff() {
        Saab95 c = new Saab95();
        c.setTurboOff();
        assertFalse(c.getTurboStatus());
    }

    @Test
    public void speedFactor() {
        Saab95 saab= new Saab95();
        assertEquals(1.25, saab.speedFactor(), 0.0);
    }
    @Test
    public void testTurnLeft() {
        // turn left 4 times shall mean that we are back to 0 deg
        Saab95 saab = new Saab95();

        assertEquals(0, saab.getDirection().getAngle(), 0);
        saab.turnLeft();
        assertEquals(3, saab.getDirection().getAngle(), 0);
        saab.turnLeft();
        assertEquals(2, saab.getDirection().getAngle(), 0);
        saab.turnLeft();
        assertEquals(1, saab.getDirection().getAngle(), 0);
        saab.turnLeft();
        assertEquals(0, saab.getDirection().getAngle(), 0);

    }

    @Test
    public void testTurnRight() {
        Saab95 saab = new Saab95();

        assertEquals(0, saab.getDirection().getAngle(), 0);
        saab.turnRight();
        assertEquals(1, saab.getDirection().getAngle(), 0);
        saab.turnRight();
        assertEquals(2, saab.getDirection().getAngle(), 0);
        saab.turnRight();
        assertEquals(3, saab.getDirection().getAngle(), 0);
        saab.turnRight();
        assertEquals(0, saab.getDirection().getAngle(), 0);
    }


    @Test
    public void move() {
        Saab95 saab = new Saab95();
        saab.setPosition(new Point(0,0));
        assertEquals(saab.getPosition().x, 0, 0);
        saab.move();
        assertEquals(saab.getPosition().x += saab.getCurrentSpeed(), saab.getPosition().x, 0);
    }

}