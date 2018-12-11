package main.model.vehicles.transport;

import main.model.vehicles.Perpendicular;
import main.model.vehicles.Vehicle;
import main.model.vehicles.flatbeds.Ramp;

public class CarFerry extends Vehicle {

    public Ramp ramp = new Ramp(0, 1);
    public Transport transport;

    public CarFerry(){
        this.direction = new Perpendicular(0);
        transport = new Transport(50, true ,this.getPosition(), this.ramp);
    }

    /**
     * Method to raise ramp
     */
    public void raiseRamp(){
        ramp.raiseRamp();
    }
    /**
     * Method to lower the ramp
     */
    public void lowerRamp() {
        if (currentSpeed == 0){
            ramp.lowerRamp();
        }
    }


    @Override
    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + 1 * amount;
        if (currentSpeed > enginePower) { // currentSpeed can never exceed enginePower. Quick fix. Can probably be done
            // in a better way
            currentSpeed = enginePower;
        }
    }

    @Override
    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() -  1 * amount;
        if (currentSpeed < 0) { // currentSpeed can never be less then 0
            currentSpeed = 0;
        }
    }

    @Override
    public void gas(double amount) {
        if (currentSpeed > 0){
            if (amount <=1 && amount > 0) { //no negative values are accepted.
                incrementSpeed(amount);
            }
        }
    }

    @Override
    public void brake(double amount) {
        if (amount <=1 && amount > 0) { //no negative values are accepted.
            decrementSpeed(amount);
        }
    }
}
