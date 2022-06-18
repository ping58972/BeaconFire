package com.beaconfire.jdbctemplatedemo.dao;

import com.beaconfire.jdbctemplatedemo.domain.Trainee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TraineeRowMapper implements RowMapper<Trainee> {
    @Override
    public Trainee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trainee trainee = new Trainee();
        trainee.setId(rs.getInt("id"));
        trainee.setFirstName(rs.getString("firstName"));
        trainee.setLastName(rs.getString("lastName"));
        trainee.setPhoneNumber(rs.getString("phoneNumber"));
        trainee.setSsn(rs.getString("ssn"));

        return trainee;
    }
}
