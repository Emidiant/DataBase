package implementation;

import connect.Util;
import dao.GenreGameDAO;
import entity.GenreGame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreGameDAOImpl extends Util implements GenreGameDAO {

    Connection connection = getConnection();

    public void add(GenreGame genreGame) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO [Genre Game] ([id Game], [id Genre])  VAlUES(?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, genreGame.getIdGame());
            preparedStatement.setInt(2, genreGame.getIdGenre());

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

    public List<GenreGame> getAll() throws SQLException {
        List<GenreGame> genreGameList = new ArrayList<GenreGame>();

        String sql = "Select [id Genre], [id Game] from [Genre Game]";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                GenreGame genreGame = new GenreGame();
                genreGame.setIdGenre(resultSet.getInt("[id Genre]"));
                genreGame.setIdGame(resultSet.getInt("[id Game]"));

                genreGameList.add(genreGame);
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

        return genreGameList;
    }

    public GenreGame getByGenreIdAndGameId(int idGenre, int idGame) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Select [id Genre], [id Game] from [Genre Game] where [id Genre]=? and [id Game]=?";

        GenreGame genreGame = new GenreGame();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idGenre);
            preparedStatement.setInt(2, idGame);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                genreGame.setIdGenre(resultSet.getInt("[id Genre]"));
                genreGame.setIdGame(resultSet.getInt("[id Game]"));
            }
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

        return genreGame;
    }

    public void update(GenreGame genreGame, GenreGame newGenreGame) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Update [Genre Game] set [id Genre]=?, [id Game]=? where [id Game]=?, [id Genre]=?";


        try {
            //genreGame.setIdGame(newGenreGame.getIdGame());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newGenreGame.getIdGenre());
            preparedStatement.setInt(2, newGenreGame.getIdGame());
            preparedStatement.setInt(3, genreGame.getIdGame());
            preparedStatement.setInt(4, genreGame.getIdGenre());

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

    public void remove(GenreGame genreGame) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Delete from [Genre Game] where [id Game]=? and [id Genre]=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, genreGame.getIdGame());
            preparedStatement.setLong(2, genreGame.getIdGenre());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
