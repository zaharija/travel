package com.veleri.dao;

import com.veleri.dao.interfaces.OwnerDao;
import com.veleri.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository("owner")
public class OwnerDaoImpl implements OwnerDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OwnerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Owner> getAllOwners() {
        String adminSql = "SELECT * FROM owners;";
        return jdbcTemplate.query(adminSql, (resultSet, rowNumber) -> new Owner(
                        resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number")
                )
        );
    }

    @Override
    public Owner getOwnerById(int id) {
        String adminSql = "SELECT * FROM owners WHERE id = ?;";
        return jdbcTemplate.queryForObject(adminSql, new Object[]{id}, (resultSet, rowNumber) -> new Owner(
                        resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number")
                )
        );
    }

    @Override
    public void removeOwnerById(int id) {
        try {
            String ownerSql = "DELETE FROM owners WHERE id = ?;";
            jdbcTemplate.update(ownerSql, id);
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void updateOwner(Owner owner) {
        try {
            String adminSql = "UPDATE owners SET full_name = ?, email = ?, password = ?, phone_number = ? WHERE id = ?;";
            jdbcTemplate.update(adminSql, new Object[]{
                    owner.getFullName(),
                    owner.getEmail(),
                    owner.getPhoneNumber()
            }, owner.getId());
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void insertOwnerToDb(Owner owner) {
        try {
            String ownerSql = "INSERT INTO owners (full_name, email, phone_number) VALUES (?, ?, ?);";
            jdbcTemplate.update(ownerSql, new Object[]{
                    owner.getFullName(),
                    owner.getEmail(),
                    owner.getPhoneNumber()
            });
        } catch(Exception e) {
            throw e;
        }
    }
}
