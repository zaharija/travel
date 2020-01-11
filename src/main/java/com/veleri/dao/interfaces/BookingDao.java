package com.veleri.dao.interfaces;

import com.veleri.model.Booking;

import java.util.Collection;

public interface BookingDao {
    Collection<Booking> getAllBookings();

    Booking getBookingById(int id);

    void removeBookingById(int id);

    void updateBooking(Booking booking);

    void insertBookingToDb(Booking booking);
}
