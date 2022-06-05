package serialization3.factory;

import serialization3.vehicles.Hatchback;
import serialization3.vehicles.Vehicle;

public class HatchbackFactoryDepartment extends CarFactory implements AbstractFactory {
    @Override
    public Vehicle createObj() {
        return new Hatchback();
    }
}
