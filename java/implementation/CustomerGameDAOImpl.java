package implementation;

import connect.Util;
import dao.CustomerGameDAO;
import entity.Customer;
import entity.CustomerGame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerGameDAOImpl extends Util implements CustomerGameDAO {

    Connection connection = getConnection();

    public void add(CustomerGame customerGame) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO [Customer Game] ([id Customer], [id Game]) VAlUES(?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, customerGame.getIdCustomer());
            preparedStatement.setInt(2, customerGame.getIdGame());

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

    public List<CustomerGame> getAll() throws SQLException {
        List<CustomerGame> customerGamesList = new ArrayList<CustomerGame>();

        String sql = "Select [id Customer], [id Game] from [Customer Game]";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                CustomerGame customer = new CustomerGame();
                customer.setIdCustomer(resultSet.getInt("[id Customer]"));
                customer.setIdGame(resultSet.getInt("[id Game]"));

                customerGamesList.add(customer);
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

        return customerGamesList;
    }

    public CustomerGame getByGameIdAndCustomerId(int idGame, int idCustomer) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Select [id Customer], [id Game] from [Customer Game] where [id Customer]=? and [id Game]=?";

        CustomerGame customerGame = new CustomerGame();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCustomer);
            preparedStatement.setInt(2, idGame);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                customerGame.setIdCustomer(resultSet.getInt("[id Customer]"));
                customerGame.setIdGame(resultSet.getInt("[id Game]"));
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

        return customerGame;
    }

    public void update(CustomerGame customerGame, Customer newCustomer) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Update [Customer Game] set [id Customer]=?, [id Game]=? where [id Game]=?, [id Customer]=?";


        try {
            //customerGame.setIdGame(newCustomer.getIdCustomer());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newCustomer.getIdCustomer());
            preparedStatement.setInt(2, newCustomer.getIdCustomer());
            preparedStatement.setInt(3, customerGame.getIdGame());
            preparedStatement.setInt(4, customerGame.getIdCustomer());

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

    public void remove(CustomerGame customerGame) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Delete from [Customer Game] where [id Game]=? and [id Customer]=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, customerGame.getIdGame());
            preparedStatement.setLong(2, customerGame.getIdCustomer());

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
