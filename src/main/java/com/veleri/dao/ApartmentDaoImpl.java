package com.veleri.dao;

import com.veleri.dao.interfaces.ApartmentDao;
import com.veleri.model.Apartment;
import com.veleri.model.Owner;
import com.veleri.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository("apartment")
public class ApartmentDaoImpl implements ApartmentDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ApartmentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Apartment> getAllApartments() {
        String apartmentSql = "SELECT * FROM apartments;";
        String placeSql = "SELECT * FROM places WHERE id = ?;";
        String ownerSql = "SELECT * FROM places WHERE id = ?;";
        return jdbcTemplate.query(apartmentSql, (resultSet, rowNumber) -> new Apartment(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("price"),
                resultSet.getString("beds"),
                resultSet.getString("stars"),
                jdbcTemplate.queryForObject(placeSql, new Object[]{resultSet.getInt("place_id")}, (rs, rn) -> new Place(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("county")
                )),
                jdbcTemplate.queryForObject(ownerSql, new Object[]{resultSet.getInt("owner_id")}, (rs, rn) -> new Owner(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone_number")
                ))
        ));
    }

    @Override
    public Apartment getApartmentById(int id) {
        String apartmentSql = "SELECT * FROM apartments WHERE id = ?;";
        String placeSql = "SELECT * FROM places WHERE id = ?;";
        String ownerSql = "SELECT * FROM places WHERE id = ?;";
        return jdbcTemplate.queryForObject(apartmentSql, new Object[]{id}, (resultSet, rowNumber) -> new Apartment(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("price"),
                resultSet.getString("beds"),
                resultSet.getString("stars"),
                jdbcTemplate.queryForObject(placeSql, new Object[]{resultSet.getInt("place_id")}, (rs, rn) -> new Place(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("county")
                )),
                jdbcTemplate.queryForObject(ownerSql, new Object[]{resultSet.getInt("owner_id")}, (rs, rn) -> new Owner(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone_number")
                ))
        ));
    }

    @Override
    public void removeApartmentById(int id) {
        try {
            String apartmentSql = "DELETE FROM apartments WHERE id = ?;";
            jdbcTemplate.update(apartmentSql, id);
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void updateApartment(Apartment apartment) {
        try {
            String apartmentSql = "UPDATE apartments SET name = ?, price = ?, beds = ?, stars = ?, place_id = ?, owner_id = ?, WHERE id = ?;";
            jdbcTemplate.update(apartmentSql, new Object[]{
                    apartment.getName(),
                    apartment.getPrice(),
                    apartment.getBeds(),
                    apartment.getStars(),
                    apartment.getPlace().getId(),
                    apartment.getOwner().getId()
            }, apartment.getId());
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void insertApartmentToDb(Apartment apartment) {
        try {
            String apartmentSql = "INSERT INTO apartments (name, price, beds, stars, place_id, owner_id) VALUES (?, ?, ?, ?, ?, ?);";
            jdbcTemplate.update(apartmentSql, new Object[]{
                    apartment.getName(),
                    apartment.getPrice(),
                    apartment.getBeds(),
                    apartment.getStars(),
                    apartment.getPlace().getId(),
                    apartment.getOwner().getId()
            });
        } catch(Exception e) {
            throw e;
        }
    }
}
