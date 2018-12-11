package main.model.vehicles;

import main.model.vehicles.cars.Car;
import main.model.vehicles.cars.Saab95;
import main.model.vehicles.cars.Volvo240;
import main.model.vehicles.transport.Scania;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private Point point = new Point(0,0);
    private ArrayList<Car> listOfAvailableCars = new ArrayList<>();

    public Vehicle createVolvo240(){
        Volvo240 volvo = new Volvo240();
        volvo.setPosition(point);
        point = new Point(0, point.y+ 100);
        return volvo;
    }

    public Vehicle createSaab95(){
        Saab95 saab = new Saab95();
        saab.setPosition(point);
        point = new Point(0, point.y+ 100);
        return saab;
    }

    public Vehicle createScania(){
        Scania scania = new Scania();
        scania.setPosition(point);
        point = new Point(0, point.y + 100);
        return scania;
    }

    public ArrayList<Car> getListOfCars() {
        return listOfAvailableCars;
    }
}

