package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //User menu
        int choice;
        while (true) { // Create an infinite loop
        System.out.println("Welcome to Zay's ledger accounting!");
        System.out.println("What would you like to do?");
        System.out.println("1. Add a deposit.");
        System.out.println("2. Make a payment.");
        System.out.println("3. Access Ledger.");
        System.out.println("4. Exit");

        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Handle adding deposits
                    Deposit.addDeposit();
                    break;

                case 2:
                    //Handle making payments
                    Payment.paymentProcesser();
                    break;

                case 3:
                    //Access Ledger
                    LedgerMenu.Ledger();
                    break;

                case 4:
                    //Exit
                    System.out.println("See you next time!");
                    break;
            }
        }
    }
}