package org.example;

public class SalesContract extends Contract {
    private boolean finance;
    public SalesContract(String date, String customerName, Vehicle vehicleSold, boolean finance) {
        super(date, customerName, vehicleSold);
        this.finance = finance;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public double getSalesTax() {
        return 0.05;
    }

    public double getProcessingFee() { //if vehicle price is < 10,000 then 295 else 495
        if (getVehicleSold().getPrice() <= 10000) {
            return 295;
        } else {
            return 495;
        }
    }
    @Override
    public double getTotalPrice() {

        //Get the vehicles base price (Contract has a vehicle, so the vehicle knows)
        //Sales tax 5% (applied to the original price)
        double basePrice = getVehicleSold().getPrice() * getSalesTax();
        double totalPrice;
        double interestRate;

        //Make a variable to hold the recording fee
        double recordingFee = 100;

        //if isFinanced we need to know the interest rate
        if (isFinance()) {

            double p = getVehicleSold().getPrice(); //princple amount
            double r = 0.0425 / 12; //Monthly interest rate
            double R = 0.0525 / 12; //Monthly interest rate

            //if price is >= 10000 then interest rate is 4.25  and loan length is 48 months
            if (p >= 10000) {
                return (48 * (p * r * Math.pow(1 + r, 48)))
                        / (Math.pow(1 + r, 48) - 1)
                        + recordingFee + getProcessingFee() + getSalesTax();

            } else {
                // interest rate is 5.25% and loan length is 24 months
                return (24 * (p * R * Math.pow(1 + R, 24)) /
                        Math.pow(1 + R, 48) - 1)
                        + recordingFee + getProcessingFee() + getSalesTax();
            }
        } else {
            //Add up the base price, the sales tax, recording fee,
            return getVehicleSold().getPrice() + recordingFee + getProcessingFee() + getSalesTax();
        }
    }
    @Override
    public double getMonthlyPayment() {
        //Monthly Payment = (P-Rv) x r / 1-(1+r)^ - n
        double basePrice = getVehicleSold().getPrice();//Princpal loan amount
        double monthlyPayment;
        if (isFinance()) {
            if (basePrice >= 10000) {
                monthlyPayment = getTotalPrice() / 48; //48 month lease term
            } else {
                monthlyPayment = getTotalPrice() / 24; // 24 month lease term
            }
            return getMonthlyPayment();
        }
        else
            return  0;
    }
}

