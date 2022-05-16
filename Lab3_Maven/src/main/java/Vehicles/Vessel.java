package Vehicles;

public abstract class Vessel extends Vehicle {
    private int maxWeight;

    public Vessel(String serialNumber) {
        super(serialNumber, Space.WATER);
    }
}
