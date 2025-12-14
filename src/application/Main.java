package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setScene(new Scene(
            FXMLLoader.load(
                getClass().getResource("/views/login.fxml")
            ),
            300,
            250
        ));

        stage.setTitle("ITMD 510 Final Project");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
