package com.qa.fundamentalproject.rest;
import com.qa.fundamentalproject.domain.Customers;
import com.qa.fundamentalproject.dto.CustomersDTO;
import com.qa.fundamentalproject.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

public class CustomersController {
    private final CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService) {

        this.customersService = customersService;
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<CustomersDTO>> getAllCustomers(){

        return ResponseEntity.ok(this.customersService.readAllCustomers());
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomersDTO> createCustomers(@RequestBody Customers customer){
        return new ResponseEntity<CustomersDTO>(this.customersService.createCustomers(customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCustomers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        return this.customersService.deleteCustomersById(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<CustomersDTO> getCustomersById(@PathVariable Long id){
        return ResponseEntity.ok(this.customersService.findCustomerById(id));
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<CustomersDTO> updateCustomers(@PathVariable Long id, @RequestBody Customers customer){
        return ResponseEntity.ok(this.customersService.updateCustomers(id, customer));
    }

}
