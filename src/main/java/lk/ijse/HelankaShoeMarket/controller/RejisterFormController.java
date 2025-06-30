package lk.ijse.HelankaShoeMarket.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.HelankaShoeMarket.DB.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RejisterFormController {

    @FXML
    private AnchorPane RegisterPane;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) this.RegisterPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.centerOnScreen();

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        String userId = txtUser.getText();
        String password = txtPassword.getText();
        String pw = txtConfirmPassword.getText();

        try {
            boolean isSaved = saveUser(userId, password, pw);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "user saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private boolean saveUser(String userId, String password, String pw) throws SQLException {
        String sql = "INSERT INTO user VALUES(?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, userId);
        pstm.setObject(2, password);
        pstm.setObject(3, pw);

        return pstm.executeUpdate() > 0;
    }

        @FXML
    void txtGoToConfirmPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtGoToNewPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtRegisterOnAction(ActionEvent event) {

    }

}
