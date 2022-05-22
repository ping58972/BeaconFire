package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.dao.jdbc.rowmapper.CategoryRowMapper;
import com.beaconfire.quizonline.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CategoryDao {
    List<Category> getAllCategory();

    Optional<Category> getCategoryById(Integer id);

    Optional<Category> getCategoryByName(String name);

    int createNewCategory(String name, String imageUrl);

    int updateCategory(int id, String name, String imageUrl);

    int deleteCategoryById(Integer id);
}
