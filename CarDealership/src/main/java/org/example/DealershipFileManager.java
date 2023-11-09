package org.example;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager {
    private DealershipFileManager() {
    }
    // Add a factory method to create an instance of DealershipFileManager
    public static DealershipFileManager create() {
        return new DealershipFileManager();
    }

    public static Dealership getDealership() {

        //Create Dealership object
        Dealership dealership = new Dealership("Isaiah's cars", "3915 San mateo dr", "738-349");

        //Make a file input stream that points to the file that holds my vehicles
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/Inventory.csv");

            //Make a scanner to take in the file input stream
            Scanner scanner = new Scanner(fis);

            //Loop through the file until there is no more file
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();

                //Take each row, and use the String.split() method to get your data
                String[] parts = input.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);


                //Create a vehicle, from the array, that String.split() returns
              Vehicle vehicle = new Vehicle(vin,year, make, model, vehicleType, color, odometer, price );

                //Take that vehicle and add it to the inventory.csv of the Dealership
                dealership.addVehicle(vehicle);

               // throw new UnsupportedOperationException("This method hasn't been implemented yet.");
            }
            fis.close();

        } catch (IOException ex) {
            System.out.println("There was an error");
            ex.printStackTrace();
        }
        //After the loop is finished, return the Dealership
        return dealership;
    }

    //I think if you just use FileWriter like we did in class it would be a bit less confusing
    //I changed some stuff around to help you out a bit, but remember, saveDealership is
    //not about writing stuff to the screen, it's about writing it to the FILE
    public static void saveDealership(Dealership dealership) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("Inventory.csv"));
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                //writer.println(vehicle.); // Convert the vehicle to CSV format
            }
        } catch (IOException e) {
            System.out.println("Error saving the dealership data: " + e.getMessage());
        }

    }
    }

