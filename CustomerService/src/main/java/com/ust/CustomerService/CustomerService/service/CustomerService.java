package com.ust.CustomerService.CustomerService.service;

import com.ust.CustomerService.CustomerService.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer updateCustomer(long id,Customer customer);
    void deleteCustomer(long id);
    List<Customer> fetchAllCustomers();
    Customer fetchACustomer(long id);
}
