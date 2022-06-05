package serialization3.factory;

import serialization3.vehicles.Hatchback;
import serialization3.vehicles.Vehicle;

public class PhoneFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new Hatchback();
    }
}
