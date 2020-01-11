package com.veleri.controller;

import com.veleri.model.Admin;
import com.veleri.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Admin getAdminById(@PathVariable("id") int id) {
        return adminService.getAdminById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteApartmentById(@PathVariable("id") int id){
        adminService.removeAdminById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateApartmentById(@RequestBody Admin admin){
        adminService.updateAdmin(admin);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertApartment(@RequestBody Admin admin){
        adminService.insertAdmin(admin);
    }
}
