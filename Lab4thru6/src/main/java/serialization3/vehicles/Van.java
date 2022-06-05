package serialization3.vehicles;

import java.util.List;

public class Van extends Car {

    private int seatCount;

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Van() {
        setBodyStyle("Van");
    }

    @Override
    public String toString() {
        return "Van{" +
                super.toString() + ", " +
                "seatCount=" + seatCount +
                "}\n";
    }

    @Override
    public List<String> getAllFields() {
        List<String> res =  super.getAllFields();
        res.add("seatCount");
        return res;
    }

    @Override
    public void setAllFields(List<String> fieldsValues) {
        super.setAllFields(fieldsValues);
        Integer size = super.getAllFields().size();

        seatCount = !fieldsValues.get(size).equals("") ? Integer.parseInt(fieldsValues.get(size)) : seatCount;
        if (seatCount != 4 && seatCount != 5 && seatCount != 7 && seatCount != 8) throw new NumberFormatException("There can only be 4, 5, 7 and 8");

    }
}
