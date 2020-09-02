package com.qa.fundamentalproject.rest;

import com.qa.fundamentalproject.domain.Booking;
import com.qa.fundamentalproject.dto.BookingDTO;
import com.qa.fundamentalproject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/getAllBooking")
    public ResponseEntity<List<BookingDTO>>getAllBooking(){
        return ResponseEntity.ok(this.bookingService.readAllBooking());
    }

    @PostMapping("/createBooking")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody Booking booking){
        return new ResponseEntity<BookingDTO>(this.bookingService.createBooking(booking), HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id){
        return this.bookingService.deleteBookingById(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getBookingById/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id){
        return ResponseEntity.ok(this.bookingService.findBookingById(id));
    }

    @PutMapping("/updateBooking/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @RequestBody Booking booking){
        return ResponseEntity.ok(this.bookingService.updateBooking(id, booking));
    }

}
