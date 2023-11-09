package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;

    public ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    // iterate through the inventory and print each vehicle to the console.
    //Love the pseudo code
    public List<Vehicle> getAllVehicles() {
        //Create a new list to store the vehicles.
        List<Vehicle> allVehicles = new ArrayList<>();

        //Iterate through the inventory list and add each vehicle to the new list.
        for (Vehicle vehicle : inventory) {
            allVehicles.add(vehicle);
        }

        //Return the new list containing all the vehicles.
        return allVehicles;
    }

    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {

        //create a new List<Vehicle> called vehiclesInPriceRange to store the vehicles that meet the price criteria.
        List<Vehicle> vehicleInPriceRange = new ArrayList<>();

        //iterate through the inventory of the dealership to examine each vehicle's price.
        for (Vehicle vehicle : inventory) {
            double price = vehicle.getPrice();

            //check if its price falls within the specified range
            if (price >= minPrice && price <= maxPrice) {

                // If the price of the vehicle is within the range, add it to the vehiclesInPriceRange list.
                vehicleInPriceRange.add(vehicle);
            }
        }
        return vehicleInPriceRange;
    }

    public List<Vehicle> getByMakeModelRequest(String make, String model) {

        List<Vehicle> vehicleMakeModel = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            String vehicleMake = vehicle.getMake();
            String vehicleModel = vehicle.getModel();
            if (vehicleMake.equalsIgnoreCase(make) && vehicleModel.equalsIgnoreCase(model)) {
                // If the price of the vehicle is within the range, add it to the vehiclesInPriceRange list.
                vehicleMakeModel.add(vehicle);
            }
        }
        return vehicleMakeModel;
    }

    public List<Vehicle> getByYearRequest(int minYear, int maxYear) {

        List<Vehicle> vehicleInYearRange = new ArrayList<>();
        boolean vehiclesFound = false; // Track if any matching vehicles are found

        //iterate through the inventory of the dealership to examine each vehicle's price.
        for (Vehicle vehicle : inventory) {
            int year = vehicle.getYear();

            //check if its year falls within the specified range
            if (year >= minYear && year <= maxYear) {
                vehicleInYearRange.add(vehicle);
                vehiclesFound = true; // Set the flag to true when a matching vehicle is found

            } if (!vehiclesFound) {
               // System.out.println("There are no vehicles related to those years");
            }
        }
        return vehicleInYearRange;
    }
    public List<Vehicle> getByColorRequest(String targetColor){
        List<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory){
            String vehicleColor = vehicle.getColor();

            if (vehicleColor.equalsIgnoreCase(targetColor)){
                matchingVehicles.add(vehicle);

            }
        }
        return matchingVehicles;
    }
    public List<Vehicle> getMileageRequest(double odometer1, double odometer2){
        List<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory){
            double odometer = vehicle.getOdometer();

            if (odometer >= odometer1 && odometer <= odometer2){
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }
    public List<Vehicle> getByVehicleType(String targetVehicleType){
        List<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory){
            String vehicleType = vehicle.getVehicleType();

            if (vehicleType.equalsIgnoreCase(targetVehicleType)){
                matchingVehicles.add(vehicle);

            }
        }
        return matchingVehicles;
    }
}



