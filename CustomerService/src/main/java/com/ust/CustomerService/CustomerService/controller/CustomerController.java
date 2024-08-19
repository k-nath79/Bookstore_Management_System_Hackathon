package com.ust.CustomerService.CustomerService.controller;

import com.ust.CustomerService.CustomerService.dto.CustomerDto;
import com.ust.CustomerService.CustomerService.model.Customer;
import com.ust.CustomerService.CustomerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer createABook(@RequestBody CustomerDto customerDto){
       Customer newCustomer = toEntity(customerDto);
        return customerService.addCustomer(newCustomer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>>findAllCustomers(){
        List<Customer> customer = customerService.fetchAllCustomers();
        return ResponseEntity.status(HttpStatus.FOUND).body(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findACustomer(@PathVariable long id){
        Customer customer = customerService.fetchACustomer(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateACustomer(@PathVariable long id,@RequestBody CustomerDto customerDto){
        Customer newCustomer = toEntity(customerDto);
        return ResponseEntity.status(HttpStatus.FOUND).body(customerService.updateCustomer(id,newCustomer));
    }

    @DeleteMapping("/{id}")
    public void deleteACustomer(@PathVariable long id){
        customerService.deleteCustomer(id);

    }

    public Customer toEntity(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setCustomerId(customerDto.customerId());
        customer.setCustomerName(customerDto.customerName());
        customer.setEmail(customerDto.email());
        customer.setPhone(customerDto.phone());
        return customer;
    }
}
