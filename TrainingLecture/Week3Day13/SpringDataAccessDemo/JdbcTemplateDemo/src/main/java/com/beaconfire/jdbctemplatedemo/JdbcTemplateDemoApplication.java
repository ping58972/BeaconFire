package com.beaconfire.jdbctemplatedemo;

import com.beaconfire.jdbctemplatedemo.dao.TraineeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class JdbcTemplateDemoApplication {

    private static TraineeDAO traineeDAO;

    @Autowired
    public JdbcTemplateDemoApplication(TraineeDAO traineeDAO) {
        this.traineeDAO = traineeDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateDemoApplication.class, args);

//        System.out.println(traineeDAO.getTraineeCount());


//        traineeDAO.createNewTrainee("Aiden", "Gong", "9871234567", "00099911");

//        traineeDAO.getAllTrainees()
//                .forEach((trainee) -> System.out.println(trainee));

//        System.out.println(traineeDAO.getTraineeById(11, "Oliver"));

//        System.out.println(traineeDAO.getTraineeByIdAgain(1));

        traineeDAO.getTraineeByIds(Arrays.asList(1,2,3))
                .forEach((trainee) -> System.out.println(trainee));

    }



}
