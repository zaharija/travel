package com.veleri.dao.interfaces;

import com.veleri.model.Owner;

import java.util.Collection;

public interface OwnerDao {
    Collection<Owner> getAllOwners();

    Owner getOwnerById(int id);

    void removeOwnerById(int id);

    void updateOwner(Owner owner);

    void insertOwnerToDb(Owner owner);
}
