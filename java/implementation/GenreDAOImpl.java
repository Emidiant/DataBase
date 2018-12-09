package implementation;

import connect.Util;
import dao.GenreDAO;
import entity.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAOImpl extends Util implements GenreDAO {
    Connection connection = getConnection();

    public void add(Genre genre) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Insert into Genre (GenreName) values (?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, genre.getGenreName());

            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }
    }

    public List<Genre> getAll() throws SQLException {
        List<Genre> genreList = new ArrayList<Genre>();

        String sql = String.format("Select [id Genre], GenreName from Genre");

        Statement statement = null;

        try{
            statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Genre genre = new Genre();
                genre.setIdGenre(resultSet.getInt("id Genre"));
                genre.setGenreName(resultSet.getString("GenreName"));

                genreList.add(genre);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return genreList;
    }

    public Genre getById(int idGenre) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql = String.format("Select [id Genre], [GenreName] from Genre where [id Genre]") + "=?";
        Genre genre = new Genre();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idGenre);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                genre.setIdGenre(resultSet.getInt("id Genre"));
                genre.setGenreName(resultSet.getString("GenreName"));
            }

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
        return genre;
    }

    public void update(Genre genre) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE Genre set GenreName=? where [id Genre]=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, genre.getGenreName());
            preparedStatement.setInt(2, genre.getIdGenre());


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

    public void remove(Genre genre) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE from Genre where [id Genre]=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, genre.getIdGenre());

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
}
