package org.example;

public class Main {
    public static void main(String[] args) {

        //For Loop for even numbers

        for (int i = 2; i <= 20; i += 2) {
            System.out.println("The value is " + i);
        }

        //While loop for odd numbers
        int z = 1;
        while (z <= 19) {

            //Add 2 to z to get to the next odd number
            z += 2;
            System.out.println("The value is " + z);
        }
        //For loop for numbers divisable by 7 and 3
        for (int T = 1; T <= 100; T++) {

            //Use the modulo operator to check if the remainder is 0
            if (T % 7 == 0 && T % 9 == 0) {
                System.out.println(" The value is T " + T);
            }

        }
    }
}