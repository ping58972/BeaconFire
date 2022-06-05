package com.beaconfire.mongorestful.controller;

import com.beaconfire.mongorestful.domain.Owner;
import com.beaconfire.mongorestful.domain.Pet;
import com.beaconfire.mongorestful.service.OwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Owner Controller Restful endpoints")
public class OwnerController {
    private final OwnerService ownerService;
    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @GetMapping(value = "/all-owners")
    @ApiOperation(value = "Find all owners", response = Iterable.class)
    public List<Owner> findAllOwners(){
        return ownerService.findAllOwners();
    }
    @GetMapping(value = "/owner/{id}")
    @ApiOperation(value = "Find owner by id", response = Owner.class)
    public Owner findOwnerById(@PathVariable String id){
        return ownerService.findOwnerById(id);
    }
    @PostMapping("/owner")
    @ApiOperation(value = "Save or update Owner")
    public void saveOrUpdateOwner(@RequestBody Owner owner){
        ownerService.saveOrUpdateOwner(owner);
    }

    @PutMapping("owner/{id}/pet")
    @ApiOperation(value = "Adding a pet to an existing owner with id")
    public void addPetToOwnerById(@PathVariable String id, @RequestBody Pet pet){
        ownerService.addPetToOwnerById(id, pet);
    }

    @DeleteMapping("/owner/{id}")
    @ApiOperation(value = "Delete owner by id")
    public void deleteOwnerById(@PathVariable String id){
        ownerService.deleteOwnerById(id);
    }

}
