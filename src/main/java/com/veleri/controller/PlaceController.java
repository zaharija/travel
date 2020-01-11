package com.veleri.controller;

import com.veleri.model.Place;
import com.veleri.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Place getPlaceById(@PathVariable("id") int id) {
        return placeService.getPlaceById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePlaceById(@PathVariable("id") int id){
        placeService.removePlaceById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePlaceById(@RequestBody Place place){
        placeService.updatePlace(place);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertPlace(@RequestBody Place place){
        placeService.insertPlace(place);
    }
}
