package Vehicles;

public class Ship extends Vessel {
    private int cruisingSpeed;
    public Ship(String serialNumber) {
        super(serialNumber);
    }

    public Ship() {
        super("Ship");
    }
}
