package main.model.vehicles.transport;

import main.model.vehicles.flatbeds.Flatbed;
import main.model.vehicles.Perpendicular;
import main.model.vehicles.cars.Car;

import java.awt.*;

public class Scania extends Car {

    private Flatbed flatbed;

    public Scania(){
        super(2, 100, Color.blue, Type.TRUCK);
        this.direction = new Perpendicular(0);
        flatbed = new Flatbed(0,70);
    }

    @Override
    public double speedFactor() {
        return 1;
    }

    public Flatbed getFlatbed(){
        return this.flatbed;
    }

    @Override
    public void startEngine(){
        tipFlatbed(0);
        super.startEngine();
    }

    public void tipFlatbed(int angle){
        if (getCurrentSpeed() == 0){
            flatbed.setCurrentAngle(angle);
        }
    }
}
