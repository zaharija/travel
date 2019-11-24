package com.veleri.rwa.oot.Dao;

import com.veleri.rwa.oot.Entity.Apartment;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ApartmentDao {
    private static Map<Integer, Apartment> apartments;

    static {
        apartments = new HashMap<Integer, Apartment>() {
            {
                put(1, new Apartment(1, 50, 4, 2));
                put(2, new Apartment(2, 70, 5, 2));
                put(3, new Apartment(3, 60, 2, 3));
                put(4, new Apartment(4, 100, 5, 3));
                put(5, new Apartment(5, 100, 2, 4));
                put(6, new Apartment(6, 220, 4, 5));
            }
        };
    }

    public Collection<Apartment> getAllApartments() {
        return this.apartments.values();
    }

    public Apartment getApartmentById(int id) {
        return this.apartments.get(id);
    }
}
