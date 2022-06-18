package com.beaconfire.jdbc_template;

import com.beaconfire.jdbc_template.dao.PastryDAO;
import com.beaconfire.jdbc_template.model.Pastry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcTemplateApplication {

    private static PastryDAO pastryDAO;

    public JdbcTemplateApplication(PastryDAO pastryDAO) {
        this.pastryDAO = pastryDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateApplication.class, args);
        // 1. CREATE a pastry
        System.out.println(pastryDAO.createNewPastry("banana milk", 9.99));
        // 2. READ all pastries from the bakery
        pastryDAO.getAllPastry().forEach(System.out::println);
        // 3. READ a pastry by its unique ID
        Pastry pastry = pastryDAO.getPastryById(5);
        System.out.println(pastry);
        // 4. UPDATE a pastry given its unique ID
        System.out.println(pastryDAO.updatePastryById(6, "banana chocolate milk", 8.99));
        // 5. DELETE a pastry by its unique ID
        System.out.println(pastryDAO.deletePastryById(6));

        pastryDAO.getAllPastry().forEach(System.out::println);

    }

}
