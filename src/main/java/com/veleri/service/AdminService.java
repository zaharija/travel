package com.veleri.service;

import com.veleri.dao.interfaces.AdminDao;
import com.veleri.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AdminService {
    private AdminDao adminDao;

    @Autowired
    public AdminService(@Qualifier("admin")AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public Collection<Admin> getAllAdmins() {
        return this.adminDao.getAllAdmins();
    }

    public Admin getAdminById(int id) {
        return this.adminDao.getAdminById(id);
    }

    public void removeAdminById(int id) {
        this.adminDao.removeAdminById(id);
    }

    public void updateAdmin(Admin admin){
        this.adminDao.updateAdmin(admin);
    }

    public void insertAdmin(Admin admin) {
        this.adminDao.insertAdminToDb(admin);
    }
}
