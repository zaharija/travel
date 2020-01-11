package com.veleri.service;

import com.veleri.dao.interfaces.PlaceDao;
import com.veleri.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlaceService {
    private PlaceDao placeDao;

    @Autowired
    public PlaceService(@Qualifier("place")PlaceDao ownerDao) {
        this.placeDao = ownerDao;
    }

    public Collection<Place> getAllPlaces() {
        return this.placeDao.getAllPlaces();
    }

    public Place getPlaceById(int id) {
        return this.placeDao.getPlaceById(id);
    }

    public void removePlaceById(int id) {
        this.placeDao.removePlaceById(id);
    }

    public void updatePlace(Place place){
        this.placeDao.updatePlace(place);
    }

    public void insertPlace(Place place) {
        this.placeDao.insertPlaceToDb(place);
    }
}
