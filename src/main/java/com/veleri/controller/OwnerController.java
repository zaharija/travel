package com.veleri.controller;

import com.veleri.model.Owner;
import com.veleri.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Owner getOwnerById(@PathVariable("id") int id) {
        return ownerService.getOwnerById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOwnerById(@PathVariable("id") int id){
        ownerService.removeOwnerById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOwnerById(@RequestBody Owner owner){
        ownerService.updateOwner(owner);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertOwner(@RequestBody Owner owner){
       ownerService.insertOwner(owner);
    }
}
