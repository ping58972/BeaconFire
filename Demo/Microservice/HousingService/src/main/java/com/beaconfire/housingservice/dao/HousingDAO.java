package com.beaconfire.housingservice.dao;

import com.beaconfire.housingservice.entity.House;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class HousingDAO {

    public List<House> getAllHouses(){
        return Arrays.asList(
                House.builder().address("20 W 34th St").city("New York").state("NY").zipCode("10001").build(),
                House.builder().address("45 Rockefeller Plaza").city("New York").state("NY").zipCode("10111").build(),
                House.builder().address("200 Central Park West").city("New York").state("NY").zipCode("10024").build()
        );
    }

}
