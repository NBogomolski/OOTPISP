package Vehicles;

public class Van extends Car{
    private int seatCount;
    private boolean hasExtraLid;

    public Van(String serialNumber) {
        super(serialNumber);
    }

    public Van() {
        super("Van");
    }
}
