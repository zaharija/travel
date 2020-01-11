package com.veleri.dao.interfaces;

import com.veleri.model.Admin;

import java.util.Collection;

public interface AdminDao {
    Collection<Admin> getAllAdmins();

    Admin getAdminById(int id);

    void removeAdminById(int id);

    void updateAdmin(Admin admin);

    void insertAdminToDb(Admin admin);
}
