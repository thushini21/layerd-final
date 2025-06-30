package lk.ijse.HelankaShoeMarket.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.HelankaShoeMarket.Repository.CustomerRepo;
import lk.ijse.HelankaShoeMarket.Repository.SupplierRepo;
import lk.ijse.HelankaShoeMarket.model.Supplier;

import java.sql.SQLException;

public class SupplierFormDController {

    @FXML
    private JFXButton btnclear;

    @FXML
    private JFXButton btndelete;

    @FXML
    private JFXButton btnsave;

    @FXML
    private JFXButton btnupdate;

    @FXML
    private TextField txtSupplierId;

    @FXML
    private TextField txtSupplierName;

    @FXML
    private TextField txtSuppplierAddress;

    @FXML
    private TextField txtTel;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtSupplierId.setText("");
        txtSupplierName.setText("");
        txtSuppplierAddress.setText("");
        txtTel.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtSupplierId.getText();

        try {
            boolean isDeleted = SupplierRepo.delete(id);
            if(isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "suppplier deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtSupplierId.getText();
        String name = txtSupplierName.getText();
        String address = txtSuppplierAddress.getText();
        String phone = txtTel.getText();

        Supplier supplier = new Supplier(id, name, address, phone);

        try {
            boolean isSaved = SupplierRepo.save(supplier);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtSupplierId.getText();
        String name = txtSupplierName.getText();
        String address = txtSuppplierAddress.getText();
        String phone = txtTel.getText();

        Supplier supplier = new Supplier(id, name, address, phone);

        try {
            boolean isUpdated = SupplierRepo.update(supplier);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "supplier updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
