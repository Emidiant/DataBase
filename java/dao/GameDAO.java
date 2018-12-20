package dao;


import entity.Customer;
import entity.Game;

import java.sql.SQLException;
import java.util.List;

public interface GameDAO {

    //create
    void add(Game game) throws SQLException;

    List<Game> viewLibraryOfCustomer(int idCustomer) throws SQLException;

    //read
    List<Game> getAll() throws SQLException;

    Game getById(int idGame) throws SQLException;

    //update
    void update(Game game) throws SQLException;

    //delete
    void remove(Game game) throws SQLException;

    Game mostPopular() throws SQLException;
}
