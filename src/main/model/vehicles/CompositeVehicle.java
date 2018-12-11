package main.model.vehicles;

import main.model.vehicles.cars.Car;
import main.model.vehicles.cars.Saab95;
import main.model.vehicles.transport.Scania;

import java.util.*;

public class CompositeVehicle {

    public int windowWidth = 0;
    public int carWidth = 0;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    private CarFactory factory = new CarFactory();


    public CompositeVehicle(){

    }

    public void createVehicle(String string){
        if(string == "Volvo240"){
            addVehicle(factory.createVolvo240());
        }else if(string == "Saab95"){
            addVehicle(factory.createSaab95());
        }else if(string == "Scania"){
            addVehicle(factory.createScania());
        }
    }


    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    public void removeVehicle(Vehicle v){
        for (Vehicle veh: vehicles){
            if (veh.equals(v)){
                vehicles.remove(veh);
            }
        }
    }

    public void moveVehicles(){
        for (Vehicle v : vehicles){
            v.move();
            if (calculateIfOutOfBounds(v)) {
                changeDirection(v);
            }
        }
    }

    public void setTurbosOn(){
        Saab95 saab;
        for (Vehicle v : vehicles){
            if (v.getClass() == new Saab95().getClass()){
                saab = (Saab95)v;
                saab.turboOn = true;
            }
        }
    }
    public void setTurbosOff(){
        Saab95 saab;
        for (Vehicle v : vehicles){
            if (v.getClass() == new Saab95().getClass()){
                saab = (Saab95)v;
                saab.turboOn = false;
            }
        }
    }
    public void liftBeds(){
        Scania scania;
        for (Vehicle v : vehicles){
            if (v.getClass() == new Scania().getClass()){
                scania = (Scania)v;
                scania.tipFlatbed(70);
            }
        }
    }
    public void lowerBeds(){
        Scania scania;
        for (Vehicle v : vehicles){
            if (v.getClass() == new Scania().getClass()){
                scania = (Scania)v;
                scania.tipFlatbed(0);
            }
        }
    }

    public void startVehicles(){
        for (Vehicle v : vehicles){
            v.startEngine();
        }
    }

    public void stopVehicles(){
        for (Vehicle v : vehicles){
            v.stopEngine();
        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle v : vehicles) {
            v.gas(gas);
        }
    }

    public void brake(int amount){
        double brake = (double) amount / 100;
        for (Vehicle v : vehicles){
            v.brake(brake);
        }
    }


    private void changeDirection(Vehicle v){
        v.getDirection().addAngle(2);
    }


    private boolean calculateIfOutOfBounds(Vehicle v){
        if (v.getPosition().x + carWidth>= windowWidth || v.getPosition().x < 0){
            return true;
        }
        return false;
    }

    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }
}
