package com.beaconfire.jdbc_template.dao;

import com.beaconfire.jdbc_template.model.Pastry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PastryDAO {
    JdbcTemplate jdbcTemplate;
    PastryRowMapper rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public PastryDAO(JdbcTemplate jdbcTemplate, PastryRowMapper rowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // 1. CREATE a pastry
    public int createNewPastry(String name, Double price){
        String query = "INSERT INTO pastry (name, price) values (?, ?)";
        return jdbcTemplate.update(query, name, price);
    }
    // 2. READ all pastries from the bakery
    public List<Pastry> getAllPastry(){
        String query = "SELECT * FROM pastry";
        List<Pastry> pastries = jdbcTemplate.query(query, rowMapper);
        return pastries;
    }
    // 3. READ a pastry by its unique ID
    public Pastry getPastryById(Integer id){
        String query = "SELECT * FROM pastry WHERE id = :identity ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("identity", id);
        List<Pastry> pastries = namedParameterJdbcTemplate.query(query, parameterSource ,rowMapper);
        return pastries.size() == 0 ? null : pastries.get(0);
    }
    // 4. UPDATE a pastry given its unique ID
    public int updatePastryById(Integer id, String name, Double price){
        String query = "UPDATE pastry SET name=?, price=? WHERE id=?";
        return jdbcTemplate.update(query, name, price, id);

    }
    // 5. DELETE a pastry by its unique ID
    public int deletePastryById(Integer id){
        String query = "DELETE FROM pastry WHERE id=?";
        return jdbcTemplate.update(query, id);
    }

}
