package com.qa.fundamentalproject.rest;
import com.qa.fundamentalproject.domain.Booking;
import com.qa.fundamentalproject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/getAllBooking")
    public List<Booking> getAllBooking(){
        return this.bookingService.readAllBooking();
    }

    @PostMapping("/createBooking")
    public Booking createBooking(@RequestBody Booking booking){
        return this.bookingService.createBooking(booking);

    }

    @DeleteMapping("/deleteBooking/{id}")
    public Boolean deleteBooking(@PathVariable Long id){
        return this.bookingService.deleteBookingById(id);
    }

    @GetMapping("/getBookingById/{id}")
    public Booking getBookingById(@PathVariable Long id){
        return this.bookingService.findBookingById(id);
    }

    @PutMapping("/updateBooking/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking){
        return this.bookingService.updateBooking(id, booking);
    }

}
