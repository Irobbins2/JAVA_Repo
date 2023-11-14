package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {
    @Test
    public void Remove_Vehicle_From_Index(){
        //Arrange
        //If the user enters in a vehicles vin number then remove it from the csv file
        //Where testing if the vin removes the vehicle
        Dealership dealership = new Dealership("Zay's Automotives", "2014 Forest Hills dr", "738-3499"); // Create a dealership instance

        Vehicle vehicle1 = new Vehicle(12345, 5, "Kia", "Forte", "Sedan",
                "Black", 100000, 150000);
        dealership.addVehicle(vehicle1);


        //Act
            Dealership.Remove

        //Assert
        assertNull(dealership.getVehicleByVin(12345));
    }

}