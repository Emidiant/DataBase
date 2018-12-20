package dao;

import entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    //create
    void add(Customer customer) throws SQLException;

    //read
    List<Customer> getAll() throws SQLException;

    Customer getById(int idCustomer) throws SQLException;

    Customer getByLoginAndPassword(String login, String password) throws SQLException;


    //запрещены триггером
    //update
    //void update(Customer customer) throws SQLException;

    //delete
    //void remove(Customer customer) throws SQLException;
}
