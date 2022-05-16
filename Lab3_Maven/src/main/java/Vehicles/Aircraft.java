package Vehicles;

public class Aircraft extends Vehicle{
    private String airline;
    private int maxWeight;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Aircraft(String serialNumber) {
        super(serialNumber, Space.AIR);
    }

    public Aircraft() {
        super("Aircraft", Space.AIR);
    }
}
