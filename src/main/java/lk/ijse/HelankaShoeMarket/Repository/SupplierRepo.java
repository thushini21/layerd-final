package lk.ijse.HelankaShoeMarket.Repository;

import lk.ijse.HelankaShoeMarket.DB.DbConnection;
import lk.ijse.HelankaShoeMarket.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupplierRepo {
    public static boolean save(Supplier supplier) throws SQLException {
        String sql = "INSERT INTO Supplier VALUES(?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, supplier.getSupplier_id());
        pstm.setObject(2, supplier.getSupplier_name());
        pstm.setObject(3, supplier.getSupplier_address());
        pstm.setObject(4, supplier.getSupplier_tel());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM Supplier WHERE supplier_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, (id));

        return pstm.executeUpdate() > 0;
    }

    public static boolean update(Supplier supplier) throws SQLException {
        String sql = "UPDATE Supplier SET supplier_name = ?, supplier_address = ?, supplier_tel = ? WHERE supplier_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, supplier.getSupplier_id());
        pstm.setObject(2, supplier.getSupplier_name());
        pstm.setObject(3, supplier.getSupplier_address());
        pstm.setObject(4, supplier.getSupplier_tel());


        return pstm.executeUpdate() > 0;
    }
}