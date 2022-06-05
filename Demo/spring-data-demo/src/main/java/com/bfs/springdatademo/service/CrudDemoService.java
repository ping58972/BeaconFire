package com.bfs.springdatademo.service;

import com.bfs.springdatademo.domain.City;
import com.bfs.springdatademo.repository.CrudDemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudDemoService {
    private final CrudDemoRepo repository;

    @Autowired
    public CrudDemoService(CrudDemoRepo repository) {this.repository = repository; }

    public City findCityById(Integer id) {
        return repository.findById(id).orElse(new City());
    }
}
