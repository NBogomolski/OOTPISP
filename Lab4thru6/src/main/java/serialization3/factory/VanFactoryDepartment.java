package serialization3.factory;

import serialization3.vehicles.Vehicle;
import serialization3.vehicles.Van;

public class VanFactoryDepartment extends CarFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new Van();
    }
}
