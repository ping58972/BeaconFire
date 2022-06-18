import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

    // JDBC configuration
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://beaconfiretraining.cvjh8ezt6tlh.us-east-1.rds.amazonaws.com/JavaBackendTraining";
    static final String USER = "admin";
    static final String PASSWORD = "Beaconfire#2022";

    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = conn.createStatement();

            conn.setAutoCommit(false);

            transferIntoOliver(statement);
            transferOutOfTracy(statement);

            conn.commit();

        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        catch (RuntimeException e) {
            try {
                System.out.println("rolling back ...");
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally {
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

    public static void transferOutOfTracy(Statement statement) {
        throw new RuntimeException();
    }

    public static void transferIntoOliver(Statement statement) throws SQLException {
        String query = "update Bank set balance = 50 where accountName = 'Oliver'";
        statement.executeUpdate(query);
    }

}
