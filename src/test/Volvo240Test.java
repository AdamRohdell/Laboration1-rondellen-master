package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.model.vehicles.cars.Volvo240;

import java.awt.*;

public class Volvo240Test {

	@Test
	public void testSpeedFactor() {
		Volvo240 volvo = new Volvo240();
		assertEquals(1.25, volvo.speedFactor(), 0.0);
	}


	
	@Test
	public void testGas() {
		Volvo240 volvo = new Volvo240();
		volvo.gas(-40);
		assertTrue(volvo.getCurrentSpeed() >= 0);
	}

	@Test
	public void testTurnLeft() {
		// turn left 4 times shall mean that we are back to 0 deg
		Volvo240 volvo = new Volvo240();

		assertEquals(0, volvo.getDirection().getAngle(), 0);
		volvo.turnLeft();
		assertEquals(3, volvo.getDirection().getAngle(), 0);
		volvo.turnLeft();
		assertEquals(2, volvo.getDirection().getAngle(), 0);
		volvo.turnLeft();
		assertEquals(1, volvo.getDirection().getAngle(), 0);
		volvo.turnLeft();
		assertEquals(0, volvo.getDirection().getAngle(), 0);

	}

	@Test
	public void testTurnRight() {
		Volvo240 volvo = new Volvo240();

		assertEquals(0, volvo.getDirection().getAngle(), 0);
		volvo.turnRight();
		assertEquals(1, volvo.getDirection().getAngle(), 0);
		volvo.turnRight();
		assertEquals(2, volvo.getDirection().getAngle(), 0);
		volvo.turnRight();
		assertEquals(3, volvo.getDirection().getAngle(), 0);
		volvo.turnRight();
		assertEquals(0, volvo.getDirection().getAngle(), 0);
	}

	@Test
	public void testMove() {
		Volvo240 volvo = new Volvo240();
		volvo.setPosition(new Point(0,0));
		assertEquals(volvo.getPosition().x, 0, 0);
		volvo.move();
		assertEquals(volvo.getPosition().x += volvo.getCurrentSpeed(), volvo.getPosition().x, 0);
	}


	@Test
	public void testGetCurrentSpeed() {
		Volvo240 volvo = new Volvo240();
		//speed shall be 0 from start
		assertEquals(0, volvo.getCurrentSpeed(),0);
	}


}
