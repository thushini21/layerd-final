package lk.ijse.HelankaShoeMarket.Repository;

import lk.ijse.HelankaShoeMarket.DB.DbConnection;
import lk.ijse.HelankaShoeMarket.model.Order;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepo {
    public static String getCurrentId() throws SQLException {
        String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            String orderId = resultSet.getString(1);
            return orderId;
        }
        return null;
    }

    public static boolean save(Order order) throws SQLException {
        String sql = "INSERT INTO orders VALUES(?, ?, ?)";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setString(1, order.getOrder_id());
        pstm.setString(2, String.valueOf(order.getOrder_placed_date()));
        pstm.setDate(3, Date.valueOf(order.getDescription()));

        return pstm.executeUpdate() > 0;
    }
}
