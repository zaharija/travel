package com.veleri.service;

import com.veleri.dao.interfaces.BookingDao;
import com.veleri.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookingService {
    private BookingDao bookingDao;

    @Autowired
    public BookingService(@Qualifier("booking")BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public Collection<Booking> getAllBookings() {
        return this.bookingDao.getAllBookings();
    }

    public Booking getBookingById(int id) {
        return this.bookingDao.getBookingById(id);
    }

    public void removeBookingById(int id) {
        this.bookingDao.removeBookingById(id);
    }

    public void updateBooking(Booking booking){
        this.bookingDao.updateBooking(booking);
    }

    public void insertBooking(Booking booking) {
        this.bookingDao.insertBookingToDb(booking);
    }
}
