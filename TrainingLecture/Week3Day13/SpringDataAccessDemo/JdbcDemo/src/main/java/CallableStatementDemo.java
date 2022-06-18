import domain.Trainee;
import sun.text.normalizer.Trie;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CallableStatementDemo {

    // JDBC configuration
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://beaconfiretraining.cvjh8ezt6tlh.us-east-1.rds.amazonaws.com/JavaBackendTraining";
    static final String USER = "admin";
    static final String PASSWORD = "Beaconfire#2022";

    public static void main(String[] args) {
        List<Trainee> trainees = getAllTrainees();
        trainees.forEach(System.out::println);
    }


    public static List<Trainee> getAllTrainees(){

        List<Trainee> trainees = new ArrayList<>();

        Connection conn = null;
        CallableStatement statement = null;
        String queryStr = "{call getAllTrainee()}";

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = conn.prepareCall(queryStr);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phoneNumber = resultSet.getString("phoneNumber");
                String ssn = resultSet.getString("ssn");

                Trainee trainee = new Trainee(id, firstName, lastName, phoneNumber, ssn);
                trainees.add(trainee);

            }
            resultSet.close();
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
        return trainees;
    }

}
