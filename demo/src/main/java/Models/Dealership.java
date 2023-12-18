package Models;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;
    private int dealershipID;

    public ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phoneNumber, int dealershipID) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDealershipID() {
        return dealershipID;
    }

    public void setDealershipID(int dealershipID) {
        this.dealershipID = dealershipID;
    }
}

