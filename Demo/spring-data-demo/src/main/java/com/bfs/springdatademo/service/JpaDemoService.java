package com.bfs.springdatademo.service;

import com.bfs.springdatademo.domain.City;
import com.bfs.springdatademo.repository.JpaDemoRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaDemoService {
    private final JpaDemoRepo repository;

    public JpaDemoService(JpaDemoRepo repository) {
        this.repository = repository;
    }

    public List<City> findCitiesByCountryCode(String countryCode) {
        return repository.findByCountryCodeIgnoreCase(countryCode);
    }

    public List<City> findTop10CitiesByPopulation() {
        return repository.findTop10ByOrderByPopulationDesc();
    }

    public List<City> findAllCitiesThatStartWithACharacter(char c) {
        return repository.findAllCitiesThatStartWithACharacter(c);
    }

    @Cacheable("cities")
    public City findCityById(Integer id) {
        System.out.println("Invoking caching method");
        try {
            System.out.println("Sleeping zzz...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return repository.findById(id).orElse(new City());
    }
}
