package main.model.vehicles.flatbeds;

public class Flatbed {

    protected int currentAngle,minAngle,maxAngle;


    /**
     * @param minAngle the lowest angle this flatbed can have
     * @param maxAngle the highest angle this flatbed can have
     */
    public Flatbed(int minAngle, int maxAngle){
        this.currentAngle = minAngle;
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
    }

    public int getCurrentAngle(){
        return this.currentAngle;
    }

    /**
     * Set angle of flatbed
     * @param angle can only be set between min && max angle
     */
    public void setCurrentAngle(int angle){
        if (angle >= minAngle && angle <= maxAngle){
            this.currentAngle = angle;
        }
    }
}
