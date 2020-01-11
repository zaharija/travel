package com.veleri.dao.interfaces;

import com.veleri.model.Apartment;

import java.util.Collection;

public interface ApartmentDao {
    Collection<Apartment> getAllApartments();

    Apartment getApartmentById(int id);

    void removeApartmentById(int id);

    void updateApartment(Apartment apartment);

    void insertApartmentToDb(Apartment apartment);
}
