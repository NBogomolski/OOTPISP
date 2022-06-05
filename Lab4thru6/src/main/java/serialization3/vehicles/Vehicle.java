package serialization3.vehicles;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

    private String type;
    private String serialNumber;
    private Space operatingSpace;


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Space getOperatingSpace() {
        return operatingSpace;
    }

    public void setOperatingSpace(Space operatingSpace) {
        this.operatingSpace = operatingSpace;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "type='" + type + '\'' +
                ", operatingSpace=" + operatingSpace +
                ", serialNumber=" + serialNumber + ", ";
    }

    public void change(){
        System.out.println("CHANGING!!!");
    }

    @JsonIgnore
    public List<String> getAllFields(){
        List<String> res = new ArrayList<>();
//        res.add("operatingSpace");
        res.add("serialNumber");
        return res;
    }

    public void setAllFields(List<String> fieldsValues){
        try{
            serialNumber = !fieldsValues.get(0).strip().equals("") ? fieldsValues.get(0).strip() : serialNumber;
            if (this.getType().equals("Vessel")) operatingSpace = Space.WATER;
            if (this.getType().equals("Car")) operatingSpace = Space.LAND;
            if (this.getType().equals("Aircraft")) operatingSpace = Space.AIR;
        }
        catch (Exception e){
            System.out.println("Error value");

        }
    }
}

