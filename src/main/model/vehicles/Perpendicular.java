package main.model.vehicles;

import java.awt.Point;

public class Perpendicular extends Direction {

	/**
	 * Perpendicular Direction
	 * Easy version of direction.
	 * Can only represent 4 directions. UP, RIGHT, DOWN, LEFT
	 * @param angle
	 */
    public Perpendicular(int angle){
        super(angle);
    }

    /**
     * Returns the current direction
     */
    @Override
    public int getAngle() {
        return angle;
    }

    /**
     * Used when we want to change direction. Add an angle to our current direction.
     * Angle shall never exceed 3. angle 4 => 0, angle 5 => 1 etc....
     */
    public void addAngle(int angle) {
        this.angle += angle;
        if (this.angle > 3){
            this.angle -= 4;
        }
    }
    
    /**
     * Used to move the car. Based on current direction and speed.
     * As this is a perpendiculardirection we can only move in x or y. Meaning:
     * We can only move 90 degrees at a time. Only up, down, left or right
     */
    public Point move(Point point, double currentSpeed){
        switch(getAngle()){
            case 0:
                point.x += currentSpeed;
                break;
            case 1:
                point.y += currentSpeed;
                break;
            case 2:
                point.x -= currentSpeed;
                break;
            case 3:
                point.y -= currentSpeed;
                break;
        }
        return point;
    }

    /**
     * Used to turn left
     */
    @Override
    public void turnLeft(){
        addAngle(3);
    }

    /**
     * Used to turn right
     */
    @Override
    public void turnRight(){
        addAngle(1);
    }
}
