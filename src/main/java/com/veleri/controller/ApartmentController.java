package com.veleri.controller;

import com.veleri.model.Apartment;
import com.veleri.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Apartment> getAllApartments() {
        return apartmentService.getAllApartments();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Apartment getApartmentById(@PathVariable("id") int id) {
        return apartmentService.getApartmentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteApartmentById(@PathVariable("id") int id){
        apartmentService.removeApartmentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateApartmentById(@RequestBody Apartment apartment){
        apartmentService.updateApartment(apartment);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertApartment(@RequestBody Apartment apartment){
        apartmentService.insertApartment(apartment);
    }
}
