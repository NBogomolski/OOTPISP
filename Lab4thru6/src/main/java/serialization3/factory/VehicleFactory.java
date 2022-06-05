package serialization3.factory;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {

    public Map<String, AbstractFactory> factoryMap;

    public VehicleFactory() {
        factoryMap = new HashMap<>();
        factoryMap.put("Hatchback", new HatchbackFactoryDepartment());
        factoryMap.put("Vessel", new VesselFactory());
        factoryMap.put("Van", new VanFactoryDepartment());
        factoryMap.put("Sedan", new SedanFactoryDepartment());
        factoryMap.put("Aircraft", new AircraftFactory());
    }
}
