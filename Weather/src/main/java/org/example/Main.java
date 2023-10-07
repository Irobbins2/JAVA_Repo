package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Greeting
        System.out.println("Hey!, How's the weather today?");
        Scanner scanner = new Scanner(System.in);

        //Weather prompts
        System.out.println("Cloudy?,Rainy?,Sunny?");
        String userInput = scanner.nextLine();

        //Responses to weather prompt
        if (userInput.equalsIgnoreCase("Sunny")) {
            System.out.println("It's a great day for outdoor activities!");
        }
        else if (userInput.equalsIgnoreCase("Cloudy")){
            System.out.println("The weather is a bit uncertain.");
        }
        else if (userInput.equalsIgnoreCase("Rainy")){
            System.out.println("Don't forget your umbrella!");
        }
        else {
            System.out.println("Sorry, I'm not sure about that weather type.");
        }

    }
}