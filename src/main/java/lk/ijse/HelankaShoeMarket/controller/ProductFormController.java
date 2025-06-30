package lk.ijse.HelankaShoeMarket.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.HelankaShoeMarket.Repository.CustomerRepo;
import lk.ijse.HelankaShoeMarket.Repository.ProductRepo;
import lk.ijse.HelankaShoeMarket.model.Customer;
import lk.ijse.HelankaShoeMarket.model.Product;

import java.sql.SQLException;

public class ProductFormController {

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private TextField txtProductId;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TextField txtdesign;

    @FXML
    private TextField txtdescription;

    @FXML
    private TextField txtmaterialid;


    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtProductId.setText("");
        txtQty.setText("");
        txtUnitPrice.setText("");
        txtdescription.setText("");
        txtdesign.setText("");
        txtmaterialid.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException {
        String id = txtProductId.getText();

        boolean isDeleted = ProductRepo.delete(id);
        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "product deleted!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException {

        String id = txtProductId.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        String design = txtdesign.getText();
        String description = txtdescription.getText();
        String material = txtmaterialid.getText();


        Product product = new Product(id, qty, unitPrice, design, description, material);

        {
            boolean isSaved = ProductRepo.save(product);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "product  saved!").show();
                clearFields();
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {

        String id = txtProductId.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double unitprice = Double.parseDouble(txtUnitPrice.getText());
        String design = txtdesign.getText();
        String description  = txtdescription.getText();
        String materialid  = txtmaterialid.getText();



        Product product = new Product(id, qty, unitprice, design,description ,materialid);

        boolean isUpdated = ProductRepo.update(product);
        if(isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "product updated!").show();
        }
    }

}
