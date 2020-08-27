package com.qa.fundamentalproject.rest;
import com.qa.fundamentalproject.domain.Customers;
import com.qa.fundamentalproject.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

public class CustomersController {
    private final CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/")
    public List<Customers> getAllCustomers(){
        return this.customersService.readAllCustomers();
    }

    @PostMapping("/createCustomer")
    public Customers createNote(@RequestBody Customers customer){
        return this.customersService.createCustomers(customer);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteCustomer(@PathVariable Long id){
        return this.customersService.deleteCustomersById(id);
    }

    @GetMapping("/getCustomerById/{id}")
    public Customers getCustomersById(@PathVariable Long id){
        return this.customersService.findCustomerById(id);
    }

    @PutMapping("/updateNote/{id}")
    public Customers updateCustomers(@PathVariable Long id, @RequestBody Customers customer){
        return this.customersService.updateCustomers(id, customer);
    }

}
