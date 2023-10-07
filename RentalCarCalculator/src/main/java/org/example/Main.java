package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Rental car calculator!");
        Scanner scanner = new Scanner(System.in);

        //Pick up date
        System.out.println("What day were you picking up your car?");
        String pickUpDate = scanner.nextLine();

        //User age
        System.out.println("How old are you?");
        int userAge = scanner.nextInt();

        //Amount of days for the rental
        System.out.println("How many days are you renting the car for?");
        int rentalDuration = scanner.nextInt();

        //Toll tags
        System.out.println("Do you want toll tags for $3.95 per day? True or false.");
        boolean tollTag = scanner.nextBoolean();

        //Gps
        System.out.println("Do you want a GPS? True or false");
        boolean GPS = scanner.nextBoolean();

        //Roadside assistance
        System.out.println("Would you like Roadside assistance? True or false");
        boolean roadSide = scanner.nextBoolean();

        //Rental cost

        double baseRate = 29.99;
        double rentalGps = 2.95;
        double RoadSideAssistance = 3.95;
        double surcharge = 1.3;
        double totalCost = rentalDuration * baseRate;

        //Calculate cost
        //User is 25+
         if (userAge >= 25){
            System.out.println( "The total cost is " + totalCost);
        }
         //user is under 25
        else if (userAge < 25){
             System.out.println("The total cost is " + totalCost * 1.3);
         }
         //User picks roadside assistance and Rental GPS
         else if (roadSide && GPS ) {
            System.out.println("The total cost is " + totalCost * 2.95 * 3.95);
    }
         //User is 25+ and wants roadside
         else if  (userAge >= 25 && roadSide) {
             System.out.println("The total cost is " + totalCost * 3.95);
         }
         //User is 25+ and wants GPS
        if  (userAge >= 25 && GPS) {
            System.out.println("The total cost is " + totalCost * 2.95);
        }
        //User is 25+ and wants all 3 options
        if (userAge >= (25 GPS RoadSideAssistance)){

        }


   }
}
