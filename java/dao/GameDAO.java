package dao;


import entity.Game;

import java.sql.SQLException;
import java.util.List;

public interface GameDAO {

    //create
    void add(Game game) throws SQLException;

    //read
    List<Game> getAll() throws SQLException;

    Game getById(int idGame) throws SQLException;

    //update
    void update(Game game) throws SQLException;

    //delete
    void remove(Game game) throws SQLException;
}
