package service;

import UI.LibraryController;
import dao.CustomerGameDAO;
import dao.DeveloperCompanyDAO;
import entity.*;
import implementation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameService {

    private List<Game> gameList;

    public Game popularGame(){
        GameDAOImpl gameDAO = new GameDAOImpl();
        Game game = null;
        try {
            game = gameDAO.mostPopular();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return game;
    }

    public ObservableList pieChartCreate(){

        int count = 0;
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        while (count < this.gameList.size()) {
            pieChartData.add(new PieChart.Data(this.gameList.get(count).getName(), this.gameList.get(count).getMetacritic()));
            count++;
        }
        return  pieChartData;
    }


    public ObservableList viewGames(int idCustomer){
        GameDAOImpl gameDAO = new GameDAOImpl();

        ObservableList<GameViewTable> gamesList = FXCollections.observableArrayList();

        Platform platform;
        Publisher publisher;
        DeveloperCompany developerCompany;

        int count = 0;
        try {
            this.gameList = gameDAO.getAll();

            while (count < gameList.size()) {
                Button button = new Button("Add");
                GameViewTable gameViewTable = new GameViewTable();

                PlatformDAOImpl platformDAO = new PlatformDAOImpl();
                platform = platformDAO.getById(gameList.get(count).getIdPlatform());
                gameViewTable.setPlatform(platform.getName());

                PublisherDAOImpl publisherDAO = new PublisherDAOImpl();
                publisher = publisherDAO.getById(gameList.get(count).getIdPublisher());
                gameViewTable.setPublisher(publisher.getName());

                DeveloperCompanyDAOImpl developerCompanyDAO = new DeveloperCompanyDAOImpl();
                developerCompany = developerCompanyDAO.getById(gameList.get(count).getIdDeveloperCompany());
                gameViewTable.setDeveloperCompany(developerCompany.getName());

                gameViewTable.setIdGame(gameList.get(count).getIdGame());
                gameViewTable.setName(gameList.get(count).getName());
                gameViewTable.setCost(gameList.get(count).getCost());
                gameViewTable.setMetacritic(gameList.get(count).getMetacritic());
                if (gameList.get(count).getMultiplayer() == 0){
                    gameViewTable.setMultiplayer("No");
                }else{
                    gameViewTable.setMultiplayer("Yes");
                }

                gameViewTable.setPegi(gameList.get(count).getPegi());
                gameViewTable.setReleaseDate(gameList.get(count).getReleaseDate());
                gameViewTable.setUserRating(gameList.get(count).getUserRating());
                gameViewTable.setButton(button);

                button.setOnAction(event -> {
                    CustomerGame customerGame = new CustomerGame();
                    customerGame.setIdGame(gameViewTable.getIdGame());
                    customerGame.setIdCustomer(idCustomer);

                    CustomerGameDAOImpl customerGameDAO2 = new CustomerGameDAOImpl();
                    int flag = 0;
                    try {
                        flag = customerGameDAO2.getByGameIdAndCustomerId(gameViewTable.getIdGame(), idCustomer);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    if(flag == 0){
                        System.out.println("игры нет в библиотеке пользователя");
                        CustomerGameDAOImpl customerGameDAO = new CustomerGameDAOImpl();
                        try {
                            customerGameDAO.add(customerGame);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }else{
                        System.out.println("у пользователя есть такая игра");
                    }

                });

                gamesList.add(count, gameViewTable);
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gamesList;
    }

    public ObservableList libraryTable(int idCustomer){
        GameDAOImpl gameDAO = new GameDAOImpl();

        Publisher publisher;
        DeveloperCompany developerCompany;

        ObservableList<GameViewTable> gamesList = FXCollections.observableArrayList();

        int count = 0;
        try {
            gameList = gameDAO.viewLibraryOfCustomer(idCustomer);

            while (count < gameList.size()) {
                GameViewTable gameViewTable = new GameViewTable();

                PublisherDAOImpl publisherDAO = new PublisherDAOImpl();
                publisher = publisherDAO.getById(gameList.get(count).getIdPublisher());
                gameViewTable.setPublisher(publisher.getName());

                DeveloperCompanyDAOImpl developerCompanyDAO = new DeveloperCompanyDAOImpl();
                developerCompany = developerCompanyDAO.getById(gameList.get(count).getIdDeveloperCompany());
                gameViewTable.setDeveloperCompany(developerCompany.getName());

                gameViewTable.setName(gameList.get(count).getName());
                gameViewTable.setMetacritic(gameList.get(count).getMetacritic());


                gamesList.add(count, gameViewTable);
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return gamesList;
    }

}
