package com.beaconfire.quizonline.dao.jdbc;

import com.beaconfire.quizonline.dao.CategoryDao;
import com.beaconfire.quizonline.dao.jdbc.rowmapper.CategoryRowMapper;
import com.beaconfire.quizonline.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("categoryDaoJdbcImpl")
public class CategoryDaoJdbcImpl implements CategoryDao {
    JdbcTemplate jdbcTemplate;
    CategoryRowMapper categoryRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setCategoryRowMapper(CategoryRowMapper categoryRowMapper) {
        this.categoryRowMapper = categoryRowMapper;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Category> getAllCategory() {
        return jdbcTemplate.query("SELECT * FROM Category", categoryRowMapper);
    }

    public Optional<Category> getCategoryById(Integer id) {
        String query = "SELECT * FROM Category WHERE category_id = ?";
        List<Category> categories = jdbcTemplate.query(query, categoryRowMapper, id);
        return categories.stream().findFirst();
    }

    public Optional<Category> getCategoryByName(String name) {
        String query = "SELECT * FROM Category WHERE name = ?";
        List<Category> categories = jdbcTemplate.query(query, categoryRowMapper, name);
        return categories.stream().findFirst();
    }

    public int createNewCategory(String name, String imageUrl) {
        String query = "INSERT INTO Category(name, imageUrl) VALUES(?, ?)";
        return jdbcTemplate.update(query, name, imageUrl);
    }

    public int updateCategory(int id, String name, String imageUrl) {
        String query = "UPDATE Category SET name=?, image_url=? WHERE category_id=?";
        return jdbcTemplate.update(query, name, imageUrl, id);
    }

    public int deleteCategoryById(Integer id) {
        String query = "DELETE FROM Category WHERE category_id=?";
        return jdbcTemplate.update(query, id);
    }
}
