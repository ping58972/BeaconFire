package com.bfs.springdatademo.controller;

import com.bfs.springdatademo.domain.City;
import com.bfs.springdatademo.service.CrudDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CrudDemoController {
    private final CrudDemoService service;

    @Autowired
    public CrudDemoController(CrudDemoService service) {this.service = service; }

    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable int id) {return service.findCityById(id); }

}
