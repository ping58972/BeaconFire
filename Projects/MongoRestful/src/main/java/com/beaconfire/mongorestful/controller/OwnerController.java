package com.beaconfire.mongorestful.controller;

import com.beaconfire.mongorestful.domain.Owner;
import com.beaconfire.mongorestful.domain.Pet;
import com.beaconfire.mongorestful.service.OwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Owner>> findAllOwners(){
        return ResponseEntity.ok(ownerService.findAllOwners());
    }
    @GetMapping(value = "/owner/{id}")
    @ApiOperation(value = "Find owner by id", response = Owner.class)
    public ResponseEntity<Owner> findOwnerById(@PathVariable String id){
        return ResponseEntity.ok(ownerService.findOwnerById(id));
    }
    @PostMapping("/owner")
    @ApiOperation(value = "Save or update Owner")
    public ResponseEntity<Owner> saveOrUpdateOwner(@RequestBody Owner owner){
        return ResponseEntity.ok(ownerService.saveOrUpdateOwner(owner));
    }

    @PutMapping("owner/{id}/pet")
    @ApiOperation(value = "Adding a pet to an existing owner with id")
    public ResponseEntity<Owner> addPetToOwnerById(@PathVariable String id, @RequestBody Pet pet){
        return ResponseEntity.ok(ownerService.addPetToOwnerById(id, pet));
    }

    @DeleteMapping("/owner/{id}")
    @ApiOperation(value = "Delete owner by id")
    public ResponseEntity<String> deleteOwnerById(@PathVariable String id){
        ownerService.deleteOwnerById(id);
        return ResponseEntity.ok("Deleted the Owner by Id: "+id);
    }

}
