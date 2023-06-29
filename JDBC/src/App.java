import java.sql.*;

public class App {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load the JDBC driver
            Class.forName("your.jdbc.driver.ClassName");

            // Establish a connection
            connection = DriverManager.getConnection("your-database-url", "your-username", "your-password");

            // Perform database operations
            // ...
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
