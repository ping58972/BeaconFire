package com.bfs.springdatademo.controller;

import com.bfs.springdatademo.domain.City;
import com.bfs.springdatademo.service.JpaDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JpaDemoController {
    private final JpaDemoService service;

    @Autowired
    public JpaDemoController(JpaDemoService service) {
        this.service = service;
    }

    @GetMapping(value = "/city", params = "country")
    public List<City> findCitiesByCountryCode(@RequestParam(name = "country") String countryCode) {
        return service.findCitiesByCountryCode(countryCode);
    }

    @GetMapping("/top10/city")
    public List<City> findTop10CitiesByPopulation() {
        return service.findTop10CitiesByPopulation();
    }

    @GetMapping(value = "/cities-start-with-char", params = "leadingchar")
    public List<City> findAllCitiesThatStartWithACharacter(@RequestParam(name = "leadingchar") char c) {
        return service.findAllCitiesThatStartWithACharacter(c);
    }

    @GetMapping("/caching/{id}")
    public City invokingCachedMethod(@PathVariable Integer id) {
        return service.findCityById(id);
    }
}
