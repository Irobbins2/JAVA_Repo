package org.example;

public abstract class  Contract {
    private String date;
    private String customerName;
    private Vehicle vehicleSold;


    public Contract(String date, String customerName,  Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.vehicleSold = vehicleSold;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();
}
