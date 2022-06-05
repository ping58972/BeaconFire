package com.bfs.springdatademo.controller;

import com.bfs.springdatademo.domain.City;
import com.bfs.springdatademo.service.PageDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PageDemoController {
    private final PageDemoService service;

    @Autowired
    public PageDemoController(PageDemoService service) {
        this.service = service;
    }

    @GetMapping("/city/page/{page}")
    public List<City> findThreeCitiesByPage(@PathVariable int page) {
        return service.findCitiesByPage(page, 3);
    }
}
