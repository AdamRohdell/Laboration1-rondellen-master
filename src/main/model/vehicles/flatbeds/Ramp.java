package main.model.vehicles.flatbeds;

public class Ramp extends Flatbed {

    public Ramp(int minAngle, int maxAngle) {
        super(minAngle, maxAngle);
    }

    public void raiseRamp(){
        setCurrentAngle(maxAngle);
    }

    public void lowerRamp(){
        setCurrentAngle(minAngle);
    }
}
