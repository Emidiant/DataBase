package UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class AboutController {

    @FXML
    private Button returnStore;

    private Stage stage;

    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    void initialize() {
        System.out.println("about controller");

        returnStore.setOnAction(event -> {
            stage.close();
        });

    }


}
