package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface(){
        init();
    }
    private void init(){
        //Create an instance of DealershipFileManager
        DealershipFileManager dealershipFileManager = DealershipFileManager.create();

        //Call getdealership method and assign the dealership so that it returns to the UserInterface this.dealership attribute
        this.dealership = dealershipFileManager.getDealership();


    }

    public void display(){

        //Use a scanner to read the user commands
         int userinput;

       //Create a while loop
        while (true){

            //Inside the loop display the menu
            System.out.println("What would you like to do?");
            System.out.println("1) Find vehicles within a price range");
            System.out.println("2) Find vehicles by make / model");
            System.out.println("3) Find vehicles by year range");
            System.out.println("4) Find vehicles by color");
            System.out.println("5) Find vehicles by mileage range");
            System.out.println("6) Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7) List ALL vehicles");
            System.out.println("8) Add a vehicle");
            System.out.println("9) Remove a vehicle");
            System.out.println("10) Quit");

            //Read the users input
            System.out.println("What would you like to do?");

            userinput = scanner.nextInt();
            scanner.nextLine();

            //Make a switch statement that calls the correct method to match the users request
            switch(userinput){
                case 1:
                    //Handle choice 1
                    GetByPriceRequest();
                    break;
                case 2:
                    //Choice 2
                    GetByMakeModelRequest();
                    break;
                case 3:
                    //choice 3
                    GetBYYearRequest();
                    break;
                case 4:
                    //choice 4
                    GetByColorRequest();
                    break;
                case 5:
                    //choice 5
                    GetByMileageRequest();
                    break;
                case 6:
                    //choice 6
                    GetByVehicleTypeRequest();
                    break;
                case 7:
                    //choice 7
                    processAllVehiclesRequest();
                    break;
                case 8:
                    //choice 8
                    AddVehicleRequest();
                    break;
                case 9:
                    //choice 9
                    RemoveVehicleRequest();
                    break;
                case 10:
                    //Exit
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please pick a number 1-10.");
            }

        }

    }
    //Include a parameter that is passed in containing the vehicles to list
    private static void displayVehiclesHelperMethod(List <Vehicle> vehicles){

        //Create an if else loop
        if(vehicles.isEmpty()){
            System.out.println("Sorry could not find this vehicle");
        } else {
            //Display the list and can be called from all the get-vehicles type methods
            System.out.println("List of all vehicles: ");
            for (int i = 0; i < vehicles.size(); i++){

               Vehicle vehicle = vehicles.get(i);
                System.out.println("Vehicle " + (i + 1) + ":");
                System.out.println("Make: " + vehicle.getMake());
                System.out.println("Model: " + vehicle.getModel());
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Color: " + vehicle.getColor());
                System.out.println("Mileage: " + vehicle.getOdometer());
                System.out.println("Type: " + vehicle.getVehicleType());
                System.out.println("Price: "+ vehicle.getPrice() );
                System.out.println();

            }
        }
    }
    public  void GetByPriceRequest(){
        boolean isGettingByPrice = true;

        while(isGettingByPrice){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the minimum price of the vehicle you are looking for: ");
                double minPrice = scanner.nextDouble();
                System.out.println("What is the maximum price of the vehicle you are looking for: ");
                double maxPrice= scanner.nextDouble();

                if(minPrice < maxPrice){
                    System.out.println("These are all the vehicles between %d and %d" + minPrice + maxPrice);
                    List<Vehicle> vehicleList = dealership.getVehiclesByPrice(minPrice, maxPrice);
                    displayVehiclesHelperMethod(vehicleList);
                    isGettingByPrice = false;
                }
                else{
                    System.out.println("The minimum price cannot be greater than the max price");
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Price must be a number");
            }
        }

    }
    public  void GetByMakeModelRequest(){
        //boolean
        boolean isGettingByMakeModel = true;

        //While loop
        while(isGettingByMakeModel){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the make of the car you are looking for: ");
                String make = scanner.nextLine();
                System.out.println("What is the model of the car you are looking for: ");
                String model= scanner.nextLine();

                List<Vehicle> matchingVehicles = dealership.getByMakeModelRequest(make, model);

                if(!matchingVehicles.isEmpty()){
                    System.out.println("These are the current cars with the following make and model:  " + make + model);
                    displayVehiclesHelperMethod(matchingVehicles);

            } else{
                    System.out.println("No vehicles found with the specified make and model.");
                }
                isGettingByMakeModel = false;
            }
            catch (InputMismatchException ex){
                System.out.println("Invalid input. Make and model must be strings.");
            }

        }

    }
    public void GetBYYearRequest(){
        boolean isGettingByYearRequest = true;

        //While loop
        while(isGettingByYearRequest){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the minimum year of the car you are looking for: ");
                int minYear = scanner.nextInt();
                System.out.println("What is the maximum of the car you are looking for: ");
                int maxYear= scanner.nextInt();

                List<Vehicle> matchingVehicles = dealership.getByYearRequest(minYear, maxYear);

                if(!matchingVehicles.isEmpty()){
                    System.out.printf("These are all the vehicles between %d and %d%n", minYear, maxYear);
                    displayVehiclesHelperMethod(matchingVehicles);

                }

                else{
                    System.out.println("No vehicles found between the specified years.");
                }
                //Exit the loop
                isGettingByYearRequest = false;
            }
            catch (InputMismatchException ex){
                System.out.println("Invalid input. Year must be an integer.");
            }

        }

    }

    public void GetByColorRequest(){
        boolean isGettingByColorRequest = true;

        //While loop
        while(isGettingByColorRequest){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the color of the car you are looking for: ");
                String vehicleColor = scanner.nextLine();

                List<Vehicle> matchingVehicles = dealership.getByColorRequest(vehicleColor);

                if(!matchingVehicles.isEmpty()){
                    System.out.printf("These are all the vehicles with that color ", vehicleColor);
                    displayVehiclesHelperMethod(matchingVehicles);

                }

                else{
                    System.out.println("No vehicles found with this color.");
                }
                //Exit the loop
                isGettingByColorRequest = false;
            }
            catch (InputMismatchException ex){
                System.out.println("Invalid input. Enter a color please.");
            }

        }

    }

    public void GetByMileageRequest(){
        boolean isGettingMileageRequest = true;

        //While loop
        while(isGettingMileageRequest){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the minimum mileage of the car you are looking for: ");
                double odometer1 = scanner.nextDouble();
                System.out.println("What is the maximum of the car you are looking for: ");
                double odometer2 = scanner.nextDouble();

                List<Vehicle> matchingVehicles = dealership.getMileageRequest(odometer1, odometer2);

                if(!matchingVehicles.isEmpty()){
                    System.out.printf("These are all the vehicles with mileage between  %.2f and %.2f%n", odometer1, odometer2);
                    displayVehiclesHelperMethod(matchingVehicles);

                }

                else{
                    System.out.println("No vehicles found between the specified mileage range.");
                }
                //Exit the loop
                isGettingMileageRequest = false;
            }
            catch (InputMismatchException ex){
                System.out.println("Invalid input. Year must be an integer.");
            }

        }


    }
    public void GetByVehicleTypeRequest(){
        boolean isGettingByVehicleTypeRequest = true;

        //While loop
        while(isGettingByVehicleTypeRequest){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the type of vehicle you are looking for: ");
                String vehicleType = scanner.nextLine();

                List<Vehicle> matchingVehicles = dealership.getByVehicleType(vehicleType);

                if(!matchingVehicles.isEmpty()){
                    System.out.printf("These are all the vehicles that are that type ", vehicleType);
                    displayVehiclesHelperMethod(matchingVehicles);

                }
                else{
                    System.out.println("No vehicles  with this type were found.");
                }
                //Exit the loop
                isGettingByVehicleTypeRequest = false;
            }
            catch (InputMismatchException ex){
                System.out.println("Invalid input. Enter a vehicle type please.");
            }

        }

    }

    public static void AddVehicleRequest(){
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter VIN: ");
            int vin = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter make: ");
            String make = scanner.nextLine();

            System.out.println("Enter model: ");
            String model = scanner.nextLine();

            System.out.println("Enter vehicle type: ");
            String vehicleType = scanner.nextLine();

            System.out.println("Enter color: ");
            String color = scanner.nextLine();

            System.out.println("Enter odometer: ");
            int odometer = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter price: ");
            double price = scanner.nextDouble();

            // Create a new Vehicle object
            Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

            // Open the dealership.csv file for appending
            FileWriter writer = new FileWriter("src/main/resources/Inventory.csv", true);

            // Append the new vehicle data in CSV format
            writer.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                    vin, year, make, model, vehicleType, color, odometer, price));
            writer.close();

            System.out.println("Vehicle successfully added!");

        } catch(InputMismatchException | IOException ex){
            System.out.println("Invalid input. Please enter valid data for the vehicle.");

        }

    }
    public  void RemoveVehicleRequest(){
        //Remove vehicles from the list by using the VIN number
        try{
            Scanner scanner = new Scanner(System.in);
            //Prompt the user for the VIN#
            System.out.println("Enter the VIN number for the car you want to remove: ");
            int vinRemove = scanner.nextInt();

            // Find the index of the vehicle in the inventory based on VIN
            int indexToRemove = -1;

            for (int i = 0; i < dealership.inventory.size(); i++) {
                if (dealership.inventory.get(i).getVin() == vinRemove) {
                    indexToRemove = i;
                    break;
                }

                if (indexToRemove >= 0){
                    dealership.inventory.remove(indexToRemove);
                    System.out.println("Vehicle was removed successfully!");

                    DealershipFileManager.saveDealership(); // Save the changes to the file

                }else {
                    System.out.println("Vehicle not found. No vehicles removed.");
                }
            }
            // Remove the vehicle from the inventory list using an if else loop
            // Update the dealership.csv file to reflect the removed vehicle

        }catch(InputMismatchException ex){
            System.out.println("Invalid input.Please enter a valid VIN number");

        }
    }
    public void processAllVehiclesRequest(){
        //Call the dealerships get all vehicles method
         List<Vehicle> allVehicles = dealership.getAllVehicles();

        //Call the displayVehiclesHelperMethod() passing it the list, returned form getAllVehicles()
        displayVehiclesHelperMethod(allVehicles);

    }

}
