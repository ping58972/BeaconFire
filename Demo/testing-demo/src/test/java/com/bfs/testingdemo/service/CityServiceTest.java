package com.bfs.testingdemo.service;


import com.bfs.testingdemo.dao.CityDao;
import com.bfs.testingdemo.domain.City;
import com.bfs.testingdemo.exception.CustomException;
import com.bfs.testingdemo.exception.DataNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {
    @Mock
    private CityDao cityDao;

    @InjectMocks
    private CityService cityService;

//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.openMocks(this);
//    }

    @Test
    void testGetCityById_success() throws DataNotFoundException {
        City expected = new City(
                1,
                "Kabul",
                "AFG",
                "Kabol",
                1780000);
        Mockito.when(cityDao.getCityById(1)).thenReturn(expected);
        assertEquals(expected, cityService.getCityById(1));
    }

    @Test
    void testGetCityById_failed() {
        Mockito.when(cityDao.getCityById(-1)).thenReturn(null);
        assertThrows(DataNotFoundException.class, () -> cityService.getCityById(-1));
    }

    @Test
    void testAddCity() throws CustomException {
        City expectedCity = new City(
                5000,
                "Some city",
                "ZZZ",
                "Some district",
                100000000);
        Mockito.when(cityDao.addCity(expectedCity)).thenReturn(expectedCity);
        City actualCity = cityService.saveCity(expectedCity);
        Mockito.verify(cityDao, Mockito.times(1)).addCity(expectedCity);
        assertEquals(expectedCity, actualCity);
    }

    @Test
    void testAddCity_failedWhenCountryCodeExists() throws CustomException {
        City expectedCity = new City(
                5000,
                "Some city",
                "AFG",
                "Some district",
                100000000);
        Mockito.when(cityDao.checkExistingCountryCode(expectedCity.getCountryCode())).thenReturn(true);

        Mockito.verify(cityDao, Mockito.times(0)).addCity(expectedCity);
        assertThrows(CustomException.class, () -> cityService.saveCity(expectedCity));
    }

    @Test
    void testException() {
        assertThrows(CustomException.class, () -> cityService.testException());
    }
}
