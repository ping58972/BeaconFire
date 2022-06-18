import domain.TrainingSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatementDemo {

    // JDBC configuration
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://beaconfiretraining.cvjh8ezt6tlh.us-east-1.rds.amazonaws.com/JavaBackendTraining";
    static final String USER = "admin";
    static final String PASSWORD = "Beaconfire#2022";

    public static void main(String[] args) {

        List<TrainingSession> trainingSessions = getAllTrainingSession();


        trainingSessions.forEach((System.out::println));

    }

    public static List<TrainingSession> getAllTrainingSession(){
        Connection conn = null;
        Statement statement = null;
        String queryStr = "select * from trainingSession";
        List<TrainingSession> trainingSessions = new ArrayList<>();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(queryStr);
            while (resultSet.next()) {
                // retrieve using column name
                int id = resultSet.getInt("id");
                String sessionDate = resultSet.getString("sessionDate");
                String topic = resultSet.getString("topic");
                int trainer = resultSet.getInt("trainer");

                // retrieve using column index
//				int id = resultSet.getInt(1);
//				String sessionDate = resultSet.getString(2);
//				String topic = resultSet.getString(3);
//				int trainer = resultSet.getInt(4);

                TrainingSession session = new TrainingSession(id, sessionDate, topic, trainer);
                trainingSessions.add(session);
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

        return trainingSessions;
    }

}
