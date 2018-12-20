package UI;

import entity.Game;
import entity.GameViewTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import service.CustomerService;
import service.GameService;

import java.io.IOException;
import java.sql.Date;

public class LibraryController {
    @FXML
    private TableView<GameViewTable> gamesTable;

    @FXML
    private TableColumn<GameViewTable, Integer> ratingColumn;

    @FXML
    private TableColumn<GameViewTable, Integer> pegiColumn;

    @FXML
    private TableColumn<GameViewTable, Integer> costColumn;

    @FXML
    private TableColumn<GameViewTable, String> nameColumn;

    @FXML
    private TableColumn<GameViewTable, String> multiColumn;

    @FXML
    private TableColumn<GameViewTable, String> developerColumn;

    @FXML
    private TableColumn<GameViewTable, Integer> metaColumn;

    @FXML
    private TableColumn<GameViewTable, String> platformColumn;

    @FXML
    private TableColumn<GameViewTable, Date> releaseDateColumn;

    @FXML
    private TableColumn<GameViewTable, String> publisherColumn;

    @FXML
    private TableView<GameViewTable> gamesTable2;

    @FXML
    private TableColumn<GameViewTable, String> nameColumn2;

    @FXML
    private TableColumn<GameViewTable, String> developerColumn2;

    @FXML
    private TableColumn<GameViewTable, Integer> metaColumn2;

    @FXML
    private TableColumn<GameViewTable, String> publisherColumn2;

    @FXML
    private TableColumn<GameViewTable, Button> add;

    private FXMLLoader loader;

    @FXML
    private MenuItem exitToFirstPage;

    @FXML
    private MenuItem exitToDeskButtton;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Button look;

    private int idCustomer;

    @FXML
    private Tab library;

    @FXML
    private Tab store;

    Stage prevStage;

    @FXML
    private PieChart pie;

    @FXML
    private Label textStart;

    public void setStage(Stage stage){
        this.prevStage = stage;
    }


    public void setIdCustomer(int id){
        this.idCustomer = id;
    }


    public void initialize(){

        GameService gameService = new GameService();
        Game game = gameService.popularGame();


        textStart.setText(game.getName());
        store.setOnSelectionChanged(event -> {
            createTabStore();
        });

        library.setOnSelectionChanged(event -> {
            createTabLibrary();
        });
    }




    @FXML
    void exitToDesktop(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void changeAccount(ActionEvent event) {
        loader = new FXMLLoader(getClass().getResource("/fxml/hello.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.getIcons().add(new Image("/image/gamecontroller.png"));
        stage.setTitle(" Start page");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void aboutView(ActionEvent event){
        loader = new FXMLLoader(getClass().getResource("/fxml/about.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        AboutController aboutController = loader.getController();
        aboutController.setStage(stage);
        stage.getIcons().add(new Image("/image/gamecontroller.png"));
        stage.setTitle(" About");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void createTabStore(){

        ObservableList<GameViewTable> gamesList;

        GameService gameService = new GameService();

        gamesList = gameService.viewGames(idCustomer);


        nameColumn.setCellValueFactory(new PropertyValueFactory<GameViewTable, String>("Name"));
        costColumn.setCellValueFactory(new PropertyValueFactory<GameViewTable, Integer>("Cost"));
        platformColumn.setCellValueFactory(new PropertyValueFactory<GameViewTable, String>("Platform"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<GameViewTable, Integer>("UserRating"));
        metaColumn.setCellValueFactory(new PropertyValueFactory<GameViewTable, Integer>("Metacritic"));
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<GameViewTable, Date>("ReleaseDate"));
        multiColumn.setCellValueFactory(new PropertyValueFactory<GameViewTable, String>("Multiplayer"));
        pegiColumn.setCellValueFactory(new PropertyValueFactory<GameViewTable, Integer>("pegi"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<GameViewTable, String>("Publisher"));
        developerColumn.setCellValueFactory(new PropertyValueFactory<GameViewTable, String>("DeveloperCompany"));
        add.setCellValueFactory(new PropertyValueFactory<GameViewTable, Button>("button"));

        gamesTable.rowFactoryProperty();
        gamesTable.setItems(gamesList);
    }


    public void createTabLibrary() {
        ObservableList<GameViewTable> gamesList;
        GameService gameService = new GameService();


        gamesList = gameService.libraryTable(this.idCustomer);
        pie.setData(gameService.pieChartCreate());


        nameColumn2.setCellValueFactory(new PropertyValueFactory<GameViewTable, String>("Name"));
        metaColumn2.setCellValueFactory(new PropertyValueFactory<GameViewTable, Integer>("Metacritic"));
        publisherColumn2.setCellValueFactory(new PropertyValueFactory<GameViewTable, String>("Publisher"));
        developerColumn2.setCellValueFactory(new PropertyValueFactory<GameViewTable, String>("DeveloperCompany"));
        // заполняем таблицу данными

        gamesTable2.setItems(gamesList);
    }

}
