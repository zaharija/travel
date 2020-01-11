package com.veleri.dao;

import com.veleri.dao.interfaces.PlaceDao;
import com.veleri.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository("place")
public class PlaceDaoImpl implements PlaceDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PlaceDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Place> getAllPlaces() {
        String placeSql = "SELECT * FROM places;";
        return jdbcTemplate.query(placeSql, (resultSet, rowNumber) -> new Place(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("county")
                )
        );
    }

    @Override
    public Place getPlaceById(int id) {
        String placeSql = "SELECT * FROM places WHERE id = ?;";
        return jdbcTemplate.queryForObject(placeSql, new Object[]{id}, (resultSet, rowNumber) -> new Place(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("county")
                )
        );
    }

    @Override
    public void removePlaceById(int id) {
        try {
            String placeSql = "DELETE FROM places WHERE id = ?;";
            jdbcTemplate.update(placeSql, id);
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void updatePlace(Place place) {
        try {
            String adminSql = "UPDATE places SET name = ?, county = ? WHERE id = ?;";
            jdbcTemplate.update(adminSql, new Object[]{
                    place.getName(),
                    place.getCounty()
            }, place.getId());
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void insertPlaceToDb(Place place) {
        try {
            String placeSql = "INSERT INTO places (name, email, county) VALUES (?, ?);";
            jdbcTemplate.update(placeSql, new Object[]{
                    place.getName(),
                    place.getCounty()
            });
        } catch(Exception e) {
            throw e;
        }
    }
}
