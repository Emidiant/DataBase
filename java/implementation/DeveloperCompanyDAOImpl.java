package implementation;

import connect.Util;
import dao.DeveloperCompanyDAO;
import entity.DeveloperCompany;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperCompanyDAOImpl extends Util implements DeveloperCompanyDAO {

    Connection connection = getConnection();

    public void add(DeveloperCompany developerCompany) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Insert into [Developer company] (Country, Name) values (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, developerCompany.getCountry());
            preparedStatement.setString(2, developerCompany.getName());

            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }
    }

    public List<DeveloperCompany> getAll() throws SQLException {
        List<DeveloperCompany> developerCompanyList = new ArrayList<DeveloperCompany>();

        String sql = String.format("Select [id Developer company], [Country], [Name] from [Developer Company]");

        Statement statement = null;

        try{
            statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                DeveloperCompany developerCompany = new DeveloperCompany();
                 developerCompany.setIdDeveloperCompany(resultSet.getInt("id Developer company"));
                 developerCompany.setCountry(resultSet.getString("Country"));
                 developerCompany.setName(resultSet.getString("Name"));

                 developerCompanyList.add(developerCompany);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return developerCompanyList;
    }

    public DeveloperCompany getById(int idDeveloperCompany) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql = String.format("Select [Country], [Name] from [Developer Company] where [id Developer company]") + "=?";
        DeveloperCompany developerCompany = new DeveloperCompany();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idDeveloperCompany);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                developerCompany.setCountry(resultSet.getString("Country"));
                developerCompany.setName(resultSet.getString("Name"));
            }

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
        return developerCompany;
    }

    public void update(DeveloperCompany developerCompany) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE [Developer copmany] SET Country=?, [NAME]=? where [id Developer company]=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, developerCompany.getCountry());
            preparedStatement.setString(2, developerCompany.getName());
            preparedStatement.setInt(3, developerCompany.getIdDeveloperCompany());

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

    public void remove(DeveloperCompany developerCompany) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE from [Developer company] where [id Geveloper compny]=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, developerCompany.getIdDeveloperCompany());

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
}
