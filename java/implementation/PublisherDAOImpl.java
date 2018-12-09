package implementation;

import connect.Util;
import dao.PublisherDAO;
import entity.Publisher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAOImpl extends Util implements PublisherDAO {

    Connection connection = getConnection();

    public void add(Publisher publisher) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Insert into Publisher (Country, Name) values (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, publisher.getCountry());
            preparedStatement.setString(2, publisher.getName());

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

    public List<Publisher> getAll() throws SQLException {
        List<Publisher> publisherList = new ArrayList<Publisher>();

        String sql = String.format("Select [id Publisher], [Country], [Name] from [Publisher]");

        Statement statement = null;

        try{
            statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Publisher publisher = new Publisher();
                publisher.setIdPublisher(resultSet.getInt("id Publisher"));
                publisher.setCountry(resultSet.getString("Country"));
                publisher.setName(resultSet.getString("Name"));

                publisherList.add(publisher);
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
        return publisherList;
    }

    public Publisher getById(int idPublisher) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql = String.format("Select [Country], [Name] from [Publisher] where [id Publisher]") + "=?";
        Publisher publisher = new Publisher();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPublisher);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                publisher.setCountry(resultSet.getString("Country"));
                publisher.setName(resultSet.getString("Name"));
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
        return publisher;
    }

    public void update(Publisher publisher) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE Publisher SET Country=?, [Name]=? where [id Publisher]=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, publisher.getCountry());
            preparedStatement.setString(2, publisher.getName());
            preparedStatement.setInt(3, publisher.getIdPublisher());

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

    public void remove(Publisher publisher) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE from Publisher where [id Publisher]=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, publisher.getIdPublisher());

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
