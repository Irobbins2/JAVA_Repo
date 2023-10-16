package org.example;

public class Student {
    public String Student;

    public String firstName;

    public String lastName;

    public int ID;

    public String yearIn;

    public boolean international;

    public String addy;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int ID() {
        return ID;
    }

    public void setStudentID(int ID) {
        this.ID = ID;
    }

    public String getYearIn() {
        return yearIn;
    }

    public void setYearIn(int yearIn) {
        this.yearIn = yearIn;
    }

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }

    public String getAddy() {
        return addy;
    }

    public void setAddy(String addy) {
        this.addy = addy;
    }

    //greetings method
    public String greetings() {
        return "Hello, I am " + this.getFirstName() + ". I am a student in grade " + this.yearIn + ".";
    }

    //Constructor with all properties

    public Student(String firstName, String lastName, int ID, String yearIn, boolean international, String addy){
     this.firstName = firstName;
     this.lastName = lastName;
     this.ID = ID;
     this.yearIn = yearIn;
     this.international = international;
     this.addy = addy;
    }
    //Constructer with some properties

    public Student (String firstName, String lastName, int ID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }
}
