package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter your numerical score: ");
        int UserNum = scanner.nextInt();
        String grade;

        if (UserNum >= 90 & UserNum <= 100) {
            grade = "A";
        }
        else if (UserNum >= 80 & UserNum <= 89){
            grade = "B";
        }
        else if (UserNum >= 70 & UserNum <= 79){
            grade = "C";
        }
        else if (UserNum >= 60 & UserNum <= 69 ){
            grade = "D";
        }
        else{
            grade = "F";
        }
        System.out.println("Your letter grade is: " + grade);
        scanner.close();



    }
}