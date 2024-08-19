package com.ust.OrderService.OrderService.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record orderDto(long orderId,
                       @NotNull(message = "Book Id Reqired")
                       long bookId,
                       @NotNull(message = "Cust Id required")
                       long customerId,
                       @NotNull(message = "Quantity needs to be specified")
                       @Min(value = 1)
                       int quantity,
                       @NotEmpty(message = "Status needs to be specified")
                       String status) {
}
