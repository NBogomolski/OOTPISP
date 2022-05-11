package Vehicles;

public class Boat extends Vessel implements NonEngineDrivenVehicle{
    @Override
    public void move() {
        System.out.println("A boat is moving...");
    }
}
