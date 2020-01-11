package com.veleri.dao.interfaces;

import com.veleri.model.Place;

import java.util.Collection;

public interface PlaceDao {
    Collection<Place> getAllPlaces();

    Place getPlaceById(int id);

    void removePlaceById(int id);

    void updatePlace(Place place);

    void insertPlaceToDb(Place place);
}
