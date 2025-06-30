package lk.ijse.HelankaShoeMarket.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import lk.ijse.HelankaShoeMarket.Repository.CustomerRepo;
import lk.ijse.HelankaShoeMarket.model.Customer;


import java.sql.SQLException;

public class CustomerFormController {

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnsave;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colPoneNumber;

    @FXML
    private Label lblCustomerSaveOrNot;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblTotalCustomers;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnClearOnAction(ActionEvent event) {

        clearFields();
    }

    private void clearFields() {
        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        txtPhoneNumber.setText("");
        txtSearch.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtCustomerId.getText();

        try {
            boolean isDeleted = CustomerRepo.delete(id);
            if(isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtCustomerId.getText();
       String name = txtCustomerName.getText();
       String address = txtCustomerAddress.getText();
        String phone = txtPhoneNumber.getText();
        Customer customer = new Customer(id, name, address, phone);

       try {
        boolean isSaved = CustomerRepo.save(customer);
            if (isSaved) {
               new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();         clearFields();}
   } catch (SQLException e) {
          throw new RuntimeException(e);     }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtCustomerId.getText();
        String name = txtCustomerName.getText();
        String address = txtCustomerAddress.getText();
        String tel = txtPhoneNumber.getText();

        Customer customer = new Customer(id, name, address, tel);

        try {
            boolean isUpdated = CustomerRepo.update(customer);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void txtGoToAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtGoToPhoneNumberOnAction(ActionEvent event) {

    }

    @FXML
    void txtSaveOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchFilterOnAction(KeyEvent event) {

    }

}
