package com.veleri.service;

import com.veleri.dao.interfaces.UserDao;
import com.veleri.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(@Qualifier("user")UserDao userDao) {
        this.userDao = userDao;
    }

    public Collection<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    public void removeUserById(int id) {
        this.userDao.removeUserById(id);
    }

    public void updateUser(User user){
        this.userDao.updateUser(user);
    }

    public void insertUser(User user) {
        Collection<User> dbUsers = this.userDao.getAllUsers();
        Boolean flag = false;
        for (User dbUser : dbUsers) {
            if(dbUser.getEmail().equals(user.getEmail())) {
                flag = true;
                break;
            }
        }
        if(!flag) this.userDao.insertUserToDb(user);
    }

    public Boolean loginUser(User user) {
        Collection<User> dbUsers = this.userDao.getAllUsers();
        Boolean flag = false;
        for (User dbUser : dbUsers) {
            if(dbUser.getEmail().equals(user.getEmail())) {
                if(dbUser.getPassword().equals(user.getPassword())) {
                    flag = true;
                    break;
                }
            }
        }
        if(flag) return true;
        else return false;
    }
}
