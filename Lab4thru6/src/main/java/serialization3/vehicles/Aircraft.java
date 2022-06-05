package serialization3.vehicles;

import java.util.List;

public class Aircraft extends Vehicle {

    private String airline;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Aircraft() {
        setType("Aircraft");
        setOperatingSpace(Space.AIR);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                super.toString() +
                "airline='" + airline + '\'' +
                "}\n";
    }

    @Override
    public List<String> getAllFields() {
        List<String> res = super.getAllFields();
        res.add("airline");
        return res;
    }

    @Override
    public void setAllFields(List<String> fieldsValues) {
        super.setAllFields(fieldsValues);
        Integer size = super.getAllFields().size();

        airline = !fieldsValues.get(size).strip().equals("") ? fieldsValues.get(size) : airline;
    }
}
