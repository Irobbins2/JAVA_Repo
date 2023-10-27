package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Payment {
    // Method to prompt and process payments
    public static void paymentProcesser(){
        Scanner scanner = new Scanner (System.in);


        System.out.println("Please enter your payment information");
        System.out.println("Enter the date of the payment (MM-dd-yyyy):" );
        LocalDate dateinput = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        scanner.nextLine();

        System.out.println("Enter the time (Hour:Minute AM/PM): ");
        LocalTime time = null;
        try{
             time = LocalTime.parse(scanner.next(), DateTimeFormatter.ofPattern("hh:mma"));
            scanner.nextLine();
        }
        catch(DateTimeParseException ex){
            System.out.println("Sorry that input is invalid");
        }

        System.out.println("Enter a description of your transaction: ");
        String description = scanner.nextLine();

        System.out.println("Who is receiving this payment: ");
        String vendor = scanner.nextLine();

        System.out.println("How much money are you paying: ");
        double amount = scanner.nextDouble();

        try{
            // Open the CSV file for appending
            FileWriter deposit = new FileWriter("src/main/resources/Transaction.csv",true);

            // If it's a payment, make the amount negative
            if (amount > 0)
                amount = -amount;

            //Formats the new data put in
            String formattedDate = dateinput.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            String formattedTime = time.format(DateTimeFormatter.ofPattern("hh:mma"));
            String formattedAmount = String.format("%.2f", amount);

            String outputLine = String.format("%s|%s|%s|%s|%s%n", formattedDate, formattedTime, description, vendor, formattedAmount);

            // Write the transaction data to the CSV file
            deposit.write(outputLine);
            deposit.close(); //closes the writer
            System.out.println("Your Payment has been added.");

        }
        catch (IOException ex){
            System.out.println("Sorry there was an error while writing to the file");

        }
    }
    }


