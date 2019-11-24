package com.veleri.rwa.oot.Service;

import com.veleri.rwa.oot.Dao.ApartmentDao;
import com.veleri.rwa.oot.Entity.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ApartmentService {
    @Autowired
    private ApartmentDao apartmentDao;

    public Collection<Apartment> getAllApartments() {
        return this.apartmentDao.getAllApartments();
    }

    public Apartment getApartmentById(int id) {
        return this.apartmentDao.getApartmentById(id);
    }
}
