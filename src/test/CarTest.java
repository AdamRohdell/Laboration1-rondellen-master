package test;

import static org.junit.Assert.*;

import main.model.vehicles.cars.Car;
import main.model.vehicles.cars.Volvo240;
import org.junit.Test;

import java.awt.*;

public class CarTest {

	@Test
	public void testCar() {
		Car c = new Volvo240();
		assertEquals(c.getNrDoors(), 4, 0);
		assertEquals(c.getClass(), Volvo240.class);
	}

	@Test
	public void testGetCurrentSpeed() {
		Car c = new Volvo240();
		c.startEngine();
		c.gas(1);
		assertEquals(c.getCurrentSpeed(), 1.25, 0.5);

	}

	@Test
	public void testGetColor() {
		Car c = new Volvo240();
		c.setColor(Color.red);
		assertEquals(c.getColor(), Color.red);
	}

	@Test
	public void testSetColor() {
		Car c = new Volvo240();
		c.setColor(Color.red);
		assertEquals(c.getColor(), Color.red);
	}

	@Test
	public void testStartEngine() {
		Car c = new Volvo240();
		c.startEngine();
		assertEquals(c.getCurrentSpeed(), 0.1, 0);
	}

	@Test
	public void testStopEngine() {
		Car c = new Volvo240();
		c.startEngine();
		assertEquals(c.getCurrentSpeed(), 0.1, 0);
		c.stopEngine();
		assertEquals(c.getCurrentSpeed(), 0, 0);
	}

	@Test
	public void testGas() {
		Car c = new Volvo240();
		assertEquals(c.getCurrentSpeed(), 0, 0);
		c.startEngine();
		c.gas(1.0);
		assertEquals(c.getCurrentSpeed(), 1.35, 0);
	}

	@Test
	public void testBrake() {
		Car c = new Volvo240();
		c.startEngine();
		c.gas(1.0);
		assertEquals(c.getCurrentSpeed(), 1.35, 0);
		c.brake(0.5);
		assertEquals(c.getCurrentSpeed(), 0.725, 0.0001);
	}


}
