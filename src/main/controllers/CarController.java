package main.controllers;

import main.model.vehicles.CarFactory;
import main.model.vehicles.cars.*;
import main.model.vehicles.transport.Scania;
import main.views.CarView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    Point newCarLocation = new Point();
    // The frame that represents this instance View of the MVC pattern
    public CarView frame;
    // A list of cars, modify if needed
    //ArrayList<Car> cars = new ArrayList<>();
    CarFactory carFactory = new CarFactory();

    public CarController(CarView frame){
        this.frame = frame;
        initButtons();
    }

    public void startTimer() {
        timer.start();
    }

    //methods:

   /* public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(CarFactory.createVolvo240());

        Car saab = CarFactory.createSaab95();
        saab.point.setLocation(0,100);
        cc.cars.add(saab);

        Car scania = CarFactory.createScania();
        scania.point.setLocation(0,200);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }*/

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : carFactory.getListOfCars()) {
                car.move();
                if (calculateIfOutOfBounds(car)) {
                    changeDirection(car);
                }
                // repaint() calls the paintComponent method of the panel
                frame.getDrawPanel().render(getCars());
            }
        }
    }

    public ArrayList<Car> getCars(){
        return carFactory.getListOfCars();
    }

    public void createVehicle(String string){
        if(string == "Volvo240")
            carFactory.createVolvo240(newCarLocation);
        else if(string == "Saab95")
            carFactory.createSaab95(newCarLocation);
        else if(string == "Scania")
            carFactory.createScania(newCarLocation);
        else
            System.out.println("Please enter a valid model name.");
        newCarLocation.y = newCarLocation.y + 100;
    }

    private void changeDirection(Car c){
        c.getDirection().addAngle(2);
    }


    private boolean calculateIfOutOfBounds(Car car){
        int carWidth = frame.getDrawPanel().getImage(car).getWidth();
        if (car.getPosition().x + carWidth>= frame.getWidth() || car.getPosition().x < 0){
            return true;
        }
        return false;
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : carFactory.getListOfCars()
                ) {
            car.gas(gas);
        }
    }

    public void brake(int amount){
        double brake = (double) amount / 100;
        for (Car car : carFactory.getListOfCars()){
            car.brake(brake);
        }
    }

    public void startCars(){
        for (Car car : carFactory.getListOfCars()){
            car.startEngine();
        }
    }

    public void stopCars(){
        for (Car car : carFactory.getListOfCars()){
            car.stopEngine();
        }
    }

    
    public void setTurboOn(){
        Saab95 saab;
        for (Car car : carFactory.getListOfCars()){
            if (car.getClass() == new Saab95().getClass()){
                saab = (Saab95)car;
                saab.turboOn = true;
            }
        }
    }
    public void setTurboOff(){
        Saab95 saab;
        for (Car car : carFactory.getListOfCars()){
            if (car.getClass() == new Saab95().getClass()){
                saab = (Saab95)car;
                saab.turboOn = false;
            }
        }
    }
    public void liftBeds(){
        Scania scania;
        for (Car car : carFactory.getListOfCars()){
            if (car.getClass() == new Scania().getClass()){
                scania = (Scania)car;
                scania.tipFlatbed(70);
            }
        }
    }

    public void lowerBeds(){
        Scania scania;
        for (Car car : carFactory.getListOfCars()){
            if (car.getClass() == new Scania().getClass()){
                scania = (Scania)car;
                scania.tipFlatbed(0);
            }
        }
    }

    public void initButtons(){
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(frame.getGasAmount());
            }
        });
        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(frame.getGasAmount());
            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCars();
            }
        });
        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCars();
            }
        });
        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOn();
            }
        });
        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOff();
            }
        });
        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBeds();
            }
        });
        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBeds();
            }
        });
    }
}
