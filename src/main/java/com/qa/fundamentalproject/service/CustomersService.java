package com.qa.fundamentalproject.service;

import com.qa.fundamentalproject.domain.Customers;
import com.qa.fundamentalproject.repo.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomersService {
    private final CustomersRepository repo;

    @Autowired
    public CustomersService(CustomersRepository repo) {
        this.repo = repo;
    }

    public List<Customers> readAllCustomers(){
        return this.repo.findAll();
    }

    public Customers createCustomers(Customers customers){
        return this.repo.save(customers);
    }

    public Customers findNoteById(Long id){
        return this.repo.findById(id).orElseThrow(NoteNotFoundException::new);
    }

    public Customers updateCustomers(Long id, Customers customer){
        Customers update = findNoteById(id);
        update.setName(Customers.getName());
        update.setEmail(Customers.getEmail());
        update.setPassword(Customers.getPassword());
        update.setPhoneNumber(Customers.getPhoneNumber());
        return this.repo.save(update);
    }

    public Boolean deleteNoteById(Long id){
        if(!this.repo.existsById(id)){
            throw new NoteNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
