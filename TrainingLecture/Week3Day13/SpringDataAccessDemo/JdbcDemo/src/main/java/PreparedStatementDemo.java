import domain.Trainee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementDemo {

    // JDBC configuration
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://beaconfiretraining.cvjh8ezt6tlh.us-east-1.rds.amazonaws.com/JavaBackendTraining";
    static final String USER = "admin";
    static final String PASSWORD = "Beaconfire#2022";


    public static void main(String[] args) {
        List<Trainee> traineeList1 = getTraineesByPhoneNumber("1234567890");
        List<Trainee> traineeList2 = getTraineesByPhoneNumber("'attack' or 1 = 1");

        traineeList2.forEach(System.out::println);
    }


    public static List<Trainee> getTraineesByPhoneNumber(String phone){

        List<Trainee> trainees = new ArrayList<>();

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            String query = "select * from trainee where phoneNumber = ? ";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, phone);

            ResultSet resultSet = preparedStatement.executeQuery();

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
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return trainees;
    }

}
