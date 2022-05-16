import Vehicles.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String[] available = new String[] {"Aircraft", "Boat", "Convertible", "Hatchback", "Sedan", "Ship", "Van"};
    private static Fleet fleet;
    public static void main(String[] args) throws IOException {
        System.out.println("coming through");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Boat("19515BOATFF"));
        vehicles.add(new Ship("123"));
        Sedan sedan = new Sedan();
        sedan.setSerialNumber("1551E");
        sedan.setMake("Chrysler");
        sedan.setModel("Voyager");
        sedan.setYear(2003);
        vehicles.add(sedan);
        Aircraft aircraft = new Aircraft("12345678Belavia");
        aircraft.setAirline("Belavia");
        vehicles.add(aircraft);


        startupAction();


        fleet.setVehicles(vehicles);
        FleetMapper fleetMapper = new FleetMapper();
        fleetMapper.write(fleet, "D:\\OOTPISP\\Lab3_Maven\\testDoc.txt");


    }

    protected static void startupAction() throws IOException {
        System.out.println("What would you like to do?");
        System.out.println("0 - form a list of vehicles");
        System.out.println("1 - upload from a file");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 0 -> {
                String enteredVehicle;
                while (true) {
                    System.out.println("Enter the name of the Vehicle. Available are:"+Arrays.asList(available).toString()+"\n For exit, type anything else");
                    enteredVehicle = scanner.nextLine();
                    if (!Arrays.asList(available).contains(enteredVehicle)) {
                        break;
                    } else {
                        addVehicle(getIndOf(enteredVehicle, available));
                    }
                }
            }
            case 1 -> {
                System.out.println("Specify the file path: ");
                FleetMapper fleetMapper = new FleetMapper();
                fleet = fleetMapper.read(scanner.nextLine());

            }
        }
    }

    private static int getIndOf(String name, String[] arr) {
        int ind = 0;
        for (String str: arr) {
            if (str.equals(name))
                return ind;
            ind++;
        }
        return -1;
    }

    protected static void addVehicle(int index) {
//        "Aircraft", "Boat", "Convertible", "Hatchback", "Sedan", "Ship", "Van"
        Scanner scanner = new Scanner(System.in);
        switch (index) {
            case 0 -> {
                System.out.println("enter the airline:");
            }
        }

    }
}



