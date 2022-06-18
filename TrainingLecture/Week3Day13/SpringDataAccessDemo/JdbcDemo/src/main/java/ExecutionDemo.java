import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecutionDemo {

    // JDBC configuration
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://beaconfiretraining.cvjh8ezt6tlh.us-east-1.rds.amazonaws.com/JavaBackendTraining";
    static final String USER = "admin";
    static final String PASSWORD = "Beaconfire#2022";


    public static void main (String[] args) {

        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = conn.createStatement();

            // execute
            // returns true if ResultSet is available
            // returns false otherwise
            String insertQuery = "insert into trainee (firstName, lastName, phoneNumber, ssn) value ('Burger', 'King', '3217659870', '321765987')";
            String reterieveQuery = "select * from trainer";
            String emptyResultSetQuery = "select * from trainer where firstName = 'lan' ";

//            System.out.println(statement.execute(insertQuery));
//            System.out.println(statement.execute(reterieveQuery));
//            System.out.println(statement.execute(emptyResultSetQuery));

            // executeUpdate
            // returns the number of rows affected by the given query
            // returns 0 for DDL statement
			String updateQuery = "update trainee set ssn = '000000000' where firstName = 'Papa' and lastName = 'John'";
			String nonAffectiveUpdateQuery = "update trainee set ssn = '000000001' where firstName = 'does not exist'";

			System.out.println(statement.executeUpdate(updateQuery));
			System.out.println(statement.executeUpdate(nonAffectiveUpdateQuery));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }


}
