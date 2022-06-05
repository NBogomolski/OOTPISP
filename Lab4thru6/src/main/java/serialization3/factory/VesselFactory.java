package serialization3.factory;

import serialization3.vehicles.Vessel;
import serialization3.vehicles.Vehicle;

public class VesselFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new Vessel();
    }
}
