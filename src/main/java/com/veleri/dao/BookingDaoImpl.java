package com.veleri.dao;

import com.veleri.dao.interfaces.BookingDao;
import com.veleri.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository("booking")
public class BookingDaoImpl implements BookingDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookingDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Booking> getAllBookings() {
        String bookingSql = "SELECT * FROM bookings;";
        String apartmentSql = "SELECT * FROM apartments WHERE id = ?;";
        String placeSql = "SELECT * FROM places WHERE id = ?;";
        String ownerSql = "SELECT * FROM places WHERE id = ?;";
        String userSql = "SELECT * FROM users WHERE id = ?;";
        return jdbcTemplate.query(bookingSql, (resultSet, rowNumber) -> new Booking(
                        resultSet.getInt("id"),
                        resultSet.getDate("bookingStart"),
                        resultSet.getDate("bookingEnd"),
                        jdbcTemplate.queryForObject(userSql, new Object[]{resultSet.getInt("user_id")}, (rs, rn) -> new User(
                                rs.getInt("id"),
                                rs.getString("full_name"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("phone_number"),
                                rs.getString("token")
                        )),
                        jdbcTemplate.queryForObject(apartmentSql, new Object[]{resultSet.getInt("apartment_id")}, (rs, rn) -> new Apartment(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("price"),
                                rs.getString("beds"),
                                rs.getString("stars"),
                                jdbcTemplate.queryForObject(placeSql, new Object[]{rs.getInt("place_id")}, (rsP, rnP) -> new Place(
                                        rsP.getInt("id"),
                                        rsP.getString("name"),
                                        rsP.getString("county")
                                )),
                                jdbcTemplate.queryForObject(ownerSql, new Object[]{resultSet.getInt("owner_id")}, (rsO, rnO) -> new Owner(
                                        rsO.getInt("id"),
                                        rsO.getString("full_name"),
                                        rsO.getString("email"),
                                        rsO.getString("phone_number")
                                ))
                        ))
                )
        );
    }

    @Override
    public Booking getBookingById(int id) {
        String bookingSql = "SELECT * FROM bookings WHERE id = ?;";
        String apartmentSql = "SELECT * FROM apartments WHERE id = ?;";
        String placeSql = "SELECT * FROM places WHERE id = ?;";
        String ownerSql = "SELECT * FROM places WHERE id = ?;";
        String userSql = "SELECT * FROM users WHERE id = ?;";
        return jdbcTemplate.queryForObject(bookingSql, new Object[]{id}, (resultSet, rowNumber) -> new Booking(
                        resultSet.getInt("id"),
                        resultSet.getDate("bookingStart"),
                        resultSet.getDate("bookingEnd"),
                        jdbcTemplate.queryForObject(userSql, new Object[]{resultSet.getInt("user_id")}, (rs, rn) -> new User(
                                rs.getInt("id"),
                                rs.getString("full_name"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("phone_number"),
                                rs.getString("token")
                        )),
                        jdbcTemplate.queryForObject(apartmentSql, new Object[]{resultSet.getInt("apartment_id")}, (rs, rn) -> new Apartment(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("price"),
                                rs.getString("beds"),
                                rs.getString("stars"),
                                jdbcTemplate.queryForObject(placeSql, new Object[]{rs.getInt("place_id")}, (rsP, rnP) -> new Place(
                                        rsP.getInt("id"),
                                        rsP.getString("name"),
                                        rsP.getString("county")
                                )),
                                jdbcTemplate.queryForObject(ownerSql, new Object[]{resultSet.getInt("owner_id")}, (rsO, rnO) -> new Owner(
                                        rsO.getInt("id"),
                                        rsO.getString("full_name"),
                                        rsO.getString("email"),
                                        rsO.getString("phone_number")
                                ))
                        ))
                )
        );
    }

    @Override
    public void removeBookingById(int id) {
        try {
            String bookingSql = "DELETE FROM bookings WHERE id = ?;";
            jdbcTemplate.update(bookingSql, id);
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void updateBooking(Booking booking) {
        try {
            String bookingSql = "UPDATE bookings SET bookingStart = ?, bookingEnd = ?, user_id = ?, apartment_id = ? WHERE id = ?;";
            jdbcTemplate.update(bookingSql, new Object[]{
                    booking.getBookingStart(),
                    booking.getBookingEnd(),
                    booking.getUser().getId(),
                    booking.getApartment().getId()
            }, booking.getId());
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void insertBookingToDb(Booking booking) {
        try {
            String bookingSql = "INSERT INTO bookings (bookingStart, bookingEnd, user_id, apartment_id) VALUES (?, ?, ?, ?);";
            jdbcTemplate.update(bookingSql, new Object[]{
                    booking.getBookingStart(),
                    booking.getBookingEnd(),
                    booking.getUser().getId(),
                    booking.getApartment().getId()
            });
        } catch(Exception e) {
            throw e;
        }
    }
}
