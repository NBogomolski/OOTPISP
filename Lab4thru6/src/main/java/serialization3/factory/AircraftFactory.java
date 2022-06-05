package serialization3.factory;

import serialization3.vehicles.Vehicle;
import serialization3.vehicles.Aircraft;

public class AircraftFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new Aircraft();
    }
}
