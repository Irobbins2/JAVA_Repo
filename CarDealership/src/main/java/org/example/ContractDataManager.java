package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    //Users will have to provide a vehicle VIN
    //Once data is collected the info needs to append to Contract.csv
    //Add a method called saveContract to append Contract.csv
    //use the instanceof operator to check the type of contract (Sale or Lease)

    public static void saveContract(Contract contract){
        try {
            FileWriter writer = new FileWriter("src/main/resources/Contract.csv", true);

                // iterating over each Contract object in the list obtained from Contr
                if (contract instanceof SalesContract) {
                    // Sales contract
                    SalesContract salesContract = (SalesContract) contract;
                    String csvLine = "SALE|" +
                            contract.getDate() + "|" +
                            contract.getCustomerName() + "|" +
                            contract.getVehicleSold().getVin() + "|" +
                            contract.getVehicleSold().getYear() + "|" +
                            contract.getVehicleSold().getMake() + "|" +
                            contract.getVehicleSold().getModel() + "|" +
                            contract.getVehicleSold().getVehicleType() + "|" +
                            contract.getVehicleSold().getColor() + "|" +
                            contract.getVehicleSold().getOdometer() + "|" +
                            contract.getVehicleSold().getPrice() + "|" +
                            salesContract.getProcessingFee() + "|" +
                            salesContract.getTotalPrice() + "|" +
                            (salesContract.isFinance() ? "YES" : "NO") + "|" +
                            salesContract.getMonthlyPayment();

                    writer.write(csvLine + System.lineSeparator());
                } else if (contract instanceof LeaseContract) {

                    // Lease contract
                    LeaseContract leaseContract = (LeaseContract) contract;
                    String csvLine = "LEASE|" +
                            contract.getDate() + "|" +
                            contract.getCustomerName() + "|" +
                            contract.getVehicleSold().getVin() + "|" +
                            contract.getVehicleSold().getYear() + "|" +
                            contract.getVehicleSold().getMake() + "|" +
                            contract.getVehicleSold().getModel() + "|" +
                            contract.getVehicleSold().getVehicleType() + "|" +
                            contract.getVehicleSold().getColor() + "|" +
                            contract.getVehicleSold().getOdometer() + "|" +
                            contract.getVehicleSold().getPrice() + "|" +
                            leaseContract.getEndingValue() + "|" +
                            leaseContract.getLeaseFee() + "|" +
                            leaseContract.getMonthlyPayment();

                    writer.write(csvLine + System.lineSeparator());
                }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to the file.");
        }
    }

}
