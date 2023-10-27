package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LedgerMenu {
    public static void Ledger(){

        //Ledger User Menu
        Scanner userinput = new Scanner(System.in);

        System.out.println("You are now in the Ledger menu");
        System.out.println("What would ypu like to do");
        System.out.println("(A) Display all entries");
        System.out.println("(D) Display entries that are only deposits");
        System.out.println("(P)Display only the negative entries");
        System.out.println("(R)Reports");

        String choice = userinput.nextLine();
        double amount = 0.0;


        try{
            FileInputStream fis = new FileInputStream("src/main/resources/Transaction.csv");

            Scanner scanner = new Scanner(fis);
            String input;

            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                String[] parts = input.split("\\|");
                if(choice.equalsIgnoreCase("A")){
                    System.out.println(input);
                } else if (choice.equalsIgnoreCase("D")) {
                    try{
                        if (parts.length >= 5)
                            amount = Double.parseDouble(parts[4]);
                        if (amount > 0)
                            System.out.println(input);
                    }
                    catch (NumberFormatException ex){
                        System.out.println("Sorry that is invalid.");
                    }
                }
                else if (choice.equalsIgnoreCase("P")) {
                    try{
                        if (parts.length >= 5)
                            amount = Double.parseDouble(parts[4]);
                        if (amount < 0)
                            System.out.println(input);
                    }
                    catch (NumberFormatException ex){
                        System.out.println("Sorry that is invalid.");
                    }
                }
                else if (choice.equalsIgnoreCase("R")){

                    System.out.println("Choose a report option");
                    System.out.println("1) Month to date");
                    System.out.println("2) Previous Month ");
                    System.out.println("3) Year to Date");
                    System.out.println("4) Previous year");
                    System.out.println("5) Search by Vendor");

                    int reportChoice = userinput.nextInt();;

                    switch (reportChoice){
                        case 1:
                            //Month to date method
                            ReportScreenMethods.displayMonthtoDate();
                            break;

                        case 2:
                            //Previous Month method
                            ReportScreenMethods.displayPreviousMonth();
                            break;
                        case 3:
                            //Year to date method
                            ReportScreenMethods.displayYearToDate();
                            break;

                        case 4:
                            //previous year method
                            ReportScreenMethods.displayPreviousYear();
                            break;
                        case 5:
                            //Search by vendor method
                            ReportScreenMethods.displaySearchByVendor();
                            break;
                    }

                }

            }

        }
        catch(FileNotFoundException ex){
            System.out.println("File not found");

        }

    }
}
