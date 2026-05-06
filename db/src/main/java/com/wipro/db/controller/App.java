import java.sql.*;
public class App {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "mydbuser", "mydbuser"
            );
            // Create statement
            Statement statement = connection.createStatement();
            // Execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM designation");
            // Process results
            while (resultSet.next()) {
                int code = resultSet.getInt("code");
                String title = resultSet.getString("title").trim();
                System.out.println("Code: " + code + " | Title: " + title);
            }
            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}