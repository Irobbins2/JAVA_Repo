package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Introduction + user prompt for numbers
        System.out.println("Welcome to the basic calculator");
        System.out.println("Enter a number for me");

        Scanner scanner = new Scanner (System.in);
        double firstNumber = scanner.nextDouble();

        System.out.println("Give me the second number");
        double secondNumber = scanner.nextDouble();

        //mutiple choice prompt
        System.out.println("What do you want to do?");
        System.out.println("Add?");
        System.out.println("Subtract?");
        System.out.println("Divide?");
        System.out.println("Multiply?");
        scanner.nextLine();
        String calculationPrompt = scanner.nextLine();

        //Mutiple calculations
        if (calculationPrompt.equalsIgnoreCase("Add")) {
            System.out.println(firstNumber + secondNumber);
        }
        else if (calculationPrompt.equalsIgnoreCase("multiply")){
            System.out.println(firstNumber * secondNumber);
        }
        else if (calculationPrompt.equalsIgnoreCase("Divide")){
            System.out.println(firstNumber / secondNumber);
        }
        else if (calculationPrompt.equalsIgnoreCase("Subtract")){
            System.out.println(firstNumber - secondNumber);
        }

    }
}