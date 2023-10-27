package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TransactionDeposit {
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionDeposit(LocalDate dateInput, LocalTime time, String description, String vendor, double amount) {
        this.date = dateInput.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        this.time = time.format(DateTimeFormatter.ofPattern("HH:mm"));
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
}
