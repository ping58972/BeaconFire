package com.bfs.testingdemo.service;

import com.bfs.testingdemo.dao.CityDao;
import com.bfs.testingdemo.domain.City;
import com.bfs.testingdemo.exception.CustomException;
import com.bfs.testingdemo.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    private final CityDao cityDao;

    @Autowired
    public CityService(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public City getCityById(int id) throws DataNotFoundException {
        return Optional.ofNullable(cityDao.getCityById(id))
                .orElseThrow(() -> new DataNotFoundException("City not found"));
    }
    public City saveCity(City city) throws CustomException {
        if (cityDao.checkExistingCountryCode(city.getCountryCode())) {
            throw new CustomException("Country code already exists");
        }
        return cityDao.addCity(city);
    }

    public void testException() throws CustomException {
        throw new CustomException("throwing custom message");
    }
}
