package lk.ijse.HelankaShoeMarket.Repository;

import lk.ijse.HelankaShoeMarket.DB.DbConnection;
import lk.ijse.HelankaShoeMarket.model.PlaceOrder;
import lk.ijse.HelankaShoeMarket.model.Product;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceOrderRepo {

    public static boolean placeOrder(PlaceOrder po) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isOrderSaved = OrderRepo.save(po.getOrder());
            if (isOrderSaved) {
                boolean isQtyUpdated = ProductRepo.update((Product) po.getOdList());
                if (isQtyUpdated) {
                    boolean isOrderDetailSaved = OrderDetailRepo.save(po.getOdList());
                    if (isOrderDetailSaved) {
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        } catch (Exception e) {
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }    }

