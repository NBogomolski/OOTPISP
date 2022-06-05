package serialization3.factory;

import serialization3.vehicles.Vehicle;
import serialization3.vehicles.Sedan;

public class SedanFactoryDepartment extends CarFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new Sedan();
    }
}
