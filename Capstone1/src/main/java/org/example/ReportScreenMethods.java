package org.example;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

public class ReportScreenMethods {
    public static void displayMonthtoDate() {
        //Method stuff
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        try {
            FileInputStream fis = new FileInputStream("src/main/resources/Transaction.csv");

            Scanner scanner = new Scanner(fis);
            String input;

            while (scanner.hasNextLine()) {
                input = scanner.nextLine();
                String[] parts = input.split("\\|");

                if(parts.length >= 2) {
                    Date transacationDate = dateFormat.parse(parts[1]);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(currentDate);
                    int currentMonth =cal.get(Calendar.MONTH) + 1;

                    cal.setTime(transacationDate);
                    int transactionMonth = cal.get(Calendar.MONTH) + 1;
                    if (currentMonth == transactionMonth) {
                        System.out.println(input);
                    }
                }
            }
            scanner.close(); // Close the scanner when done

        } catch (FileNotFoundException | ParseException ex) {
            System.out.println("There was an error trying to find this file or there was an error while parsing ");
        }
    }
                public static void displayPreviousMonth() {
                    //Method stuff
                }
                public static void displayYearToDate () {
                    //Method stuff
                }
                public static void displayPreviousYear () {
                    //Method stuff
                }
                public static void displaySearchByVendor () {
                    //Method stuff
        }
    }
