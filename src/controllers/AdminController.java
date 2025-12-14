package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.TransactionDAO;

public class AdminController {

    @FXML private Label message;

    @FXML
    public void update() {
        TransactionDAO.updateFirst();
        message.setText("First record updated");
    }

    @FXML
    public void delete() {
        TransactionDAO.deleteLast();
        message.setText("Last record deleted");
    }
}
