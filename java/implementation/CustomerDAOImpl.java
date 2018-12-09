package implementation;

import connect.Util;
import dao.CustomerDAO;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl extends Util implements CustomerDAO{

    Connection connection = getConnection();


    public void add(Customer customer) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO Customer ([e-mail], [age], birthday, surname, firstname, middlename)" +
                " VAlUES(?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, customer.getEmail());
            preparedStatement.setInt(2, customer.getAge());
            preparedStatement.setDate(3, customer.getBirthday());
            preparedStatement.setString(4, customer.getSurname());
            preparedStatement.setString(5, customer.getFirstname());
            preparedStatement.setString(6, customer.getMiddlename());

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

    public List<Customer> getAll() throws SQLException {
        List<Customer> customerList = new ArrayList<Customer>();

        String sql = "Select [id Customer], [E-mail], [Age], Birthday, Surname, Firstname, Middlename from Customer";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setIdCustomer(resultSet.getInt("[id Customer]"));
                customer.setEmail(resultSet.getString("[E-mail]"));
                customer.setAge(resultSet.getInt("[Age]"));
                customer.setBirthday(resultSet.getDate("Birthday"));
                customer.setSurname(resultSet.getString("Surname"));
                customer.setFirstname(resultSet.getString("Firstname"));
                customer.setMiddlename(resultSet.getString("Middlename"));

                customerList.add(customer);
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

        return customerList;
    }

    public Customer getById(int idCustomer) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Select [id Customer], [E-mail], [Age], Birthday, Surname, Firstname, Middlename from Customer where id Customer=?";

        Customer customer = new Customer();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCustomer);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                customer.setIdCustomer(resultSet.getInt("[id Customer]"));
                customer.setEmail(resultSet.getString("[E-mail]"));
                customer.setAge(resultSet.getInt("[Age]"));
                customer.setBirthday(resultSet.getDate("Birthday"));
                customer.setSurname(resultSet.getString("Surname"));
                customer.setFirstname(resultSet.getString("Firstname"));
                customer.setMiddlename(resultSet.getString("Middlename"));
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

        return customer;
    }


    //запрещены триггером
    /*public void update(Customer customer) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Update Customer set E-mail=?, Age=?, Birthday=?, Surname=?, Firstname=?, Middlename=?" +
                " where id Customer=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, customer.getEmail());
            preparedStatement.setInt(2, customer.getAge());
            preparedStatement.setDate(3, customer.getBirthday());
            preparedStatement.setString(4, customer.getSurname());
            preparedStatement.setString(5, customer.getFirstname());
            preparedStatement.setString(6, customer.getMiddlename());

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

    }*/

   /* public void remove(Customer customer) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Delete from Customer where id Customer=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, customer.getIdCustomer());

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
    }*/
}
