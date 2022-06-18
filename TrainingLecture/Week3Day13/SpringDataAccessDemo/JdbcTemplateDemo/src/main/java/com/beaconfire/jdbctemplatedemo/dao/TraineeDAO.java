package com.beaconfire.jdbctemplatedemo.dao;

import com.beaconfire.jdbctemplatedemo.domain.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TraineeDAO {

    JdbcTemplate jdbcTemplate;
    TraineeRowMapper rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public TraineeDAO(JdbcTemplate jdbcTemplate, TraineeRowMapper rowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Integer getTraineeCount(){
        String query = "SELECT COUNT(*) FROM trainee";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public List<Trainee> getAllTrainees(){
        String query = "SELECT * FROM trainee";

        List<Trainee> trainees = jdbcTemplate.query(query, rowMapper);

        return trainees;
    }

    public void createNewTrainee(String firstName, String lastName, String email, String ssn){
        String query = "INSERT INTO trainee (firstname, lastname, phoneNumber, ssn) values (?, ?, ?, ?)";
        jdbcTemplate.update(query, firstName, lastName, email, ssn);
    }

    public Trainee getTraineeById(Integer id, String firstName){
        String query = "SELECT * FROM trainee WHERE id = ? and firstName = ?";
        List<Trainee> trainees =  jdbcTemplate.query(query, rowMapper, id, firstName);
        return trainees.size() == 0 ? null : trainees.get(0);
    }

    public Trainee getTraineeByIdAgain(Integer id){
        String query = "SELECT * FROM trainee WHERE id = :identity ";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("identity", id);
        List<Trainee> trainees = namedParameterJdbcTemplate.query(query, parameterSource, rowMapper);

        return trainees.size() == 0 ? null : trainees.get(0);

    }

    public List<Trainee> getTraineeByIds(List<Integer> ids){
        String query = "SELECT * FROM trainee WHERE id IN (:ids)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("ids", ids);
        return namedParameterJdbcTemplate.query(query, parameterSource, rowMapper);
    }
}
