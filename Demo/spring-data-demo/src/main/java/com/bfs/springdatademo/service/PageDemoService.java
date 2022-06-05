package com.bfs.springdatademo.service;

import com.bfs.springdatademo.domain.City;
import com.bfs.springdatademo.repository.PageDemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageDemoService {
    private final PageDemoRepo repository;

    @Autowired
    public PageDemoService(PageDemoRepo repository) {
        this.repository = repository;
    }

    public List<City> findCitiesByPage(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }
}
