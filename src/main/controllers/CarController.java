package main.controllers;

import main.model.vehicles.CarFactory;
import main.model.vehicles.CompositeVehicle;
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

    // The frame that represents this instance View of the MVC pattern
    public CarView frame;
    // A list of cars, modify if needed
    //ArrayList<Car> cars = new ArrayList<>();
    CarFactory carFactory = new CarFactory();
    CompositeVehicle composite;

    public CarController(CarView frame, CompositeVehicle composite){
        this.frame = frame;
        this.composite = composite;
        initButtons();
        this.composite.windowWidth = frame.getWidth();
        this.composite.carWidth = frame.getDrawPanel().getImage(new Saab95()).getWidth();
    }

    public void startTimer() {
        timer.start();
    }

    //methods:


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            composite.moveVehicles();
            // repaint() calls the paintComponent method of the panel
            frame.getDrawPanel().render(composite.getVehicles());
        }
    }

    public CompositeVehicle getComposite(){
        return composite;
    }


    public void initButtons(){
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                composite.gas(frame.getGasAmount());
            }
        });
        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                composite.brake(frame.getGasAmount());
            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                composite.startVehicles();
            }
        });
        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                composite.stopVehicles();
            }
        });
        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                composite.setTurbosOn();
            }
        });
        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                composite.setTurbosOn();
            }
        });
        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                composite.liftBeds();
            }
        });
        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                composite.lowerBeds();
            }
        });
    }
}
