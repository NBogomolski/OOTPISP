package serialization3.vehicles;

import java.util.List;

public class Sedan extends Car {
    public Sedan() {
        this.setBodyStyle("Sedan");
    }

    @Override
    public String toString() {
        return "Sedan{" +
                super.toString() +
                "}\n";
    }

    @Override
    public List<String> getAllFields() {
        List<String> res = super.getAllFields();
        return res;
    }

}