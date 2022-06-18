package com.beaconfire.mongorestful.service;

import com.beaconfire.mongorestful.domain.Owner;
import com.beaconfire.mongorestful.domain.Pet;
import com.beaconfire.mongorestful.repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepo ownerRepo;
    @Autowired
    public OwnerService(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }
    public List<Owner> findAllOwners(){
        return ownerRepo.findAll();
    }
    public Owner findOwnerById(String id){
        return ownerRepo.findById(id).orElse(new Owner());
    }

    public Owner saveOrUpdateOwner(Owner owner){
        return ownerRepo.save(owner);
    }
    public Owner addPetToOwnerById(String id, Pet pet){
        Owner owner = ownerRepo.findById(id).orElse(new Owner());
        List<Pet> pets = owner.getPets();
        pets.add(pet);
        return ownerRepo.save(owner);
    }
    public String deleteOwnerById(String id){
        ownerRepo.deleteById(id);
        return id;
    }
}
