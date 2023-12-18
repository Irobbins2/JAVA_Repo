package Models.Repositories;

import Models.Vehicle;
import Models.config.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class VehicleRepository {
    //Dependency
    //Without this, we can't connect to the database

    private final DataSource dataSource;

    @Autowired

    public VehicleRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public List<Vehicle>getAllVehicles(){
        String query ="SELECT * FROM vehicles";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                vehicles.add(new Vehicle(rs.getInt("VIN"), rs.getInt("Year"),
                        rs.getString("Make"), rs.getString("Model"), rs.getString("Color"),
                        rs.getString("VehicleType"), rs.getInt("Odomoter"), rs.getDouble("Price")));
            }
        }

        catch(SQLException ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

        public List <Vehicle> getVehicleByPrice(double min, double max){
            String query = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";
            List<Vehicle> vehicles = new ArrayList<>();
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setDouble(1, min);
                ps.setDouble(2, max);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    vehicles.add(new Vehicle(rs.getInt("VIN"), rs.getInt("Year"),
                            rs.getString("Make"), rs.getString("Model"), rs.getString("Color"),
                            rs.getString("VehicleType"), rs.getInt("Odomoter"), rs.getDouble("Price")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return vehicles;
        }

        public List <Vehicle> getVehiclesByMakeModel(String make, String model){
            String query = "SELECT * FROM vehicles WHERE make = ? AND model = ?";
            List<Vehicle> vehicles = new ArrayList<>();
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setString(1, make);
                ps.setString(2, model);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    vehicles.add(new Vehicle(rs.getInt("VIN"), rs.getInt("Year"),
                            rs.getString("Make"), rs.getString("Model"), rs.getString("Color"),
                            rs.getString("VehicleType"), rs.getInt("Odomoter"), rs.getDouble("Price")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return vehicles;
        }

        public List <Vehicle> getVehiclesByYear(int min, int max){
            String query = "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?;";
            List<Vehicle> vehicles = new ArrayList<>();
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, min);
                ps.setInt(2, max);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    vehicles.add(new Vehicle(rs.getInt("VIN"), rs.getInt("Year"),
                            rs.getString("Make"), rs.getString("Model"), rs.getString("Color"),
                            rs.getString("VehicleType"), rs.getInt("Odomoter"), rs.getDouble("Price")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return vehicles;
        }


        public List <Vehicle> getVehiclesByColor(String color){
            String query = "SELECT * FROM vehicles WHERE color = ?";
            List<Vehicle> vehicles = new ArrayList<>();
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setString(1, color);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    vehicles.add(new Vehicle(rs.getInt("VIN"), rs.getInt("Year"),
                            rs.getString("Make"), rs.getString("Model"), rs.getString("Color"),
                            rs.getString("VehicleType"), rs.getInt("Odomoter"), rs.getDouble("Price")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return vehicles;
        }

        public List <Vehicle> getVehiclesByMileage(int min, int max){
            String query = "SELECT * FROM vehicles WHERE mileage BETWEEN ? AND ?";
            List<Vehicle> vehicles = new ArrayList<>();

            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, min);
                ps.setInt(2, max);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    vehicles.add(new Vehicle(rs.getInt("VIN"), rs.getInt("Year"),
                            rs.getString("Make"), rs.getString("Model"), rs.getString("Color"),
                            rs.getString("VehicleType"), rs.getInt("Odomoter"), rs.getDouble("Price")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return vehicles;
        }

        public List <Vehicle> getVehiclesByType(String vehicleType){
            String query = "SELECT * FROM vehicles WHERE type = ?";
            List<Vehicle> vehicles = new ArrayList<>();
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setString(1, vehicleType);


                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    vehicles.add(new Vehicle(rs.getInt("VIN"), rs.getInt("Year"),
                            rs.getString("Make"), rs.getString("Model"), rs.getString("Color"),
                            rs.getString("VehicleType"), rs.getInt("Odomoter"), rs.getDouble("Price")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return vehicles;
        }

        public List <Vehicle> addVehicle(Vehicle vehicle){
            String query = "INSERT INTO vehicles (VIN, Year, Make, Model, Color, VehicleType, Odometer, Price)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            List<Vehicle> vehicles = new ArrayList<>();
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, vehicle.getVin());
                ps.setInt(2, vehicle.getYear());
                ps.setString(3, vehicle.getMake());
                ps.setString(4, vehicle.getModel());
                ps.setString(5, vehicle.getColor());
                ps.setString(6, vehicle.getVehicleType());
                ps.setInt(7, vehicle.getOdometer());
                ps.setDouble(8, vehicle.getPrice());

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Vehicle added successfully");
                } else {
                    System.out.println("Failed to add the vehicle");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return getAllVehicles(); // Return the updated list of vehicles after adding the new one
        }

        public List <Vehicle> removeVehicle(Vehicle vehicle){
            String query = "DELETE FROM vehicles WHERE id = ?";
            List<Vehicle> vehicles = new ArrayList<>();
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, vehicle.getVin());

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Vehicle removed successfully");
                } else {
                    System.out.println("Failed to remove the vehicle. Vehicle with VIN " + vehicle.getVin() + " not found.");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return getAllVehicles(); // Return the updated list of vehicles after removal
        }

        }



