package main.model.vehicles;

import java.awt.Point;

public abstract class Direction {
    public Direction(int angle){
        this.angle = angle;
    }

    protected int angle;

    public abstract int getAngle();

    /**
     * Method to set angle
     * @param angle number between 0..3
     */
    public void setAngle(int angle){
        this.angle = angle;
    }

    /**
     * As of now, we only have 4 angles. UP, RIGHT, DOWN, LEFT -- See perpendicular
     * @param angle number between 0..3
     */
    public void addAngle(int angle){
        this.angle += angle;
    }
    
    public abstract Point move(Point point, double currentSpeed);
    public abstract void turnLeft();
    public abstract void turnRight();
}
