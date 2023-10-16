package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    // Create an integer array of size 5 and initialize it with some unsorted values.
        //    Sort the array.
        //    Print the sorted array.

        int[] intArray = new int[5];

        intArray[0] = 5;
        intArray[1] = 4;
        intArray[2] = 3;
        intArray[3] = 2;
        intArray[4] = 1;

        Arrays.sort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }
}