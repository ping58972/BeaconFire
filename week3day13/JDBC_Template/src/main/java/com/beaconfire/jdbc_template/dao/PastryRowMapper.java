package com.beaconfire.jdbc_template.dao;

import com.beaconfire.jdbc_template.model.Pastry;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PastryRowMapper implements RowMapper<Pastry> {

    @Override
    public Pastry mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pastry pastry = new Pastry();
        pastry.setId(rs.getInt("id"));
        pastry.setPrice(rs.getFloat("price"));
        pastry.setName(rs.getString("name"));
        return pastry;
    }
}
