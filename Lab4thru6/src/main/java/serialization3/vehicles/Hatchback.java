package serialization3.vehicles;

import java.util.List;

public class Hatchback extends Car {

    private int doorCount;

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public Hatchback() {
        setBodyStyle("Hatchback");
    }

    @Override
    public String toString() {
        return "Hatchback{" +
                super.toString() +
                ", doorCount=" + doorCount +
                "}\n";
    }

    @Override
    public List<String> getAllFields() {
        List<String> res =  super.getAllFields();
        res.add("doorCount");
        return res;
    }

    @Override
    public void setAllFields(List<String> fieldsValues) {
        super.setAllFields(fieldsValues);
        Integer size = super.getAllFields().size();

        doorCount = !fieldsValues.get(size).equals("") ? Integer.parseInt(fieldsValues.get(size)) : doorCount;
        if (doorCount != 3 && doorCount != 5) throw new NumberFormatException("There can only be 3 and 5 doors");

    }
}
