package lk.ijse.HelankaShoeMarket.Repository;

import lk.ijse.HelankaShoeMarket.DB.DbConnection;
import lk.ijse.HelankaShoeMarket.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepo {

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM Product  WHERE product_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }

    public static boolean save(Product product) throws SQLException {
        String sql = "INSERT INTO Product VALUES(?, ?, ?, ? ,?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, product.getProduct_id());
        pstm.setObject(2, product.getProduct_qty_on_hand());
        pstm.setObject(3, product.getUnit_price());
        pstm.setObject(4, product.getDesign());
        pstm.setObject(4, product.getDescription());
        pstm.setObject(4, product.getMaterial_id());



        return pstm.executeUpdate() > 0;
    }

    public static boolean update(Product product) throws SQLException {
        String sql = "UPDATE Product SET product_id = ?, product_qty_on_hand = ?, unit_price =?,description =?,design =?,material_id= ? WHERE product_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, product.getProduct_id());
        pstm.setObject(2, product.getProduct_qty_on_hand());
        pstm.setObject(3, product.getUnit_price());
        pstm.setObject(4, product.getDesign());
        pstm.setObject(4, product.getDescription());
        pstm.setObject(4, product.getMaterial_id());



        return pstm.executeUpdate() > 0;
    }

    public static Product searchById(String code) {
        return null;
    }
}
