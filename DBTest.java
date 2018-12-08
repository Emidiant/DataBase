import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBTest {
    public static void main(String[] args){
        // Формирование строки подключения
        String databaseName = "GameStore";
        String userName = "emidiant";
        String pass = "tata1969";
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=%1$s;user=%2$s;password=%3$s;";
        String connectionString = String.format(connectionUrl, /*instanceName,*/ databaseName, userName, pass);
        //TODO вынести в отдельный слой и возвращать Connection
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Подключение к базе данных
            Connection con = DriverManager.getConnection(connectionString);
            // Отправка запроса на выборку и получение результатов
            Statement stmt = con.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM [Game]");
            // Обход результатов выборки
            while (executeQuery.next()) {
                System.out.println(executeQuery.getString("Name")+" " +executeQuery.getDouble("Cost"));
            }
            // Закрываем соединение
            executeQuery.close();
            stmt.close();
            con.close();
        } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Error");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
