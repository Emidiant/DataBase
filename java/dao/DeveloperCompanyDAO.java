package dao;

import entity.DeveloperCompany;

import java.sql.SQLException;
import java.util.List;

public interface DeveloperCompanyDAO {

    //create
    void add(DeveloperCompany developerCompany) throws SQLException;

    //read
    List<DeveloperCompany> getAll() throws SQLException;

    DeveloperCompany getById(int idDeveloperCompany) throws SQLException;

    //update
    void update(DeveloperCompany developerCompany) throws SQLException;

    //delete
    void remove(DeveloperCompany developerCompany) throws SQLException;
}
