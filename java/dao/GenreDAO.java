package dao;

import entity.Genre;

import java.sql.SQLException;
import java.util.List;

public interface GenreDAO {
    //create
    void add(Genre genre) throws SQLException;

    //read
    List<Genre> getAll() throws SQLException;

    Genre getById(int idGenre) throws SQLException;

    //update
    void update(Genre genre) throws SQLException;

    //delete
    void remove(Genre genre) throws SQLException;
}
