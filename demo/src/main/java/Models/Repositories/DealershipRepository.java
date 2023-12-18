package Models.Repositories;

import Models.Dealership;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class DealershipRepository {
    private final DataSource dataSource;

    @Autowired
    public DealershipRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }


    //CRUD functions for dealership
    //getAllDealerships, getDealershipById, createDealership, updateDealership, deleteDealership

    public void createDealership(Dealership dealership){
        String query ="INSERT INTO dealerships (name, address, phone) Values(?,?,?)";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){



            ps.setString(1, dealership.getName());
            ps.setString(2, dealership.getAddress());
            ps.setString(3, dealership.getPhoneNumber());

            ps.executeUpdate();

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void updateDealership(Dealership dealership){
        String query = "UPDATE dealerships SET name = ?, address = ?, phone = ? WHERE dealershipID = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, dealership.getName());
            ps.setString(2, dealership.getAddress());
            ps.setString(3, dealership.getPhoneNumber());
            ps.setInt(4, dealership.getDealershipID());


            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void deleteDealership(int id) {
        String query = "DELETE FROM dealerships WHERE dealershipID = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
