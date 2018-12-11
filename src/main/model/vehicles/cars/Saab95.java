package main.model.vehicles.cars;
import main.model.vehicles.Perpendicular;

import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;
    
    public Saab95(){
        super(2, 125, Color.red, Type.SEDAN);
	    turboOn = false;
	    this.direction = new Perpendicular(0);
    }

    /**
     * Used to enable turbo
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Used to disable turbo
     */
    public void setTurboOff(){
	    turboOn = false;
    }
    
    /**
     * Used to get current speedfactor
     * Depends on whether turbo is activated or not and engine power.
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

	public boolean getTurboStatus() {
		return turboOn;
	}
}