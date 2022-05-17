package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.domain.Category;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoryRowMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setCategoryId(rs.getInt("category_id"));
        category.setName(rs.getString("name"));
        category.setImageUrl(rs.getString("image_url"));
        return category;
    }
}
