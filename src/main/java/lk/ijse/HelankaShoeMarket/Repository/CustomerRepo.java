package lk.ijse.HelankaShoeMarket.Repository;

import lk.ijse.HelankaShoeMarket.DB.DbConnection;
import lk.ijse.HelankaShoeMarket.model.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerRepo {
    public static boolean save(Customer customer) throws SQLException {
        String sql = "INSERT INTO Customer VALUES(?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, customer.getCustomer_id());
        pstm.setObject(2, customer.getCustomer_name());
        pstm.setObject(3, customer.getCustomer_address());
        pstm.setObject(4, customer.getCustomer_tel());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM Customer WHERE customer_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }

    public static boolean update(Customer customer) throws SQLException {
        String sql = "UPDATE Customer SET customer_name = ?, customer_address = ?, customer_tel = ? WHERE customer_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, customer.getCustomer_id());
        pstm.setObject(2, customer.getCustomer_name());
        pstm.setObject(3, customer.getCustomer_address());
        pstm.setObject(4, customer.getCustomer_tel());

        return pstm.executeUpdate() > 0;
    }

    public static Customer searchById(String id) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE customer_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String tel = resultSet.getString(4);

            Customer customer = new Customer(cus_id, name, address, tel);

            return customer;
        }

        return null;
    }
}
