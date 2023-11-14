package org.example;

public class LeaseContract extends Contract {
    private double endingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, Vehicle vehicleSold, double endingValue, double leaseFee) {
        super(date, customerName, vehicleSold);
        this.endingValue = endingValue;
        this.leaseFee = leaseFee;
    }

    public double getEndingValue() {
        //Ending value is 50% of the original price
        return getVehicleSold().getPrice() * 0.50;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        //Lease fee is 7% of the original price
        return getVehicleSold().getPrice() * 0.07;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
    @Override
    public double getMonthlyPayment(){
        //All Leases are financed at 4% for 36 months
        double P = getVehicleSold().getPrice() * getLeaseFee(); // Cost of the vehicle, 7% of the vehicles price is the lease fee.
        double Rv = 0.04 / 12; //Rv is the residual monthly interest rate which is 4% (divide by 12)
        double r = 0.04; //r is the monthly interest rate
        int n = 36; //number of payments, Lease term is 36 months

        //Monthly Payment = (P-Rv) x r / 1-(1+r)^ - n
        //Add the cost of the vehicle, plus the lease fee, and then total of the monthly payments.
        double monthlyPayment = (P - Rv) * r / (1 - Math.pow(1 + r, - n));
        return monthlyPayment;
    }
    @Override
    public double getTotalPrice(){
        return getMonthlyPayment() * 36;
    }
}
