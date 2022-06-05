package serialization3;

import org.apache.commons.codec.DecoderException;
import serialization3.plugin.Plugin;
import serialization3.vehicles.*;
import serialization3.factory.AbstractFactory;
import serialization3.factory.VehicleFactory;

import java.io.IOException;
import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void getHelp(){
        System.out.println("Enter number:");
        System.out.println("1. Load from file");
        System.out.println("2. Save to file");
        System.out.println("3. Print List");
        System.out.println("4. Delete element from List");
        System.out.println("5. Add element to List");
        System.out.println("6. Edit element");
        System.out.println("7. Select the enciphering plugin"); //change to plugin action
        System.out.println("8. Exit");
    }

    public static void deleteElement(List<Vehicle> vehicles){
        for (int i = 0; i< vehicles.size(); i++){
            System.out.print(i+1 + ". ");
            System.out.print(vehicles.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose element number:");
        Integer num = Integer.parseInt(scanner.next());

        if (num > vehicles.size() || num < 1){
            System.out.println("Error number");
            return;
        }
        vehicles.remove(num-1);
        System.out.println("Successful deletion");
    }

    public static void addElement(List<Vehicle> vehicles){

        JsonSerializer jsonSerializer = JsonSerializer.getInstance();
        List<String> types = new ArrayList<>(jsonSerializer.typesToTypeMap.keySet());

        for (int i = 0; i<types.size();i++){
            System.out.println(i+1 + ". " + types.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        String chosenType;
        try{
            Integer num =  Integer.parseInt(scanner.next());
            chosenType = types.get(num-1);
        }
        catch (Exception e){
            System.out.println("Error number");
            return;
        }
        VehicleFactory vehicleFactory = new VehicleFactory();
        AbstractFactory factory = vehicleFactory.factoryMap.get(chosenType);
        Vehicle vehicle = factory.createObj();
        vehicles.add(vehicle);
    }

    public static void editElement(List<Vehicle> vehicles){
        for (int i = 0; i< vehicles.size(); i++){
            System.out.println(i+1 + ". " + vehicles.get(i));
        }

        System.out.print("Choose the vehicle: ");
        Scanner scanner = new Scanner(System.in);

        Vehicle vehicle;
        try {
            Integer num = Integer.parseInt(scanner.nextLine().strip());
            vehicle = vehicles.get(num-1);
        }
        catch (Error error){
            System.out.println("Error num");
            return;
        }

        List<String> values = new ArrayList<>();

        System.out.println(vehicle.getAllFields());
        for (String field : vehicle.getAllFields()){
            if (field.equals("operatingSpace"))
                continue;
            System.out.print(field + ": ");
            String temp = scanner.nextLine();
            values.add(temp);
        }
        vehicle.setAllFields(values);
    }

    public static void main(String[] args) throws IOException, DecoderException {

        FileProcessorFacade fileProcessor = new FileProcessorFacade();
        List<Vehicle> vehicles = new ArrayList<>();
        Plugin plugin = null;
        List<Plugin> plugins = loadPlugins();

//        JsonSerializer jsonSerializer = new JsonSerializer();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to our car dealership");
        getHelp();
        while (true){
            System.out.print("Enter number: ");
            Integer number = Integer.parseInt(scanner.next());

            if (number == 1)
                vehicles = fileProcessor.loadFromFile(plugins);
            else if (number == 2)
                fileProcessor.saveToFile(vehicles, plugin);
//                jsonSerializer.saveToJsonFile(vehicles);
            else if (number == 3)
                System.out.println(vehicles);
            else if (number == 4) {
                if (vehicles.isEmpty()) {
                    System.out.println("The list is empty");
                    continue;
                }
                deleteElement(vehicles);
            }
            else if (number ==5)
                addElement(vehicles);
            else if (number == 6)
                editElement(vehicles);
            else if (number == 7)
//                getHelp();
                plugin = choosePlugin(plugins);
            else if (number == 8)
                break;
            getHelp();
        }
    }

    public static Plugin choosePlugin(List<Plugin> plugins){
        System.out.println("Choose plugin");
        for (int i = 0; i< plugins.size();i++){
            System.out.println(i+1 + ") " + plugins.get(i).getSignature());
        }
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().strip()) - 1;
        System.out.println("You chose " + plugins.get(num).getSignature());
        return plugins.get(num);
    }

    public static List<Plugin> loadPlugins(){

        Path pluginsDir = Paths.get("plugin");
        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name)
                .collect(Collectors.toList());

        Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        ModuleLayer layer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());

        return Plugin.getServices(layer);
    }
}
