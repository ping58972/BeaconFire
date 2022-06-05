package com.bfs.springdatademo.repository;

import com.bfs.springdatademo.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudDemoRepo extends CrudRepository<City, Integer> {
    // marker interface has no fields nor methods
}
