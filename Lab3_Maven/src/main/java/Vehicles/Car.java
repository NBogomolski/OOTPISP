package Vehicles;


public abstract class Car extends Vehicle{
    private String make;
    private String model;
    private int year;
    private String bodyStyle;

    public Car(String serialNumber) {
        super(serialNumber, Space.LAND);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public Car() {
        super("car", Space.LAND);
    }
}
