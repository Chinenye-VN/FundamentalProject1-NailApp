package com.qa.fundamentalproject.service;

import com.qa.fundamentalproject.domain.Customers;
import com.qa.fundamentalproject.repo.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.fundamentalproject.exceptions.CustomersNotFoundException;
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

    public Customers findCustomerById(Long id){
        return this.repo.findById(id).orElseThrow(CustomersNotFoundException::new);
    }

    public Customers updateCustomers(Long id, Customers customer){
        Customers update = findCustomerById(id);
        update.setName(customer.getName());
        update.setEmail(customer.getEmail());
        update.setPassword(customer.getPassword());
        update.setPhoneNumber(customer.getPhoneNumber());
        return this.repo.save(update);
    }

    public Boolean deleteCustomersById(Long id){
        if(!this.repo.existsById(id)){
            throw new CustomersNotFoundException(); //if the id doesnt exist return the exception "this customer isn't found"
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
