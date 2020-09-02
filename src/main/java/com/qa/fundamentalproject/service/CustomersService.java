package com.qa.fundamentalproject.service;

import com.qa.fundamentalproject.domain.Customers;
import com.qa.fundamentalproject.dto.CustomersDTO;
import com.qa.fundamentalproject.repo.CustomersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.fundamentalproject.exceptions.CustomersNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersService {
    private final CustomersRepository repo;
    private final ModelMapper mapper;

    @Autowired
    public CustomersService(CustomersRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    private CustomersDTO mapToDTO(Customers customers) {
        return this.mapper.map(customers,CustomersDTO.class);
    }

    public List<CustomersDTO> readAllCustomers(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CustomersDTO createCustomers(Customers customers){

        return this.mapToDTO(this.repo.save(customers));
    }

    public CustomersDTO findCustomerById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(CustomersNotFoundException::new));
    }

    public CustomersDTO updateCustomers(Long id, Customers customer){
        Customers update = this.repo.findById(id).orElseThrow(CustomersNotFoundException::new);
        update.setName(customer.getName());
        update.setEmail(customer.getEmail());
        update.setPassword(customer.getPassword());
        update.setPhoneNumber(customer.getPhoneNumber());
        return this.mapToDTO(this.repo.save(update));
    }

    public Boolean deleteCustomersById(Long id){
        if(!this.repo.existsById(id)){
            throw new CustomersNotFoundException(); //if the id doesnt exist return the exception "this customer isn't found"
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
