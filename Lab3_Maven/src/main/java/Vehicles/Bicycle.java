package Vehicles;

public class Bicycle extends Bike implements NonEngineDrivenVehicle{
    @Override
    public void move() {
        System.out.println("A bicycle is moving");
    }
}
