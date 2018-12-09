package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Util {
    private String databaseName = "GameStore";
    private String userName = "emidiant";
    private String pass = "tata1969";
    private String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=%1$s;user=%2$s;password=%3$s;";
    private String connectionString = String.format(connectionUrl, /*instanceName,*/ databaseName, userName, pass);
    public Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionString);
            //Statement stmt = connection.createStatement();
            //ResultSet executeQuery = stmt.executeQuery("SELECT * FROM [Game]");
            // Обход результатов выборки
            //while (executeQuery.next()) {
            //    System.out.println(executeQuery.getString("Name")+" " +executeQuery.getDouble("Cost"));
            //}
            //executeQuery.close();
            //stmt.close();
            //connection.close();
            System.out.println("Connection OK");
        } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Connection Error");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection Error");
        }
        return connection;
    }
}
