package UI;

import entity.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.CustomerService;

import java.io.IOException;

public class LogInController extends CustomerService {

    @FXML
    private Button buttonReturn;

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldPassword;

    @FXML
    private Button logInButton;

    private FXMLLoader loader;

    Stage prevStage;
    public void setStage(Stage stage){
        this.prevStage = stage;
    }

    @FXML
    public void initialize() {
        //TODO delete
        fieldEmail.setText("emidiant1999@gmail.com");
        fieldPassword.setText("tata");

        fieldPassword.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case ENTER:
                    if (userLogIn(fieldEmail.getText(), fieldPassword.getText()) == 1){

                        Stage stage = (Stage) fieldEmail.getScene().getWindow();
                        loader = new FXMLLoader(getClass().getResource("/fxml/libraryTable.fxml"));

                        try {
                            loader.load();
                        } catch (IOException ex) {
                            System.out.println("Error");
                            ex.printStackTrace();
                        }

                        Parent root = loader.getRoot();
                        LibraryController libraryController = loader.getController();
                        libraryController.setStage(stage);

                        libraryController.setIdCustomer(getCustomerID());
                        stage.getIcons().add(new Image("/image/gamecontroller.png"));
                        stage.setTitle(" Store");
                        stage.setScene(new Scene(root));
                        prevStage.close();
                        stage.show();
                    }else{

                    }
                    break;
            }

        });
    }


    @FXML
    void returnToFirstPage(ActionEvent event) {

        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/fxml/hello.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("Error im LoginController");
            e.printStackTrace();
        }

        Parent root = (Parent) loader.getRoot();

        Stage stage = (Stage) buttonReturn.getScene().getWindow();
        stage.getIcons().add(new Image("/image/gamecontroller.png"));
        stage.setTitle(" Start page");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void signIn(ActionEvent event) throws IOException {
        if (userLogIn(fieldEmail.getText(), fieldPassword.getText()) == 1){

            loader = new FXMLLoader(getClass().getResource("/fxml/libraryTable.fxml"));

            loader.load();
            LibraryController libraryController = loader.getController();
            Stage stage = (Stage) logInButton.getScene().getWindow();
            stage.getIcons().add(new Image("/image/gamecontroller.png"));
            stage.setTitle(" Store");
            Parent root = (Parent) loader.getRoot();

            libraryController.setStage(stage);

            libraryController.setIdCustomer(getCustomerID());

            stage.setScene(new Scene(root, Color.rgb(
                    100,200,200
            )));
            prevStage.close();
            stage.show();
        }else{

        }
    }

}