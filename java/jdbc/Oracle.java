import java.sql.*;

public class Oracle {


public static void main(String[] args) {

Connection connection = null;
try {
    // Load the JDBC driver
    String driverName = "oracle.jdbc.driver.OracleDriver";
    Class.forName(driverName);

    // Create a connection to the database
    String serverName = "desktop30";
    String portNumber = "1521";
    String sid = "orcl";
    String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
    System.out.println(url);
    String username = "hello";
    String password = "cchou1200";
    connection = DriverManager.getConnection(url, username, password);
} catch (ClassNotFoundException e) {
    System.err.println(e.getMessage());
} catch (SQLException e) {
    System.err.println(e.getMessage());
}
} 

}
