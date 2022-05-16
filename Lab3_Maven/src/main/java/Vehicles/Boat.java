package Vehicles;

public class Boat extends Vessel {
    private int paddleCount;
    private int seats;

    public Boat(String serialNumber) {
        super(serialNumber);
    }
    public Boat(){ super("Boat");};
}
