package com.bfs.testingdemo.controller;


import com.bfs.testingdemo.domain.City;
import com.bfs.testingdemo.exception.CustomException;
import com.bfs.testingdemo.exception.DataNotFoundException;
import com.bfs.testingdemo.service.CityService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping("/city/test")
    public City getCitytest() {
        return new City();
    }

    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable int id) throws DataNotFoundException {
        return service.getCityById(id);
    }

    @PostMapping("/city")
    public City saveCity(@RequestBody City city) throws CustomException {
        return service.saveCity(city);
    }
}
