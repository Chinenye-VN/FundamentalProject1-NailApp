package com.qa.fundamentalproject.service;
import com.qa.fundamentalproject.domain.Booking;
import com.qa.fundamentalproject.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.fundamentalproject.exceptions.BookingNotFoundException;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository repo;

    @Autowired
    public BookingService(BookingRepository repo) {
        this.repo = repo;
    }

    public List<Booking> readAllBooking(){
        return this.repo.findAll();
    }

    public Booking createBooking(Booking booking){

        return this.repo.save(booking);
    }

    public Booking findBookingById(Long id){
        return this.repo.findById(id).orElseThrow(BookingNotFoundException::new);
    }

    public Booking updateBooking(Long id, Booking booking){
        Booking update = findBookingById(id);
        update.setTreatment(booking.getTreatment());
        update.setDateBooked(booking.getDateBooked());
        update.setTotalPrice(booking.getTotalPrice());

        return this.repo.save(update);
    }

    public Boolean deleteBookingById(Long id){
        if(!this.repo.existsById(id)){
            throw new BookingNotFoundException(); //if the id doesnt exist return the exception "this booking isn't found"
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
