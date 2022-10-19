package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static Connection connection;

    public static Connection getConnection(){
        try{
            if (connection == null) {
                String DB_URL = "jdbc:mysql://localhost:3300/flightreservation";
                String DB_USER = "root";
                String DB_PASSWORD = "Ycode@2021";
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            }
            return connection;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
