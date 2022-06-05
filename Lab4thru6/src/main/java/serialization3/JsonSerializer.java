package serialization3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import serialization3.vehicles.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JsonSerializer {

    private static volatile JsonSerializer singleton;
    public Map<String, Class> typesToTypeMap;
    public Map<String, Class> bodyTypesToMap;
    private ObjectMapper objectMapper = new ObjectMapper();

    public String serialize(Vehicle obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public Object deserialize(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, Object.class);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void saveToJsonFile(List<Vehicle> vehicles) throws IOException {
        String json = objectMapper.writeValueAsString(vehicles);
        FileOutputStream file = new FileOutputStream("vehicles.json");
        file.write(json.getBytes(StandardCharsets.UTF_8));
        file.close();
    }

    public List<Vehicle> loadFromJsonFile() throws IOException{

        FileInputStream file = new FileInputStream("vehicles.json");
        byte[] jsonBytes = file.readAllBytes();

        ArrayNode jsonNodes = (ArrayNode) objectMapper.readTree(jsonBytes);
        Iterator<JsonNode> iterator = jsonNodes.iterator();

        List<Vehicle> vehicles = new ArrayList<>();

        while (iterator.hasNext()){
            JsonNode jsonNode = iterator.next();
            String type = jsonNode.get("type").asText();
            Vehicle vehicle;
            if (type.equals("Car")) {
                String bodyType = jsonNode.get("bodyStyle").asText();
                vehicle = (Car) objectMapper.convertValue(jsonNode, bodyTypesToMap.get(bodyType));
            } else
                vehicle = (Vehicle) objectMapper.convertValue(jsonNode, typesToTypeMap.get(type));
            vehicles.add(vehicle);
        }
        return vehicles;
    }

    public List<Vehicle> loadVehiclesFromJson(byte[] bytes) throws IOException {

        ArrayNode jsonNodes = (ArrayNode) objectMapper.readTree(bytes);
        Iterator<JsonNode> iterator = jsonNodes.iterator();

        List<Vehicle> vehicles = new ArrayList<>();

        while (iterator.hasNext()){
            JsonNode jsonNode = iterator.next();
            String type = jsonNode.get("type").asText();
            Vehicle vehicle;
            if (type.equals("Car")) {
                String bodyStyle = jsonNode.get("bodyStyle").asText();
                vehicle = (Car) objectMapper.convertValue(jsonNode, bodyTypesToMap.get(bodyStyle));
            } else
                vehicle = (Vehicle) objectMapper.convertValue(jsonNode, typesToTypeMap.get(type));
            vehicles.add(vehicle);
        }
        return vehicles;
    }


    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private void fillJsonSerializer() {
        typesToTypeMap = new HashMap<>();
        typesToTypeMap.put("Car", Car.class);
        typesToTypeMap.put("Vessel", Vessel.class);
        typesToTypeMap.put("Van", Van.class);
        typesToTypeMap.put("Sedan", Sedan.class);
        typesToTypeMap.put("Hatchback", Hatchback.class);
        typesToTypeMap.put("Aircraft", Aircraft.class);

        bodyTypesToMap = new HashMap<>();
        bodyTypesToMap.put("Van", Van.class);
        bodyTypesToMap.put("Sedan", Sedan.class);
        bodyTypesToMap.put("Hatchback", Hatchback.class);
    }

    private JsonSerializer() {
        fillJsonSerializer();
    }

    public static JsonSerializer getInstance(){
        if (singleton == null){
            synchronized (JsonSerializer.class){
                if (singleton == null){
                    singleton = new JsonSerializer();
                }
            }
        }
        return singleton;
    }

    public String toJsonString(List<Vehicle> vehicles) throws IOException {
        return objectMapper.writeValueAsString(vehicles);
    }

}
