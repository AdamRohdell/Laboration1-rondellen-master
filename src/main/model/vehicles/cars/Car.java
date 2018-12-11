package main.model.vehicles.cars;

import main.model.vehicles.Vehicle;

import java.awt.*;

public abstract class Car extends Vehicle {

	public enum Type{
		SEDAN, TRUCK
	}

	private int nrDoors; // Number of doors on the car
	private Color color; // Color of the car
	private Type type;

	/**
	 * @param nrDoors
	 * @param enginePower enter in horsepower
	 * @param color
	 */
	public Car(int nrDoors, double enginePower, Color color, Type type) {
		this.nrDoors = nrDoors;
		this.enginePower = enginePower;
		this.color = color;
		this.type = type;
		stopEngine();
	}



	/**
	 * @return color of car
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return type of car
	 */
	public Type getType() {
		return type;
	}



	public void setColor(Color clr) {
		color = clr;
	}



	/**
	 * Abstract method that has to be overriden by new classes that extends car.
	 * Each car should have its unique method to return speedfactor.
	 * @return current speedfactor.
	 */
	public abstract double speedFactor();


    /**
     * Used to increment current speed
     * @param amount
     */
    @Override
    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed > enginePower) { // currentSpeed can never exceed enginePower. Quick fix. Can probably be done
            // in a better way
            currentSpeed = enginePower;
        }
    }
	/**
	 * Used to decrement current speed
	 * 
	 * @param amount
	 */
	@Override
	public void decrementSpeed(double amount) {
		currentSpeed = getCurrentSpeed() - speedFactor() * amount;
		if (currentSpeed < 0) { // currentSpeed can never be less then 0
			currentSpeed = 0;
		}
	}

	public int getNrDoors() {
		return nrDoors;
	}


	/**
	 * Shall be interpreted as the gas pedal of the car
	 * Check if the engine is on before allowing gas.
	 *  Do nothing if amount > 1 or amount < 0
	 * @param amount represents how deep down the pedal is pressed down
	 */
	public void gas(double amount) {
		if (currentSpeed > 0){
			if (amount <=1 && amount > 0) { //no negative values are accepted.
				incrementSpeed(amount);
			}
		}
	}
	/**
	 * Shall be interpreted as the brake pedal of the car
	 * Do nothing if amount > 1 or amount < 0
	 * @param amount represents how deep down the pedal is pressed down
	 */
	public void brake(double amount) {
		if (amount <=1 && amount > 0) { //no negative values are accepted.
			decrementSpeed(amount);
		}
	}


}
