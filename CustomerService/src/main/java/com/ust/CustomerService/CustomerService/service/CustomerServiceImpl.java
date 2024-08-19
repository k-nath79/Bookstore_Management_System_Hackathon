package com.ust.CustomerService.CustomerService.service;

import com.ust.CustomerService.CustomerService.model.Customer;
import com.ust.CustomerService.CustomerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(long id, Customer customer) {
        Customer existingCustomer = fetchACustomer(id);
        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        return null;
    }
    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> fetchAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer fetchACustomer(long id) {
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer with id not found"));
    }
}
