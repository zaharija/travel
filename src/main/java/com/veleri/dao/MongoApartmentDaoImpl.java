package com.veleri.dao;

import com.veleri.model.Apartment;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class MongoApartmentDaoImpl implements ApartmentDao {

    @Override
    public Collection<Apartment> getAllApartments() {
        return null;
    }

    @Override
    public Apartment getApartmentById(int id) {
        return null;
    }

    @Override
    public void removeApartmentById(int id) {

    }

    @Override
    public void updateApartment(Apartment apartment) {

    }

    @Override
    public void insertApartmentToDb(Apartment apartment) {

    }
}
