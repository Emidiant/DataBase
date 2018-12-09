package dao;

import entity.Platform;

import java.sql.SQLException;
import java.util.List;

public interface PlatformDAO {

    //create
    void add(Platform platform) throws SQLException;

    //read
    List<Platform> getAll() throws SQLException;

    Platform getById(int idPlatform) throws SQLException;

    //update
    void update(Platform platform) throws SQLException;

    //delete
    void remove(Platform platform) throws SQLException;
}
