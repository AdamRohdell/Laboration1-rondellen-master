package main.model.vehicles;

import java.util.*;

public class CompositeVehicle {

    List<Vehicle> vehicles = new ArrayList<>();

    public CompositeVehicle(){

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
}
