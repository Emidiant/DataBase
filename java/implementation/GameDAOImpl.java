package implementation;

import connect.Util;
import dao.GameDAO;
import entity.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAOImpl extends Util implements GameDAO {

    Connection connection = getConnection();

    public void add(Game game) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO GAME ([id Developer company], [id Platform], [id Publisher]," +
                "[Name], [Metacritic], [Multiplayer], [PEGI], [Cost], [User Rating], [Release date])" +
                " VAlUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, game.getIdDeveloperCompany());
            preparedStatement.setInt(2, game.getIdPlatform());
            preparedStatement.setInt(3, game.getIdPublisher());
            preparedStatement.setString(4, game.getName());
            preparedStatement.setInt(5, game.getMetacritic());
            preparedStatement.setByte(6, game.getMultiplayer());
            preparedStatement.setInt(7, game.getPegi());
            preparedStatement.setInt(8, game.getCost());
            preparedStatement.setInt(9, game.getUserRating());
            preparedStatement.setDate(10, game.getReleaseDate());

            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

    }


    public List<Game> getAll() throws SQLException {
        List<Game> gamesList = new ArrayList<Game>();

        String sql = String.format("Select [id Game], [id Developer company], [id Platform], [id Publisher], " +
                "Name, Metacritic, Multiplayer, PEGI, [User Rating], Cost, [Release date] from Game");

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Game game = new Game();
                game.setIdGame(resultSet.getInt("id Game"));
                game.setIdDeveloperCompany(resultSet.getInt("id Developer company"));
                game.setIdPlatform(resultSet.getInt("id Platform"));
                game.setIdPublisher(resultSet.getInt("id Publisher"));
                game.setName(resultSet.getString("Name"));
                game.setMultiplayer(resultSet.getByte("Multiplayer"));
                game.setPegi(resultSet.getInt("PEGI"));
                game.setCost(resultSet.getInt("Cost"));
                game.setUserRating(resultSet.getInt("User Rating"));
                game.setReleaseDate(resultSet.getDate("Release date"));

                gamesList.add(game);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

        return gamesList;
    }

    public Game getById(int idGame) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = String.format("Select [id Game], [id Developer company], [id Platform], [id Publisher], " +
                "[Name], [Metacritic], [Multiplayer], [PEGI], [Cost], [User Rating], [Release date] " +
                "from Game where [id Game]") + "=?";


        Game game = new Game();
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idGame);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                game.setIdGame(resultSet.getInt("id Game"));
                game.setIdDeveloperCompany(resultSet.getInt("id Developer company"));
                game.setIdPlatform(resultSet.getInt("id Platform"));
                game.setIdPublisher(resultSet.getInt("id Publisher"));
                game.setName(resultSet.getString("Name"));
                game.setMetacritic(resultSet.getInt("Metacritic"));
                game.setMultiplayer(resultSet.getByte("Multiplayer"));
                game.setPegi(resultSet.getInt("PEGI"));
                game.setCost(resultSet.getInt("Cost"));
                game.setUserRating(resultSet.getInt("User Rating"));
                game.setReleaseDate(resultSet.getDate("Release date"));
            }

            //preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

        return game;
    }

    public void update(Game game) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Update Game set [id Developer company]=?, [id Platform]=?, " +
                "[id Publisher]=?, [Name]=?, [Metacritic]=?, [Multiplayer]=?, [PEGI]=?, [Cost]=?, [User Rating]=?," +
                " [Release date]=? where [id Game]=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, game.getIdDeveloperCompany());
            preparedStatement.setInt(2, game.getIdPlatform());
            preparedStatement.setInt(3, game.getIdPublisher());
            preparedStatement.setString(4, game.getName());
            preparedStatement.setInt(5, game.getMetacritic());
            preparedStatement.setByte(6, game.getMultiplayer());
            preparedStatement.setInt(7, game.getPegi());
            preparedStatement.setInt(8, game.getCost());
            preparedStatement.setInt(9, game.getUserRating());
            preparedStatement.setDate(10, game.getReleaseDate());
            preparedStatement.setInt(11, game.getIdGame());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    public void remove(Game game) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Delete from Game where [id Game]=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, game.getIdGame());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }


    }
}
