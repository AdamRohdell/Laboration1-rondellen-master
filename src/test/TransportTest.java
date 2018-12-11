package test;

import main.model.vehicles.transport.CarFerry;
import org.junit.Test;
import main.model.vehicles.cars.*;

import static org.junit.Assert.*;

public class TransportTest {

    @Test
    public void loadCar() {
        CarFerry ferry = new CarFerry();
        for(int i = 0; i<55; i++){
            ferry.transport.loadCar(new Saab95());
            System.out.println(i);
        }
        assertEquals(50, ferry.transport.getCars().size(), 0);
    }

    @Test
    public void moveCars() {
    }

    @Test
    public void unloadCar() {
    }
}