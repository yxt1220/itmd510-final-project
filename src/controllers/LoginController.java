package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;
import models.UserDAO;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label message;

    @FXML
    public void login() {

        User user = UserDAO.login(
                username.getText(),
                password.getText()
        );

        if (user == null) {
            message.setText("Login failed");
            return;
        }

        try {
            Stage stage = (Stage) username.getScene().getWindow();

            if (user.getRole().equalsIgnoreCase("ADMIN")) {

                Scene adminScene = new Scene(
                        FXMLLoader.load(
                                getClass().getResource("/views/admin.fxml")
                        ),
                        300,
                        250
                );
                stage.setScene(adminScene);

            } else {

                Scene userScene = new Scene(
                        FXMLLoader.load(
                                getClass().getResource("/views/user.fxml")
                        ),
                        300,
                        250
                );
                stage.setScene(userScene);
            }

        } catch (Exception e) {
            e.printStackTrace();
            message.setText("Error loading page");
        }
    }
}

