package com.veleri.service;

import com.veleri.dao.interfaces.OwnerDao;
import com.veleri.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OwnerService {
    private OwnerDao ownerDao;

    @Autowired
    public OwnerService(@Qualifier("owner")OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    public Collection<Owner> getAllOwners() {
        return this.ownerDao.getAllOwners();
    }

    public Owner getOwnerById(int id) {
        return this.ownerDao.getOwnerById(id);
    }

    public void removeOwnerById(int id) {
        this.ownerDao.removeOwnerById(id);
    }

    public void updateOwner(Owner owner){
        this.ownerDao.updateOwner(owner);
    }

    public void insertOwner(Owner owner) {
        this.ownerDao.insertOwnerToDb(owner);
    }
}
