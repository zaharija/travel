package com.veleri.rwa.oot.Comtroller;

import com.veleri.rwa.oot.Entity.Apartment;
import com.veleri.rwa.oot.Service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
