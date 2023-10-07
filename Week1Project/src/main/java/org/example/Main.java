package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //User principal amount
        Scanner scanner = new Scanner (System.in);
        System.out.println("What is your principal amount: ");
        double principal = scanner.nextDouble();

        //interest amount
        System.out.println("What is your interest rate in as a percentage: ");
        double monthlyRate = scanner.nextDouble()/ 12 / 100;
        double totalInterest;

        //Loan length
        System.out.println("What is the duration of your loan in years: ");
        int loanTermYears = scanner.nextInt();
        int loanTermMonths = loanTermYears * 12;

        //Monthly payment
        double monthlyPayment =  principal * (monthlyRate * Math.pow(1 + monthlyRate, loanTermMonths))
                / (Math.pow(1 + monthlyRate, loanTermMonths) - 1);

        //Total interest
        totalInterest = (monthlyPayment * loanTermMonths) - principal;

        //Result
        System.out.println("Your total monthly payment is $" + monthlyPayment);
        System.out.println("The total amount of interest you will be paying is " + totalInterest);

        futureValue();

    }
    private static void futureValue(){
        Scanner scanner = new Scanner (System.in);

        //intial deposit
        System.out.println("What is your intial deposit: ");
        double deposit = scanner.nextDouble();

        //Annual interest rate
        System.out.println("What is your interest rate as a percentage: ");
        double interest = scanner.nextDouble();
        double dailyRate = interest / 365 / 100;

        //CD maturity
        System.out.println("How long will it take your CD to mature: ");
        double maturity = scanner.nextDouble();

        //Compound frequency
        System.out.println("How many times is interest compounded per year: ");
        int frequency = scanner.nextInt();

        //Future value
        double FV =  deposit * Math.pow(1 + dailyRate / frequency, frequency * maturity);
        double totalInterest = FV - deposit;

        //Result
        System.out.printf("The future value of your CD will be: $%.2f%n", FV);
        System.out.printf("The total interest you earned is $%.2f%n", totalInterest);

        presentValue();

    }

    private static void presentValue(){
        Scanner scanner = new Scanner (System.in);

        //monthly payout amount (PMT)
        System.out.println("What is the monthly payout amount: ");
        double PMT = scanner.nextDouble();

        //expected interest rate (r)
        System.out.println("What is the expected interest rate in percentages: ");
        double interestRate = scanner.nextDouble() / 100;

        //number of years to pay out
        System.out.println("How many years will it take to pay out: ");
        int years = scanner.nextInt();

        //monthly interest rate
        double monthlyRate = interestRate / 12 / 100;
        double monthlyPayments = years * 12;
        double PV = (PMT * (1 - Math.pow(1 + monthlyRate, -monthlyPayments))) / monthlyRate;

        //Result
        System.out.printf("The present value of the ordinary annuity is: $%.2f%n", PV);
        System.out.println();

    }

}