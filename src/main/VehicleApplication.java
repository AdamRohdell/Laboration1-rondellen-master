package main;

import main.controllers.CarController;
import main.model.vehicles.CarFactory;
import main.model.vehicles.cars.Car;
import main.model.vehicles.cars.Volvo240;
import main.views.CarView;
import main.views.DrawPanel;

public class VehicleApplication {



    //DrawPanel drawPanel = new DrawPanel(X, Y-240, cc.getCars());


    public static void main(String[] args) {
        // Instance of this class
        CarView frame = new CarView("CarSim 1.0");

        CarController cc = new CarController(frame);

        cc.createVehicle("Volvo240");
        cc.createVehicle("Saab95");
        cc.createVehicle("Scania");



        // Start the timer
        cc.startTimer();
    }



}
