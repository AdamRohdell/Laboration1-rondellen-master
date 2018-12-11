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
    private ArrayList<Car> listOfCars = new ArrayList<>();

    public void createVolvo240(){
        Volvo240 volvo = new Volvo240();
        volvo.setPosition(point);
        listOfCars.add(volvo);
        point = new Point(0, point.y+ 100);    }

    public void createSaab95(){
        Saab95 saab = new Saab95();
        saab.setPosition(point);
        listOfCars.add(saab);
        point = new Point(0, point.y+ 100);
    }

    public void createScania(){
        Scania scania = new Scania();
        scania.setPosition(point);
        listOfCars.add(scania);
        point = new Point(0, point.y + 100);
    }

    public ArrayList<Car> getListOfCars() {
        return listOfCars;
    }
}

