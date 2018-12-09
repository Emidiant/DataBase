package dao;

import entity.GenreGame;

import java.sql.SQLException;
import java.util.List;

public interface GenreGameDAO {

    //create
    void add(GenreGame genreGame) throws SQLException;

    //read
    List<GenreGame> getAll() throws SQLException;

    GenreGame getByGenreIdAndGameId(int idGenre, int idGame) throws SQLException;

    //update
    void update(GenreGame genreGame, GenreGame newGenreGame) throws SQLException;

    //delete
    void remove(GenreGame genreGame) throws SQLException;
}
