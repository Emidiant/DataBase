package dao;

import entity.Publisher;

import java.sql.SQLException;
import java.util.List;

public interface PublisherDAO {

    //create
    void add(Publisher publisher) throws SQLException;

    //read
    List<Publisher> getAll() throws SQLException;

    Publisher getById(int idPublisher) throws SQLException;

    //update
    void update(Publisher publisher) throws SQLException;

    //delete
    void remove(Publisher publisher) throws SQLException;
}
