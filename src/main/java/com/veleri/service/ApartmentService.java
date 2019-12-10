package com.veleri.service;

import com.veleri.dao.ApartmentDaoMockupImpl;
import com.veleri.model.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ApartmentService {
    @Autowired
    private ApartmentDaoMockupImpl apartmentDao;

    public Collection<Apartment> getAllApartments() {
        return this.apartmentDao.getAllApartments();
    }

    public Apartment getApartmentById(int id) {
        return this.apartmentDao.getApartmentById(id);
    }

    public void removeApartmentById(int id) {
        this.apartmentDao.removeApartmentById(id);
    }

    public void updateApartment(Apartment apartment){
        this.apartmentDao.updateApartment(apartment);
    }

    public void insertApartment(Apartment apartment) {
        this.apartmentDao.insertApartmentToDb(apartment);
    }
}
