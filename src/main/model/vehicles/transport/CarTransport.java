package main.model.vehicles.transport;

import main.model.vehicles.flatbeds.Ramp;
import main.model.vehicles.cars.Car;

import java.awt.*;

public class CarTransport extends Car {


    private Ramp ramp = new Ramp(0, 1);
    private Transport transport;


    public CarTransport() {
        super(2, 500, Color.green, Car.Type.TRUCK);
        transport = new Transport(10, false, this.getPosition(), this.ramp);
    }

    /**
     * Method to start the engine
     * Raise ramp before engine is started
     */
    @Override
    public void startEngine(){
        raiseRamp();
        super.startEngine();
    }


    @Override
    public double speedFactor() {
        return 0;
    }

    /**
     * Method to move the cartransport
     * Also update the position of each car that is being transported
     */
    @Override
    public void move(){
        super.move();
        transport.moveCars();
    }



    /**
     * Method to lower the ramp
     * Will not work if current speed is above 0
     */
    public void lowerRamp(){
        if (getCurrentSpeed() == 0){
            ramp.lowerRamp();
        }
    }

    /**
     * Method to raise ramp
     */
    public void raiseRamp(){
        ramp.raiseRamp();
    }
}
