package serialization3.vehicles;

import java.util.List;

import static java.lang.Integer.parseInt;

public abstract class Car extends Vehicle {

    private boolean isWorking;
    private String make;
    private String model;
    private int year;
    private String bodyStyle;

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

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public Car() {
        setType("Car");
        setOperatingSpace(Space.LAND);
    }

    @Override
    public String toString() {
        return //"Car{" +
                super.toString() +
                "isWorking=" + isWorking +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", bodyStyle='" + bodyStyle + '\'';
//                + '}';
    }

    @Override
    public List<String> getAllFields() {
        List<String> res = super.getAllFields();
        res.add("isWorking");
        res.add("make");
        res.add("model");
        res.add("year");
//        res.add("bodyStyle");
        return res;
    }

    @Override
    public void setAllFields(List<String> fieldsValues) {
        super.setAllFields(fieldsValues);
        Integer size = super.getAllFields().size();

        isWorking = !fieldsValues.get(size).strip().equals("") ? Boolean.parseBoolean(fieldsValues.get(size).strip()) : isWorking;
        make = !fieldsValues.get(size + 1).strip().equals("") ? (fieldsValues.get(size + 1).strip()) : make;
        model = !fieldsValues.get(size + 2).strip().equals("") ? (fieldsValues.get(size + 2).strip()) : model;
        year = !fieldsValues.get(size + 3).strip().equals("") ? Integer.parseInt(fieldsValues.get(size + 3).strip()) : year;
//        bodyStyle = !fieldsValues.get(size + 4).strip().equals("") ? (fieldsValues.get(size + 4).strip()) : bodyStyle;
    }
}
