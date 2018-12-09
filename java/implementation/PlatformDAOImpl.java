package implementation;

import connect.Util;
import dao.PlatformDAO;
import entity.Platform;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlatformDAOImpl extends Util implements PlatformDAO {

    Connection connection = getConnection();

    public void add(Platform platform) throws SQLException{
        PreparedStatement preparedStatement = null;

        String sql = "Insert into Platform (Name) values (?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, platform.getName());

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

    public List<Platform> getAll() throws SQLException {
        List<Platform> platformList = new ArrayList<Platform>();

        String sql = String.format("Select [id Platform], [Name] from Platform");

        Statement statement = null;

        try{
            statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Platform platform = new Platform();
                platform.setIdPlatform(resultSet.getInt("id Platform"));
                platform.setName(resultSet.getString("Name"));

                platformList.add(platform);
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
        return platformList;
    }

    public Platform getById(int idPlatform) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql = String.format("Select [id Platform], [Name] from Platform where [id Platform]") + "=?";
        Platform platform = new Platform();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPlatform);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                platform.setIdPlatform(resultSet.getInt("id Platform"));
                platform.setName(resultSet.getString("Name"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }
        return platform;
    }

    public void update(Platform platform) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE Platform set Name=? where [id Platform]=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, platform.getName());
            preparedStatement.setInt(2, platform.getIdPlatform());

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

    public void remove(Platform platform) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE from Platform where [id Platform]=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, platform.getIdPlatform());

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

//    public void closeMetod(PreparedStatement preparedStatement) throws SQLException {
//        if (preparedStatement != null){
//            preparedStatement.close();
//        }
//        if (connection != null){
//            connection.close();
//        }
//    }
}
