import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://beaconfiretraining.cvjh8ezt6tlh.us-east-1.rds.amazonaws.com/JavaBackendTraining";
    static final String USER = "admin";
    static final String PASSWORD = "Beaconfire#2022";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            System.out.println("Loading JDBC Driver ...");
            Class.forName(JDBC_DRIVER);
            System.out.println("JDBC Driver loaded.");

            System.out.println("Establishing Connection ...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection Established");

            System.out.println(connection.getMetaData().getUserName());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
