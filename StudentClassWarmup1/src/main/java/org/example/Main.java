package org.example;

public class Main {
    public static void main(String[] args) {

        //Student instance
        Student student1 = new Student();
        student1.setFirstName("Obeezy");
        student1.setLastName ("Fitzgeraled");
        student1.setYearIn(1);

        //Call greetings instance
        String introduction = student1.greetings();
        System.out.println(introduction);


    }
}