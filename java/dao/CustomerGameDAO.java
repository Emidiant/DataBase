package dao;

import entity.Customer;
import entity.CustomerGame;

import java.sql.SQLException;
import java.util.List;

public interface CustomerGameDAO {

    //create
    void add(CustomerGame customerGame) throws SQLException;

    //read
    List<CustomerGame> getAll() throws SQLException;

    CustomerGame getByGameIdAndCustomerId(int idGame, int idCustomer) throws SQLException;

    //update если покупатель передаривает игру
    void update(CustomerGame customerGame, Customer newCustomer) throws SQLException;

    //delete
    void remove(CustomerGame customerGame) throws SQLException;
}
