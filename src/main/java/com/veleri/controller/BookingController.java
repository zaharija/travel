package com.veleri.controller;

import com.veleri.model.Booking;
import com.veleri.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Booking getBookingById(@PathVariable("id") int id) {
        return bookingService.getBookingById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBookingById(@PathVariable("id") int id){
        bookingService.removeBookingById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBookingById(@RequestBody Booking booking){
        bookingService.updateBooking(booking);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertBooking(@RequestBody Booking booking){
        bookingService.insertBooking(booking);
    }
}
