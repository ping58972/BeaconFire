package com.bfs.testingdemo.dao;


import com.bfs.testingdemo.domain.City;
import com.bfs.testingdemo.exception.CustomException;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CityDao extends AbstractHibernateDAO<City> {
    public CityDao() {
        setClazz(City.class);
    }

    public City getCityById(Integer id) {
        return findById(id);
    }

    public City addCity(City city) {
        Integer cityId = add(city);
        return getCityById(cityId);
    }

    public boolean checkExistingCountryCode(String code) throws CustomException {
        Query query = getCurrentSession().createQuery("from City c where c.countryCode=:code");
        query.setParameter("code", code);
        List<City> cities = query.getResultList();
        return !cities.isEmpty();
    }

}
