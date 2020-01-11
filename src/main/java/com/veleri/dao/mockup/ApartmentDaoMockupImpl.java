package com.veleri.dao.mockup;

import com.veleri.dao.interfaces.ApartmentDao;
import com.veleri.model.Apartment;
import com.veleri.model.Owner;
import com.veleri.model.Place;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ApartmentDaoMockupImpl implements ApartmentDao {
    private static Map<Integer, Apartment> apartments;
/*
    static {
        apartments = new HashMap<Integer, Apartment>() {
            {
                put(1, new Apartment(1, "50", "4", "2", null, new Place(), new Owner()));
                put(2, new Apartment(2, "70", "5", "2", null, new Place(), new Owner()));
                put(3, new Apartment(3, "60", "2", "3", null, new Place(), new Owner()));
                put(4, new Apartment(4, "100", "5", "3", null, new Place(), new Owner()));
                put(5, new Apartment(5, "100", "2", "4", null, new Place(), new Owner()));
                put(6, new Apartment(6, "220", "4", "5", null, new Place(), new Owner()));
            }
        };
    }
*/
    @Override
    public Collection<Apartment> getAllApartments() {
        return this.apartments.values();
    }

    @Override
    public Apartment getApartmentById(int id) {
        return this.apartments.get(id);
    }

    @Override
    public void removeApartmentById(int id) {
        this.apartments.remove(id);
    }

    @Override
    public void updateApartment(Apartment apartment){
        Apartment a = apartments.get(apartment.getId());
        a.setPrice(apartment.getPrice());
        a.setBeds(apartment.getBeds());
        a.setStars(apartment.getStars());
        apartments.put(apartment.getId(), apartment);
    }

    @Override
    public void insertApartmentToDb(Apartment apartment) {
        this.apartments.put(apartment.getId(), apartment);
    }
}
