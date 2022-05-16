package Vehicles;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Boat.class, name = "boat"),
        @JsonSubTypes.Type(value = Ship.class, name = "ship"),
        @JsonSubTypes.Type(value = Sedan.class, name = "sedan"),
        @JsonSubTypes.Type(value = Hatchback.class, name = "hatchback"),
        @JsonSubTypes.Type(value = Van.class, name = "van"),
        @JsonSubTypes.Type(value = Convertible.class, name = "convertible"),
        @JsonSubTypes.Type(value = Aircraft.class, name = "aircraft"),
})
public abstract class Vehicle {
    private String serialNumber;
    private Space space;

    public void setSpace(Space space) {
        this.space = space;
    }

    public Space getSpace() {
        return space;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Vehicle(String serialNumber, Space space) {
        this.space = space;
        this.serialNumber = serialNumber;
    }
}
