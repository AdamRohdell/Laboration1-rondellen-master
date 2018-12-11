package main.model.vehicles.transport;

import java.util.ArrayList;
import java.util.List;
import main.model.vehicles.flatbeds.Ramp;
import main.model.vehicles.cars.Car;

import java.awt.*;


public class Transport {

    private int maxCars;
    private boolean unloadFirstCar = true;
    private Point point;
    private Ramp ramp;
    private List<Car> cars = new ArrayList<Car>();


    public Transport(int maxCars, boolean unloadFirstCar, Point point, Ramp ramp){
        this.maxCars = maxCars;
        this.unloadFirstCar = unloadFirstCar;
        this.point = point;
        this.ramp = ramp;
    }
    /**
     * Method to load the last car that was loaded. The car that will be loaded has to be within a distance of 1 unit.
     * @param c that shall be loaded
     */
    public void loadCar(Car c){
        if (c.getType() != Car.Type.TRUCK && cars.size() < maxCars && (c.getPosition().x - point.x <= 1) && (c.getPosition().y - point.y <= 1) && ramp.getCurrentAngle() == 0) {
            cars.add(c);
        }
    }

    public void moveCars(){
        for (Car c : cars){
            c.setPosition(point);
        }
    }

    /**
     * Method to unload car
     * Will not work if ramp is raised.
     */
    public void unloadCar(){
        int index = cars.size() - 1;
        if(unloadFirstCar){
            index = 0;
        }
        if (ramp.getCurrentAngle() == 0){
            Car c =  cars.get(index);
            c.setPosition(new Point(point.x - 1, point.y));
        }
    }

    public List<Car> getCars(){
        return cars;
    }
}
