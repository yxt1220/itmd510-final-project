package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.TransactionDAO;

public class UserController {

    @FXML
    private TextField amount;

    @FXML
    private Label message;

    @FXML
    public void addTransaction() {

        try {
            double value = Double.parseDouble(amount.getText());

            String type;
            if (value < 0) {
                type = "WITHDRAW";
            } else {
                type = "DEPOSIT";
            }

            TransactionDAO.addTransaction(1, value, type);

            message.setText("Transaction added: " + type);

            amount.clear();

        } catch (NumberFormatException e) {
            message.setText("Please enter a valid number");
        }
    }
}

