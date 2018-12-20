package UI;

import entity.Customer;
import implementation.CustomerDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import service.CustomerService;

import java.sql.Date;

public class RegistrationController extends CustomerService {

    @FXML
    private Button buttonReturn;

    @FXML
    private TextField userFirstname;

    @FXML
    private TextField userMiddlename;

    @FXML
    private TextField userEmail;

    @FXML
    private TextField userPassword;

    @FXML
    private Button buttonCreateAcc;

    @FXML
    private TextField userSurname;

    @FXML
    private DatePicker userBirthday;

    @FXML
    public void initialize() {

        System.out.println("User начал регистрацию");
    }

    @FXML
    void returnToFirstPage(ActionEvent event) {
        System.out.println("User прервал регистрацию");
        showNewWindow("/fxml/hello.fxml");
    }

    @FXML
    void createAcc(ActionEvent event) {
        Customer customer = new Customer();

        customer.setSurname(userSurname.getText());
        customer.setFirstname(userFirstname.getText());
        customer.setMiddlename(userMiddlename.getText());
        customer.setEmail(userEmail.getText());
        customer.setPassword(userPassword.getText());

        LocalDate localDate = userBirthday.getValue();
        Date date = Date.valueOf(localDate); // Magic happens here!
        customer.setBirthday(date);

        super.userRegistration(customer);

        showNewWindow("/fxml/hello.fxml");

    }

    private void showNewWindow(String string) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(string));

        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = (Stage) buttonReturn.getScene().getWindow();
        stage.getIcons().add(new Image("/image/gamecontroller.png"));
        stage.setTitle(" Start Page");
        stage.setScene(new Scene(root));
        stage.show();
    }
}