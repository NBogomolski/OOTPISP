package Vehicles;

public class Aircraft implements Vehicle, EngineDrivenVehicle {

    @Override
    public void move() {
        System.out.println("An airplane is flying");
    }
}
