package com.veleri.dao;

import com.veleri.dao.interfaces.AdminDao;
import com.veleri.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository("admin")
public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Admin> getAllAdmins() {
        String adminSql = "SELECT * FROM admins;";
        return jdbcTemplate.query(adminSql, (resultSet, rowNumber) -> new Admin(
                        resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("token")
                )
        );
    }

    @Override
    public Admin getAdminById(int id) {
        String adminSql = "SELECT * FROM admins WHERE id = ?;";
        return jdbcTemplate.queryForObject(adminSql, new Object[]{id}, (resultSet, rowNumber) -> new Admin(
                        resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("token")
                )
        );
    }

    @Override
    public void removeAdminById(int id) {
        try {
            String adminSql = "DELETE FROM admins WHERE id = ?;";
            jdbcTemplate.update(adminSql, id);
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void updateAdmin(Admin admin) {
        try {
            String adminSql = "UPDATE admins SET full_name = ?, email = ?, password = ?, token = ? WHERE id = ?;";
            jdbcTemplate.update(adminSql, new Object[]{
                    admin.getFullName(),
                    admin.getEmail(),
                    admin.getPassword(),
                    admin.getToken()
            }, admin.getId());
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void insertAdminToDb(Admin admin) {
        try {
            String adminSql = "INSERT INTO admins (full_name, email, password, token) VALUES (?, ?, ?, ?);";
            jdbcTemplate.update(adminSql, new Object[]{
                    admin.getFullName(),
                    admin.getEmail(),
                    admin.getPassword(),
                    admin.getToken()
            });
        } catch(Exception e) {
            throw e;
        }
    }
}
