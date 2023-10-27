package org.example;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Deposit {
    //Create an ArrayList to store deposit history
    private static final ArrayList<TransactionDeposit> depositHistory = new ArrayList<>();
    public static void addDeposit(){
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        //User prompts
        System.out.println("Please enter the deposit information");
        System.out.println("Enter the date (MM-DD-YYYY): ");

        LocalDate dateInput = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        scanner.nextLine();

        System.out.println("Enter the time (Hour:Minute AM/PM): ");
        LocalTime time = LocalTime.parse(scanner.next(), DateTimeFormatter.ofPattern("hh:mma"));
        scanner.nextLine();

        System.out.println("Enter a description of your transaction: ");
        String description = scanner.nextLine();

        System.out.println("Who is receiving this deposit: ");
        String vendor = scanner.nextLine();

        System.out.println("How much money are you depositing: ");

        double amountInput;

         try{
              amountInput = scanner.nextDouble();
             amountInput = Double.parseDouble(String.valueOf(amountInput));
            // TransactionDeposit newTransaction = new TransactionDeposit(dateInput, time, description, vendor, amountInput);

         }catch (NumberFormatException ex){
             System.out.println("Invalid input.Please enter a numeric value");
             return; // Return to the main menu

        }

        try{
            // Read existing transactions from the CSV file
            Scanner fileScanner = new Scanner(new File("src/main/resources/Transaction.csv"));
            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                String[] parts = line.split("\\|"); // Split the line into parts using the '|' character as the delimiter
                if (parts.length >= 2) {
                   // String date = parts[0];// Extract the date from the first part of the split line
                   // String transactionTime = parts[1];//Extract time from the second part of the array
                    String transactionDescription = parts[2];
                    String transactionVendor = parts[3];
                    //fileScanner.close(); // Close the file scanner when done
                    try{
                        double transactionAmount = Double.parseDouble(parts[4]);
                        depositHistory.add(new TransactionDeposit(dateInput, time, transactionDescription, transactionVendor, transactionAmount));

                    }
                    catch (Exception ex){
                        //System.out.println("Sorry try again.");
                    }
                } else {
                    //System.out.println("Invalid data in the line: " + line);
                }

        }

        }catch(FileNotFoundException ex){
            //System.out.println("Invalid");

        }

        try{
            // Open the CSV file for appending
            FileWriter deposit = new FileWriter("src/main/resources/Transaction.csv",true);

            //Formats the new data put in
            String formattedDate = dateInput.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            String formattedTime = time.format(DateTimeFormatter.ofPattern("hh:mma"));
            String formattedAmount = String.format("%.2f", amountInput);

            String outputLine = String.format("%s|%s|%s|%s|%s%n", formattedDate, formattedTime, description, vendor, formattedAmount);

           // Write the transaction data to the CSV file
                deposit.write(outputLine);
                deposit.close(); //closes the writer
                System.out.println("Your deposit has been added.");

        }
        catch (IOException ex){
            //System.out.println("Sorry there was an error while writing to the file");
        }
    }
}
