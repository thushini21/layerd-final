package lk.ijse.HelankaShoeMarket.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import lk.ijse.HelankaShoeMarket.Repository.CustomerRepo;
import lk.ijse.HelankaShoeMarket.Repository.PlaceOrderRepo;
import lk.ijse.HelankaShoeMarket.Repository.ProductRepo;
import lk.ijse.HelankaShoeMarket.model.*;
import lk.ijse.HelankaShoeMarket.model.Tm.CartTm;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlaceOrderFormController {

    @FXML
    private Label lblnettotal;

    @FXML
    private JFXButton btnaddcart;

    @FXML
    private JFXButton btnplaceorder;

    @FXML
    private JFXComboBox<?> cmbProductId;

    @FXML
    private JFXComboBox<?> cmbcustomerid;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblcustomerid;

    @FXML
    private Label lblcustomername;

    @FXML
    private Label lbldescription;

    @FXML
    private Label lblorderdate;

    @FXML
    private Label lblorderid;

    @FXML
    private Label lblproductid;

    @FXML
    private Label lblqty;

    @FXML
    private Label lblqtyonhand;

    @FXML
    private Label lblunitprice;

    @FXML
    private Label lblhandovereddate;
    @FXML
    private Label lblstatus;

    @FXML
    private TableView<CartTm> tblOrderCart;

    @FXML
    private TextField txtqty;
    private ObservableList<CartTm> obList = FXCollections.observableArrayList();
    @FXML
    void btnAddCartOnAction(ActionEvent event) {
        String productid = (String) cmbProductId.getValue();
        String description = lbldescription.getText();
        int qty = Integer.parseInt(txtqty.getText());
        double unitPrice = Double.parseDouble(lblunitprice.getText());
        double total = qty * unitPrice;
        JFXButton btnRemove = new JFXButton("remove");
        btnRemove.setCursor(Cursor.HAND);

        btnRemove.setOnAction((e) -> {
            ButtonType yes = new ButtonType("yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("no", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if(type.orElse(no) == yes) {
                int selectedIndex = tblOrderCart.getSelectionModel().getSelectedIndex();
                obList.remove(selectedIndex);

                tblOrderCart.refresh();
                calculateNetTotal();
            }
        });

        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            if(productid.equals(colItemCode.getCellData(i))) {

                CartTm tm = obList.get(i);
                qty += tm.getQty();
                total = qty * unitPrice;

                tm.setQty(qty);
                tm.setTotal(total);

                tblOrderCart.refresh();

                calculateNetTotal();
                return;
            }
        }

        CartTm tm = new CartTm(productid, description, qty, unitPrice, total, btnRemove);
        obList.add(tm);

        tblOrderCart.setItems(obList);
        calculateNetTotal();
        txtqty.setText("");
    }

    private void calculateNetTotal() {
        int netTotal = 0;
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            netTotal += (double) colTotal.getCellData(i);
        }
        lblnettotal.setText(String.valueOf(netTotal));
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
         String order_id = lblorderid.getText();
         String customer_id = lblcustomerid.getText();
         Date Order_placed_date = Date.valueOf(LocalDate.now());
         Date order_hand_over_date = Date.valueOf(LocalDate.now());
         String status = lblstatus.getText();
         String description = lbldescription.getText();


        var order = new Order(order_id, customer_id , Order_placed_date , order_hand_over_date , status , description);

        List<OrderDetail> odList = new ArrayList<>();

        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            CartTm tm = obList.get(i);

            OrderDetail od = new OrderDetail(
                    order_id,
                    tm.getProduct_id(),
                    tm.getQty()
            );

            odList.add(od);
        }

        PlaceOrder po = new PlaceOrder(order, odList);
        try {
            boolean isPlaced = PlaceOrderRepo.placeOrder(po);
            if(isPlaced) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Order Placed Unsuccessfully!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void cmbCustomerIdOnAction(ActionEvent event) {
        String id = (String) cmbcustomerid.getValue();

        try {
            Customer customer = CustomerRepo.searchById(id);

            lblcustomername.setText(customer.getName());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbProductIdOnAction(ActionEvent event) {
        String productid = lblproductid.getText();

        Product product = ProductRepo.searchById(String.valueOf(productid));
        if(product != null) {
            lbldescription.setText(product.getDescription());
            lblunitprice.setText(String.valueOf(product.getUnit_price()));
            lblqtyonhand.setText(String.valueOf(product.getProduct_qty_on_hand()));
        }

        txtqty.requestFocus();

    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {

    }

}
