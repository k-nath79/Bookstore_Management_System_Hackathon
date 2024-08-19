package com.ust.CustomerService.CustomerService.dto;

public record CustomerDto( long customerId,
         String customerName,
         String email,
         String phone) {
}
