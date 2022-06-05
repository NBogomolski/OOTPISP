package serialization3.vehicles;

import java.util.List;

public class Vessel extends Vehicle {

    private int maxWeight;

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Vessel() {
        setType("Vessel");
        setOperatingSpace(Space.WATER);
    }

    @Override
    public String toString() {
        return "Vessel{" +
                super.toString() +
                "maxWeight=" + maxWeight
                + "}\n";
    }

    @Override
    public List<String> getAllFields() {
        List<String> res = super.getAllFields();
        res.add("maxWeight");
        return res;
    }

    @Override
    public void setAllFields(List<String> fieldsValues) {
        super.setAllFields(fieldsValues);
        Integer size = super.getAllFields().size();
        maxWeight = !fieldsValues.get(size).strip().equals("") ? Integer.parseInt(fieldsValues.get(size).strip()): maxWeight;
        if (maxWeight < 4) throw new NumberFormatException("Such max weight is impossible");
    }
}
