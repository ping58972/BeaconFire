package com.beaconfire.mongorestful.repository;

import com.beaconfire.mongorestful.domain.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepo extends MongoRepository<Owner, String> {

    List<Owner> findOwnerByName(String name);
    List<Owner> findOwnerByIdAndName(String id,String name);
}
