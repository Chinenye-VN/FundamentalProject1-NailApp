package com.qa.fundamentalproject.service;

import com.qa.fundamentalproject.domain.Booking;
import com.qa.fundamentalproject.dto.BookingDTO;
import com.qa.fundamentalproject.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.fundamentalproject.exceptions.BookingNotFoundException;
import com.qa.fundamentalproject.exceptions.CustomersNotFoundException;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepository repo;
    private  final ModelMapper mapper;

    @Autowired
    public BookingService(BookingRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private BookingDTO mapToDTO(Booking booking) {
        return this.mapper.map(booking,BookingDTO.class);
    }

    public List<BookingDTO> readAllBooking(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public BookingDTO createBooking(Booking booking){
        return this.mapToDTO(this.repo.save(booking));
    }

    public BookingDTO findBookingById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(BookingNotFoundException::new));
    }

    public BookingDTO updateBooking(Long id, Booking booking){
        Booking update = this.repo.findById(id).orElseThrow(BookingNotFoundException::new);
        update.setTreatment(booking.getTreatment());
        update.setTotalPrice(booking.getTotalPrice());
        return this.mapToDTO(this.repo.save(update));
    }

    public Boolean deleteBookingById(Long id){
        if(!this.repo.existsById(id)){
            throw new CustomersNotFoundException(); //if the id doesnt exist return the exception "this customer isn't found"
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
